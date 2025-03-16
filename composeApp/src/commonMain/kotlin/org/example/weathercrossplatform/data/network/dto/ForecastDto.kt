package org.example.weathercrossplatform.data.network.dto

import kotlinx.serialization.Serializable
import org.example.weathercrossplatform.domain.models.Forecast
import org.example.weathercrossplatform.domain.models.Current
import org.example.weathercrossplatform.domain.models.Location

@Serializable
data class ForecastDto(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)