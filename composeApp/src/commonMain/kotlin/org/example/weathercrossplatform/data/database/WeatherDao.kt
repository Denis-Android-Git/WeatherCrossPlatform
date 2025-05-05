package org.example.weathercrossplatform.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Upsert
    suspend fun upsertWeather(weather: SavedWeatherItem)

    @Delete
    suspend fun deleteWeather(weather: SavedWeatherItem)

    @Query("SELECT * FROM savedweatheritem")
    fun getWeather(): Flow<List<SavedWeatherItem>>
}