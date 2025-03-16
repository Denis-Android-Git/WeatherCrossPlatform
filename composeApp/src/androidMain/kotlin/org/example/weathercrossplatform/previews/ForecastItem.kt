package org.example.weathercrossplatform.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.weathercrossplatform.presentation.ForecastItem


@Preview
@Composable
private fun Preview() {
    ForecastItem(
        date = "Today",
        low = "-1",
        high = "+2",
        image = ""
    )
}