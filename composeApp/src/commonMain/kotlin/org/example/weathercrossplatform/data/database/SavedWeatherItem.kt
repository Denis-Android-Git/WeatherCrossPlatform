package org.example.weathercrossplatform.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SavedWeatherItem(
    @PrimaryKey
    val cityName: String,
    val cityId: Int?,
    val temperature: Double,
    val weatherDescription: String,
    val highTemperature: Double,
    val lowTemperature: Double,
    val coordinates: String,
    val isCurrentLocation: Boolean
)
