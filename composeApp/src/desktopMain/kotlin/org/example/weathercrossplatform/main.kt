package org.example.weathercrossplatform

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.example.weathercrossplatform.data.locationservice.LocationService

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "WeatherCrossPlatform",
    ) {
        App(
            locationService = LocationService()
        )
    }
}