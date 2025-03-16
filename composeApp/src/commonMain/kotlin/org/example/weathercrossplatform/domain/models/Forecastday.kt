package org.example.weathercrossplatform.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Forecastday(
    val astro: Astro,
    val date: String,
    @SerialName("date_epoch")
    val dateEpoch: Int,
    val day: Day,
    val hour: List<Hour>
)
