package org.example.weathercrossplatform

import androidx.compose.ui.window.ComposeUIViewController
import org.example.weathercrossplatform.di.initKoin
import org.example.weathercrossplatform.presentation.app.App

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}