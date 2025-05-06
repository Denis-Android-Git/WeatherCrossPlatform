package org.example.weathercrossplatform.domain.repo

import kotlinx.coroutines.flow.Flow
import org.example.weathercrossplatform.data.database.SavedWeatherItem

interface DataBaseRepo {
    fun getWeatherList(): Flow<List<SavedWeatherItem>>
    suspend fun saveWeather(weather: SavedWeatherItem)
    suspend fun deleteWeather(weather: SavedWeatherItem)
}