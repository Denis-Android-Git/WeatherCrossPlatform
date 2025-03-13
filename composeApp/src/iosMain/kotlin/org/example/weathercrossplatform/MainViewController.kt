package org.example.weathercrossplatform

import androidx.compose.ui.window.ComposeUIViewController
import org.example.weathercrossplatform.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}