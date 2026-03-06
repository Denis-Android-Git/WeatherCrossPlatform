package com.example.androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.androidapp.inappupdate.InAppUpdateViewModel
import com.example.androidapp.inappupdate.InAppUpdateScreenState
import com.example.androidapp.ui.theme.MyAppTheme
import com.google.android.play.core.appupdate.AppUpdateInfo
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.appupdate.AppUpdateOptions
import com.google.android.play.core.install.InstallStateUpdatedListener
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability
import com.google.android.play.core.ktx.isFlexibleUpdateAllowed
import com.google.android.play.core.ktx.isImmediateUpdateAllowed
import org.example.weathercrossplatform.presentation.app.App

class MainActivity : ComponentActivity() {

    private lateinit var appUpdateManager: AppUpdateManager
    private val updateType = AppUpdateType.FLEXIBLE

    private val updateLauncher =
        registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->
            if (result.resultCode != RESULT_OK) {
                println("Update failed")
            }
        }

    private val inAppUpdateViewModel by viewModels<InAppUpdateViewModel>()

    @OptIn(ExperimentalMaterial3ExpressiveApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appUpdateManager = AppUpdateManagerFactory.create(applicationContext)

        if (updateType == AppUpdateType.FLEXIBLE) {
            appUpdateManager.registerListener(installStateListener)
        }
        checkForUpdate()
        installSplashScreen()
        setContent {
            MyAppTheme {
                App()
                InAppUpdateScreenState(
                    inAppUpdateViewModel,
                    onConfirmation = {
                        appUpdateManager.completeUpdate()
                    },
                    onDismissRequest = {
                        inAppUpdateViewModel.updateConfirmInstall(false)
                    }
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (updateType == AppUpdateType.IMMEDIATE) {
            appUpdateManager.appUpdateInfo.addOnSuccessListener { appUpdateInfo ->
                if (appUpdateInfo.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS) {
                    startUpdateFlow(appUpdateInfo)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        appUpdateManager.unregisterListener(installStateListener)
    }

    private val installStateListener = InstallStateUpdatedListener { installState ->
        when (installState.installStatus()) {
            InstallStatus.DOWNLOADED -> {
                inAppUpdateViewModel.updateIsDownloading(false)
                inAppUpdateViewModel.updateConfirmInstall(true)
            }

            InstallStatus.DOWNLOADING -> {

                inAppUpdateViewModel.updateProgress(
                    bytesDownloaded = installState.bytesDownloaded(),
                    totalBytes = installState.totalBytesToDownload()
                )
            }

            else -> Unit
        }
    }

    private fun checkForUpdate() {
        appUpdateManager.appUpdateInfo.addOnSuccessListener { appUpdateInfo ->
            val isUpdateAvailable =
                appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
            val isUpdateAllowed = when (updateType) {
                AppUpdateType.FLEXIBLE -> appUpdateInfo.isFlexibleUpdateAllowed
                AppUpdateType.IMMEDIATE -> appUpdateInfo.isImmediateUpdateAllowed
                else -> false
            }
            val isUpdateDownloaded = appUpdateInfo.installStatus() == InstallStatus.DOWNLOADED
            if (isUpdateAvailable && isUpdateAllowed) {
                startUpdateFlow(appUpdateInfo)
            } else if (isUpdateDownloaded) {
                inAppUpdateViewModel.updateConfirmInstall(true)
            }
        }
    }

    private fun startUpdateFlow(appUpdateInfo: AppUpdateInfo) {
        appUpdateManager.startUpdateFlowForResult(
            appUpdateInfo,
            updateLauncher,
            AppUpdateOptions.newBuilder(AppUpdateType.FLEXIBLE).build()
        )
    }
}