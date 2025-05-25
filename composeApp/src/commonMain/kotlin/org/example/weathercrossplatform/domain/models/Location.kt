package org.example.weathercrossplatform.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val country: String,
    val id: Int? = null,
    val lat: Double,
    val lon: Double,
    val name: String,
    val region: String,
    val url: String? = null
)