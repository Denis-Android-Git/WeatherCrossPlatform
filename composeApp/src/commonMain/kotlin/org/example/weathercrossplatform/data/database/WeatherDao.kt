package org.example.weathercrossplatform.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Upsert
    suspend fun upsertWeather(weather: SavedWeatherItem)

    @Delete
    suspend fun deleteWeather(weather: SavedWeatherItem)

    @Transaction
    suspend fun deleteWeatherList(weatherList: List<SavedWeatherItem>) {
        weatherList.forEach {
            deleteWeather(it)
        }
    }

    @Query("SELECT * FROM savedweatheritem ORDER BY isCurrentLocation DESC")
    fun getWeatherList(): Flow<List<SavedWeatherItem>>

    @Query("UPDATE savedweatheritem SET isCurrentLocation = 0 WHERE isCurrentLocation = 1")
    suspend fun clearCurrentLocation()
}