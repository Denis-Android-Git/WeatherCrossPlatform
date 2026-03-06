package com.example.androidapp.inappupdate

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.example.weathercrossplatform.R

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun UpdateProgressIndicatorState(
    inAppUpdateViewModel: InAppUpdateViewModel,
    onConfirmation: () -> Unit,
    onDismissRequest: () -> Unit
) {

    val progress by inAppUpdateViewModel.progress.collectAsStateWithLifecycle()
    val isDownloading by inAppUpdateViewModel.isDownloading.collectAsStateWithLifecycle()
    val isConfirmInstall by inAppUpdateViewModel.isConfirmInstall.collectAsStateWithLifecycle()

    when {
        isDownloading -> {
            UpdateProgressIndicator(
                progress = progress
            )
        }

        isConfirmInstall -> {
            InstallUpdateDialog(
                onDismissRequest = onDismissRequest,
                onConfirmation = onConfirmation,
                dialogTitle = stringResource(R.string.update_downloaded),
                dialogText = stringResource(R.string.install),
                confirmButtonText = stringResource(R.string.confirm),
                dismissButtonText = stringResource(R.string.dismiss)

            )
        }
    }
}