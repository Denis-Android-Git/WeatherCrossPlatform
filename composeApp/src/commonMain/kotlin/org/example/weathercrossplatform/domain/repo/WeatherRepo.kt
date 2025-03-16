package org.example.weathercrossplatform.domain.repo

import org.example.weathercrossplatform.data.network.dto.ForecastDto
import org.example.weathercrossplatform.data.utils.NetworkError
import org.example.weathercrossplatform.data.utils.Result
import org.example.weathercrossplatform.data.network.dto.ImageListDto

interface WeatherRepo {
    suspend fun getCurrentWeather(query: String): Result<ForecastDto, NetworkError>
    suspend fun getImageList(query: String): Result<ImageListDto, NetworkError>
}