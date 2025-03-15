package org.example.weathercrossplatform.domain.models

import org.example.weathercrossplatform.data.network.dto.CurrentWeatherDto

data class WeatherMainScreenState(
    val isLoading: Boolean = false,
    val weatherDto: CurrentWeatherDto? = null,
    val error: String = "",
    val image: String = ""
)
