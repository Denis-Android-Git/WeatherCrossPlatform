package org.example.weathercrossplatform.domain.models

data class WeatherItem(
    val title: String,
    val description: String,
    val progress: Float = 0f,
    val rotation: Float,
    val uvIndex: Int = 0
)
