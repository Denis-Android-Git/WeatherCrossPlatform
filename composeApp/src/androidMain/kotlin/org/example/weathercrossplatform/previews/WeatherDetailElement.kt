package org.example.weathercrossplatform.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.weathercrossplatform.presentation.WeatherDetailElement

@Preview
@Composable
private fun Preview() {
    WeatherDetailElement(
        title = "Humidity",
        description = "32 %",
        progress = 0.3f
    )
}