package org.example.weathercrossplatform.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AirQuality(
    val co: Double? = null,
    @SerialName("gb-defra-index")
    val gbDefraIndex: Int? = null,
    val no2: Double? = null,
    val o3: Double? = null,
    val pm10: Double? = null,
    @SerialName("pm2_5")
    val pm25: Double? = null,
    val so2: Double? = null,
    @SerialName("us-epa-index")
    val usEpaIndex: Int? = null
)