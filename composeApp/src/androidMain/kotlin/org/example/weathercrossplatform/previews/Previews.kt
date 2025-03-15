package org.example.weathercrossplatform.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.weathercrossplatform.presentation.MainScreen

@Preview
@Composable
fun Test() {
    MainScreen(
        isLoading = false,
        image = "",
        usEpaIndex = 6,
        locationName = "Here",
        temp = "20",
        condition = "Good",
        feelsLikeC = "25",
        error = ""
    )
}