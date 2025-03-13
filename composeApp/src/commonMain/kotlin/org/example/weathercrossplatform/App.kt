package org.example.weathercrossplatform

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.icerock.moko.permissions.PermissionState
import dev.icerock.moko.permissions.compose.BindEffect
import dev.icerock.moko.permissions.compose.rememberPermissionsControllerFactory
import org.example.weathercrossplatform.presentation.MainScreen
import org.example.weathercrossplatform.viewmodels.PermissionsViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    MaterialTheme {

        KoinContext {

            val factory = rememberPermissionsControllerFactory()

            val controller by rememberUpdatedState(factory.createPermissionsController())
            BindEffect(controller)

            val permissionsViewModel = viewModel {
                PermissionsViewModel(
                    permissionsController = controller
                )
            }

            val state by permissionsViewModel.state.collectAsStateWithLifecycle()

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                when (state) {
                    PermissionState.Granted -> {
                        MainScreen()
                    }

                    PermissionState.DeniedAlways -> {
                        Text(text = "Denied forever")
                    }

                    else -> {
                        permissionsViewModel.checkPermissions()
                        Text(text = "Else")
                    }
                }
            }
        }
    }
}