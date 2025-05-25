package org.example.weathercrossplatform.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SavedWeatherItem(
    @PrimaryKey
    val id: Int,
    val cityName: String,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val temperature: Double,
    val weatherDescription: String,
    val highTemperature: Double,
    val lowTemperature: Double
)
