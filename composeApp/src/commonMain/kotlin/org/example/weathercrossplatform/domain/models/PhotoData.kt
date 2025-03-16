package org.example.weathercrossplatform.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class PhotoData(
    val urls: Urls
)