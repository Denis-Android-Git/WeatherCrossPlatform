package org.example.weathercrossplatform.domain.models

import org.jetbrains.compose.resources.StringResource

data class WeatherItem(
    val id: Int,
    val title: StringResource,
    val description: Any,
    val progress: Float = 0f,
    val rotation: Float,
    val uvIndex: Int = 0
)
