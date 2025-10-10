package org.example.weathercrossplatform.data.repo_impl

import com.example.weathercrossplatform.BuildKonfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import org.example.weathercrossplatform.data.locale.SystemLocale
import org.example.weathercrossplatform.data.network.UrlConstant.BASE_URL_IMAGES
import org.example.weathercrossplatform.data.network.UrlConstant.BASE_URL_WEATHER
import org.example.weathercrossplatform.data.network.dto.ForecastDto
import org.example.weathercrossplatform.data.network.dto.ImageListDto
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

        val response = try {
            httpClient.get(
                urlString = "$BASE_URL_WEATHER/forecast.json"
            ) {
                parameter("key", BuildKonfig.API_KEY)
                parameter("q", query)
                parameter("aqi", "yes")
                parameter("lang", language)
                parameter("days", 3)

            }
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }
        return when (response.status.value) {
            in 200..299 -> {
                val result = response.body<ForecastDto>()
                Result.Success(result)
            }

            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            409 -> Result.Error(NetworkError.CONFLICT)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }

    override suspend fun searchPlaces(query: String): Result<List<Location>, NetworkError> {
        val response = try {
            httpClient.get(
                urlString = "$BASE_URL_WEATHER/search.json"
            ) {
                parameter("key", BuildKonfig.API_KEY)
                parameter("q", query)
            }
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }
        return when (response.status.value) {
            in 200..299 -> {
                val result = response.body<List<Location>>()
                Result.Success(result)
            }

            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            409 -> Result.Error(NetworkError.CONFLICT)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }

    override suspend fun getImageList(query: String): Result<ImageListDto, NetworkError> {
        val response = try {
            httpClient.get(
                urlString = BASE_URL_IMAGES
            ) {
                parameter("client_id", BuildKonfig.API_KEY2)
                parameter("query", query)
                parameter("orientation", "portrait")
            }
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }
        return when (response.status.value) {
            in 200..299 -> {
                val result = response.body<ImageListDto>()
                Result.Success(result)
            }

            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            409 -> Result.Error(NetworkError.CONFLICT)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }
}