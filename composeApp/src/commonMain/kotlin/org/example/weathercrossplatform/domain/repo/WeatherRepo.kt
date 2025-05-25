package org.example.weathercrossplatform.domain.repo

import org.example.weathercrossplatform.data.network.dto.ForecastDto
import org.example.weathercrossplatform.data.utils.NetworkError
import org.example.weathercrossplatform.data.utils.Result
import org.example.weathercrossplatform.data.network.dto.ImageListDto
import org.example.weathercrossplatform.domain.models.Location

interface WeatherRepo {
    suspend fun getCurrentWeather(query: String): Result<ForecastDto, NetworkError>
    suspend fun searchPlaces(query: String): Result<List<Location>, NetworkError>
    suspend fun getImageList(query: String): Result<ImageListDto, NetworkError>
}