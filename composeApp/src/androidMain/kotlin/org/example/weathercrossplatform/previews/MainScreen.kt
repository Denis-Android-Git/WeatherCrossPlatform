package org.example.weathercrossplatform.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.weathercrossplatform.domain.models.WeatherMainScreenState
import org.example.weathercrossplatform.presentation.weather_list.MainScreen

@Preview
@Composable
private fun Preview() {
    MainScreen(
        onAddButtonClick = {},
        onCancelButtonClick = { },
        onAddCityButtonClick = {},
        savedCityList = emptyList(),
        cityId = 2,
        weatherMainScreenState = WeatherMainScreenState(),
        isCurrentLocation = true,
        onSettingsClick = {},
    )
}