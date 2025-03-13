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
import org.example.weathercrossplatform.data.locationservice.LocationService
import org.example.weathercrossplatform.data.repo_impl.WeatherRepoImpl
import org.example.weathercrossplatform.viewmodels.PermissionsViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    locationService: LocationService,
    weatherRepoImpl: WeatherRepoImpl
) {
    MaterialTheme {

        val factory = rememberPermissionsControllerFactory()

        val controller by rememberUpdatedState(factory.createPermissionsController())
        BindEffect(controller)

        val permissionsViewModel = viewModel {
            PermissionsViewModel(controller, locationService, weatherRepoImpl)
        }
        val state by permissionsViewModel.state.collectAsStateWithLifecycle()
        val currentWeather by permissionsViewModel.currentWeather.collectAsStateWithLifecycle()
        val error by permissionsViewModel.errorText.collectAsStateWithLifecycle()
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            when (state) {
                PermissionState.Granted -> {
                    Text(text = "Granted")
                    currentWeather?.let {
                        Text(text = "${currentWeather?.current?.tempC}, ${currentWeather?.location?.name}")
                    }
                    error?.let {
                        Text(text = it)
                    }
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