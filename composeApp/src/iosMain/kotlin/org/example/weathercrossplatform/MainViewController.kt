package org.example.weathercrossplatform

import androidx.compose.ui.window.ComposeUIViewController
import com.example.weathercrossplatform.BuildKonfig
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.crashlytics.crashlytics
import dev.gitlive.firebase.initialize
import org.example.weathercrossplatform.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}