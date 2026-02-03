package org.example.weathercrossplatform.data.repo_impl

import kotlinx.coroutines.flow.Flow
import org.example.weathercrossplatform.data.database.SavedWeatherItem
import org.example.weathercrossplatform.data.database.WeatherDataBase
import org.example.weathercrossplatform.domain.repo.DataBaseRepo

class DataBaseRepoImpl(
    private val weatherDataBase: WeatherDataBase
) : DataBaseRepo {
    override fun getWeatherList(): Flow<List<SavedWeatherItem>> {
        return weatherDataBase.weatherDao().getWeatherList()
    }

    override suspend fun saveWeather(weather: SavedWeatherItem) {
        weatherDataBase.weatherDao().upsertWeather(weather)
    }

    override suspend fun deleteWeather(weather: SavedWeatherItem) {
        weatherDataBase.weatherDao().deleteWeather(weather)
    }

    override suspend fun deleteWeatherList(weatherList: List<SavedWeatherItem>) {
        weatherDataBase.weatherDao().deleteWeatherList(weatherList)
    }

    override suspend fun clearCurrentLocation() {
        weatherDataBase.weatherDao().clearCurrentLocation()
    }
}