package org.example.weathercrossplatform.domain.models

import kotlinx.serialization.SerialName

data class Location(
    val country: String,
    val lat: Double,
    val localtime: String,
    @SerialName("localtime_epoch")
    val localTimeEpoch: Int,
    val lon: Double,
    val name: String,
    val region: String,
    @SerialName("tz_id")
    val tzId: String
)