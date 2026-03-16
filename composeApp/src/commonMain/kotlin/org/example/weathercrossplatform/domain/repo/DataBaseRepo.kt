package org.example.weathercrossplatform.domain.repo

import kotlinx.coroutines.flow.Flow
import org.example.weathercrossplatform.data.database.SavedWeatherItem
import org.example.weathercrossplatform.data.database.SearchedWeatherItem

interface DataBaseRepo {
    fun getWeatherList(): Flow<List<SavedWeatherItem>>
    suspend fun saveWeather(weather: SavedWeatherItem)
    suspend fun deleteWeather(weather: SavedWeatherItem)
    suspend fun deleteWeatherList(weatherList: List<SavedWeatherItem>)
    suspend fun clearCurrentLocation()

    fun getSearchedItems(): Flow<List<SearchedWeatherItem>>

    suspend fun saveSearchedItem(item: SearchedWeatherItem)
    suspend fun deleteSearchedItem(id: Int)
}