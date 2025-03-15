package org.example.weathercrossplatform.domain.repo

import org.example.weathercrossplatform.data.utils.NetworkError
import org.example.weathercrossplatform.data.utils.Result
import org.example.weathercrossplatform.data.network.dto.CurrentWeatherDto
import org.example.weathercrossplatform.data.network.dto.ImageListDto

interface WeatherRepo {
    suspend fun getCurrentWeather(query: String): Result<CurrentWeatherDto, NetworkError>
    suspend fun getImageList(query: String): Result<ImageListDto, NetworkError>
}