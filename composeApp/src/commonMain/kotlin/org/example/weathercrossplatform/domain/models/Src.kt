package org.example.weathercrossplatform.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Src(
    val large: String,
    val medium: String,
    val small: String,
)