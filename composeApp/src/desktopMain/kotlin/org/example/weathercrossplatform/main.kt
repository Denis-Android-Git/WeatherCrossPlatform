package org.example.weathercrossplatform

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.example.weathercrossplatform.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "WeatherCrossPlatform",
        ) {
            App()
        }
    }
}
