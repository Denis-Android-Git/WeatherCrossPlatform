package org.example.weathercrossplatform.data.repo_impl

import io.ktor.client.HttpClient
import org.example.weathercrossplatform.data.utils.NetworkError
import org.example.weathercrossplatform.data.utils.Result
import org.example.weathercrossplatform.domain.repo.WeatherRepo
import org.example.weathercrossplatform.network.dto.CurrentWeatherDto

//class WeatherRepoImpl(
//    private val httpClient: HttpClient
//) : WeatherRepo {
//    override suspend fun getCurrentWeather(query: String): Result<CurrentWeatherDto, NetworkError> {
//
//    }
//}