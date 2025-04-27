package org.example.weathercrossplatform.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.weathercrossplatform.presentation.WeatherDetailElement

@Preview
@Composable
private fun Preview() {
    WeatherDetailElement(
        title = "Wind",
        description = "32 %",
        humidity = 0.3f,
        windProgress = 0.8f,
        windRotation = 320f,
        pressureProgress = 1.2f,
        cloudsProgress = 0.5f,
        uvIndex = "2"
    )
}