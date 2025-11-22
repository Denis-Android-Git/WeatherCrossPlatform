package org.example.weathercrossplatform.domain.models

import org.example.weathercrossplatform.data.database.SavedWeatherItem
import org.example.weathercrossplatform.data.network.dto.ForecastDto
import org.example.weathercrossplatform.data.utils.UiText

data class WeatherMainScreenState(
    val isLoading: Boolean = false,
    val weatherDto: ForecastDto? = null,
    val error: UiText? = null,
    val image: String = "",
    val weatherItemList: List<WeatherItem> = emptyList(),
    val cityId: Int? = null,
    val isAddCity: Boolean = false,
    val savedCities: List<SavedWeatherItem> = emptyList(),
    val pageNumberFromSearchScreen: Int? = null,
    val pageNumber: Int = 0
)
