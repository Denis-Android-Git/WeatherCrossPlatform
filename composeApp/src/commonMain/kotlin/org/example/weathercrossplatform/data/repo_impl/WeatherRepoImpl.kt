package org.example.weathercrossplatform.data.repo_impl

import com.example.weathercrossplatform.BuildKonfig
import io.ktor.client.HttpClient
import org.example.weathercrossplatform.data.locale.SystemLocale
import org.example.weathercrossplatform.data.network.UrlConstant.BASE_URL_IMAGES
import org.example.weathercrossplatform.data.network.dto.ForecastDto
import org.example.weathercrossplatform.data.network.dto.ImageListDto
import org.example.weathercrossplatform.data.network.getImage
import org.example.weathercrossplatform.data.network.getWeather
import org.example.weathercrossplatform.data.utils.NetworkError
import org.example.weathercrossplatform.data.utils.Result
import org.example.weathercrossplatform.domain.models.Location
import org.example.weathercrossplatform.domain.repo.WeatherRepo

class WeatherRepoImpl(
    private val httpClient: HttpClient,
    private val systemLocale: SystemLocale
) : WeatherRepo {

    override suspend fun getCurrentWeather(query: String): Result<ForecastDto, NetworkError> {
        val language = systemLocale.getSystemLanguage()

        val queryParams = mapOf(
            "key" to BuildKonfig.API_KEY,
            "q" to query,
            "aqi" to "yes",
            "lang" to language,
            "days" to 3
        )
        return httpClient.getWeather<ForecastDto>(
            route = "forecast.json",
            queryParams = queryParams,
        )
    }

    override suspend fun searchPlaces(query: String): Result<List<Location>, NetworkError> {

        val queryParams = mapOf(
            "key" to BuildKonfig.API_KEY,
            "q" to query
        )

        return httpClient.getWeather<List<Location>>(
            route = "search.json",
            queryParams = queryParams,
        )
    }

    override suspend fun getImageList(query: String): Result<ImageListDto, NetworkError> {

        val queryParams = mapOf(
            "client_id" to BuildKonfig.API_KEY2,
            "query" to query,
            "orientation" to "portrait"
        )

        return httpClient.getImage<ImageListDto>(
            route = BASE_URL_IMAGES,
            queryParams = queryParams,
        )
    }
}