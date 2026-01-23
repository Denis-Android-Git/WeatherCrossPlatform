package org.example.weathercrossplatform.presentation.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.icerock.moko.permissions.PermissionState
import dev.icerock.moko.permissions.compose.BindEffect
import dev.icerock.moko.permissions.compose.rememberPermissionsControllerFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.example.weathercrossplatform.presentation.navigation.NavHostMainScreen

@Composable
@Preview
fun App() {
    MaterialTheme {

        val factory = rememberPermissionsControllerFactory()
        val controller by rememberUpdatedState(newValue = factory.createPermissionsController())
        val scope = rememberCoroutineScope()

        BindEffect(controller)

        val permissionsViewModel = viewModel {
            PermissionsViewModel(controller)
        }
        Scaffold {
            when (permissionsViewModel.state) {
                PermissionState.Granted -> {
                    //Text(text = "Granted")
                    NavHostMainScreen(
                        modifier = Modifier,//.padding(it),
                        isFirstLaunch = permissionsViewModel.isFirstLaunch
                    )
                    scope.launch {
                        delay(100)
                        permissionsViewModel.isFirstLaunch = false
                    }
                }

                PermissionState.DeniedAlways -> {
                    Box(
                        modifier = Modifier.fillMaxSize().padding(it),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Denied forever")
                    }
                }

                else -> {
                    //Text(text = "Else")
                    scope.launch {
                        delay(100)
                        permissionsViewModel.checkPermissions()
                    }
                }
            }
        }
    }
}