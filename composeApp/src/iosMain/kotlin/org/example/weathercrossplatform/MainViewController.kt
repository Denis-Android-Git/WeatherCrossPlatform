package org.example.weathercrossplatform

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import io.ktor.client.engine.darwin.Darwin
import org.example.weathercrossplatform.data.locationservice.LocationService
import org.example.weathercrossplatform.data.repo_impl.WeatherRepoImpl
import org.example.weathercrossplatform.data.repo_impl.createHttpClient

fun MainViewController() = ComposeUIViewController {
    App(
        locationService = remember {
            LocationService()
        },
        weatherRepoImpl = remember {
            WeatherRepoImpl(createHttpClient(Darwin.create()))
        },
    )
}