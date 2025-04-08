package org.example.weathercrossplatform.domain.models

import org.example.weathercrossplatform.data.network.dto.ForecastDto

data class WeatherMainScreenState(
    val isLoading: Boolean = false,
    val weatherDto: ForecastDto? = null,
    val error: String = "",
    val image: String = "",
    val weatherItemList: List<WeatherItem> = emptyList()
)
