package org.example.weathercrossplatform.data.repo_impl

import com.example.weathercrossplatform.BuildKonfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import org.example.weathercrossplatform.data.locale.SystemLocale
import org.example.weathercrossplatform.data.network.dto.ForecastDto
import org.example.weathercrossplatform.data.network.dto.ImageListDto
import org.example.weathercrossplatform.data.utils.NetworkError
import org.example.weathercrossplatform.data.utils.Result
import org.example.weathercrossplatform.domain.repo.WeatherRepo

const val BASE_URL_WEATHER = "https://api.weatherapi.com/v1"
const val BASE_URL_IMAGES = "https://api.unsplash.com/search/photos?page=1"

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

fun createHttpClient(engine: HttpClientEngine): HttpClient {
    return HttpClient(engine) {
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    println("HTTP call $message")
                }
            }
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json(
                json = Json {
                    ignoreUnknownKeys = true
                }
            )
        }
    }
}