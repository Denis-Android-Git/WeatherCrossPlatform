package org.example.weathercrossplatform.data.repo_impl

import kotlinx.coroutines.flow.Flow
import org.example.weathercrossplatform.data.database.SavedWeatherItem
import org.example.weathercrossplatform.data.database.WeatherDao
import org.example.weathercrossplatform.domain.repo.DataBaseRepo

class DataBaseRepoImpl(
    private val weatherDao: WeatherDao
) : DataBaseRepo {
    override fun getWeatherList(): Flow<List<SavedWeatherItem>> {
        return weatherDao.getWeatherList()
    }

    override suspend fun saveWeather(weather: SavedWeatherItem) {
        weatherDao.upsertWeather(weather)
    }

    override suspend fun deleteWeather(weather: SavedWeatherItem) {
        weatherDao.deleteWeather(weather)
    }
}