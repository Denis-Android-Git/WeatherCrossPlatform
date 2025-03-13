package org.example.weathercrossplatform

import androidx.compose.ui.window.ComposeUIViewController
import org.example.weathercrossplatform.data.locationservice.LocationService

fun MainViewController() = ComposeUIViewController {
    App(
        locationService = LocationService()
    )
}