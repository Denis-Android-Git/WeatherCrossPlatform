package org.example.weathercrossplatform.previews

import android.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.weathercrossplatform.presentation.ForecastRowItem

@Preview
@Composable
private fun Preview() {
    ForecastRowItem(
        temp = "2",
        icon = R.drawable.star_on,
        wind = "25,5",
        time = "16:00",
        previousTemp = -1f,
        maxTemp = 11f,
        minTemp = -2f,
    )
}