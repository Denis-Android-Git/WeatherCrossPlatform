package org.example.weathercrossplatform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import org.example.weathercrossplatform.presentation.app.App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        setContent {
            App()
//            InfiniteNumberPicker(
//                range = 1..24,
//                itemHeight = 50.dp,
//                visibleItems = 5,
//
//            )
        }
    }
}