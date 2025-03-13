package org.example.weathercrossplatform.domain.repo

import org.example.weathercrossplatform.data.utils.NetworkError
import org.example.weathercrossplatform.data.utils.Result
import org.example.weathercrossplatform.network.dto.CurrentWeatherDto

interface WeatherRepo {
    suspend fun getCurrentWeather(query: String): Result<CurrentWeatherDto, NetworkError>
}