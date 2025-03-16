package org.example.weathercrossplatform.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Astro(
    @SerialName("is_moon_up")
    val isMoonUp: Int,

    @SerialName("is_sun_up")
    val isSunUp: Int,

    @SerialName("moon_illumination")
    val moonIllumination: Int,

    @SerialName("moon_phase")
    val moonPhase: String,

    val moonrise: String,
    val moonset: String,
    val sunrise: String,
    val sunset: String
)
