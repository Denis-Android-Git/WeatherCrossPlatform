package org.example.weathercrossplatform.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SearchedWeatherItem(
    @PrimaryKey
    val cityId: Int?,
    val name: String,
    val country: String,
    val timeStamp: Long
)
