package org.example.weathercrossplatform.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AirQuality(
    val co: Double,
    @SerialName("gb-defra-index")
    val gbDefraIndex: Int,
    val no2: Double,
    val o3: Double,
    val pm10: Double,
    @SerialName("pm2_5")
    val pm25: Double,
    val so2: Double,
    @SerialName("us-epa-index")
    val usEpaIndex: Int
)