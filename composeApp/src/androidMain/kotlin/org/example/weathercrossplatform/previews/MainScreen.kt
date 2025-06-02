package org.example.weathercrossplatform.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.weathercrossplatform.presentation.MainScreen

@Preview
@Composable
private fun Preview() {
    MainScreen(
        isLoading = false,
        image = "",
        usEpaIndex = 6,
        locationName = "Here",
        temp = 20.0,
        condition = "Good",
        feelsLikeC = "25",
        error = "",
        forecastList = null,
        weatherItemList = emptyList(),
        onAddButtonClick = {},
        isAddCity = true,
        onCancelButtonClick = { },
        onAddCityButtonClick = {},
        //latitude = 0.0,
        //longitude = 0.0,
        highTemp = 20.0,
        lowTemp = 10.0,
        savedCityList = emptyList()
    )
}