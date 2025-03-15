package org.example.weathercrossplatform.previews

import androidx.compose.runtime.Composable
import org.example.weathercrossplatform.domain.models.WeatherMainScreenState
import org.example.weathercrossplatform.presentation.MainScreen

@androidx.compose.ui.tooling.preview.Preview
@Composable
fun Test() {
    MainScreen(
        weatherMainScreenState = WeatherMainScreenState()
    )
}