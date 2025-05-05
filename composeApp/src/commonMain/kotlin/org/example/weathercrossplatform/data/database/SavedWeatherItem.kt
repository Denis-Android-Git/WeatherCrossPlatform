package org.example.weathercrossplatform.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SavedWeatherItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val cityName: String
)
