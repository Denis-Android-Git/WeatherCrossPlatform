package org.example.weathercrossplatform.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import org.example.weathercrossplatform.data.utils.NetworkError
import org.example.weathercrossplatform.data.utils.Result

suspend inline fun <reified Response : Any> HttpClient.getWeather(
    route: String,
    queryParams: Map<String, Any> = mapOf(),
    crossinline builder: HttpRequestBuilder.() -> Unit = {}
): Result<Response, NetworkError> {
    return safeCall {
        get {
            url(constructRouteWeather(route))
            queryParams.forEach { (key, value) ->
                parameter(key, value)
            }
            builder()
        }
    }
}

fun constructRouteWeather(route: String): String {
    return when {
        route.contains(UrlConstant.BASE_URL_WEATHER) -> route
        route.startsWith("/") -> "${UrlConstant.BASE_URL_WEATHER}$route"
        else -> "${UrlConstant.BASE_URL_WEATHER}/$route"
    }
}

suspend inline fun <reified Response : Any> HttpClient.getImage(
    route: String,
    queryParams: Map<String, Any> = mapOf(),
    crossinline builder: HttpRequestBuilder.() -> Unit = {}
): Result<Response, NetworkError> {
    return safeCall {
        get {
            url(constructRouteImage(route))
            queryParams.forEach { (key, value) ->
                parameter(key, value)
            }
            builder()
        }
    }
}

fun constructRouteImage(route: String): String {
    return when {
        route.contains(UrlConstant.BASE_URL_IMAGES) -> route
        route.startsWith("/") -> "${UrlConstant.BASE_URL_IMAGES}$route"
        else -> "${UrlConstant.BASE_URL_IMAGES}/$route"
    }
}

suspend inline fun <reified T> responseToResult(response: HttpResponse): Result<T, NetworkError> {
    return when (response.status.value) {
        in 200..299 -> {
            try {
                Result.Success(response.body<T>())
            } catch (_: NoTransformationFoundException) {
                Result.Error(NetworkError.SERIALIZATION)
            }
        }

        400 -> Result.Error(NetworkError.BAD_REQUEST)
        401 -> Result.Error(NetworkError.UNAUTHORIZED)
        403 -> Result.Error(NetworkError.FORBIDDEN)
        404 -> Result.Error(NetworkError.NOT_FOUND)
        408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
        409 -> Result.Error(NetworkError.CONFLICT)
        413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
        429 -> Result.Error(NetworkError.TOO_MANY_REQUESTS)
        500 -> Result.Error(NetworkError.INTERNAL_SERVER_ERROR)
        503 -> Result.Error(NetworkError.SERVICE_UNAVAILABLE)
        else -> Result.Error(NetworkError.UNKNOWN)
    }
}

expect suspend fun <T> platformSafeCall(
    execute: suspend () -> HttpResponse,
    handleResponse: suspend (HttpResponse) -> Result<T, NetworkError>
): Result<T, NetworkError>

suspend inline fun <reified T> safeCall(
    noinline execute: suspend () -> HttpResponse
): Result<T, NetworkError> {
    return platformSafeCall(
        execute = execute,
    ) {
        responseToResult(it)
    }
}