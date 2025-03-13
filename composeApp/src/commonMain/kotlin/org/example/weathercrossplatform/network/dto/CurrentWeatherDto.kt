package org.example.weathercrossplatform.network.dto

import org.example.weathercrossplatform.domain.models.Current
import org.example.weathercrossplatform.domain.models.Location

data class CurrentWeatherDto(
    val current: Current,
    val location: Location
)