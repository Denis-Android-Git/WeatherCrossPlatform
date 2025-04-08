package org.example.weathercrossplatform.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.weathercrossplatform.presentation.WeatherDetailElement

@Preview
@Composable
private fun Preview() {
    WeatherDetailElement(
        title = "Pressure",
        description = "32 %",
        humidityProgress = 0.3f,
        windProgress = 0.8f,
        rotation = 320f,
        pressureProgress = 1.2f
    )
}