package org.example.weathercrossplatform.network.dto

import kotlinx.serialization.Serializable
import org.example.weathercrossplatform.domain.models.Current
import org.example.weathercrossplatform.domain.models.Location
@Serializable
data class CurrentWeatherDto(
    val current: Current,
    val location: Location
)