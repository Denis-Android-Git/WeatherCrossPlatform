package org.example.weathercrossplatform.data.network.dto

import kotlinx.serialization.Serializable
import org.example.weathercrossplatform.domain.models.PhotoData

@Serializable
data class ImageListDto(
    val results: List<PhotoData>,
)