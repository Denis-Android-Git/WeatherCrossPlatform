package org.example.weathercrossplatform.data.network.dto

import kotlinx.serialization.Serializable
import org.example.weathercrossplatform.domain.models.Photo

@Serializable
data class ImageListDto(
    val photos: List<Photo>,
)