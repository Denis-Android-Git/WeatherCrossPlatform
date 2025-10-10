package org.example.weathercrossplatform.data.network

import io.ktor.client.engine.darwin.DarwinHttpRequestException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerializationException
import org.example.weathercrossplatform.data.utils.NetworkError
import org.example.weathercrossplatform.data.utils.Result
import platform.Foundation.NSURLErrorCallIsActive
import platform.Foundation.NSURLErrorCannotFindHost
import platform.Foundation.NSURLErrorDNSLookupFailed
import platform.Foundation.NSURLErrorDataNotAllowed
import platform.Foundation.NSURLErrorDomain
import platform.Foundation.NSURLErrorInternationalRoamingOff
import platform.Foundation.NSURLErrorNetworkConnectionLost
import platform.Foundation.NSURLErrorNotConnectedToInternet
import platform.Foundation.NSURLErrorResourceUnavailable
import platform.Foundation.NSURLErrorTimedOut
import kotlin.coroutines.coroutineContext

actual suspend fun <T> platformSafeCall(
    execute: suspend () -> HttpResponse,
    handleResponse: suspend (HttpResponse) -> Result<T, NetworkError>
): Result<T, NetworkError> {
    return try {
        val response = execute()
        handleResponse(response)
    } catch (e: DarwinHttpRequestException) {
        handleDarwinException(e)
    } catch (e: UnresolvedAddressException) {
        Result.Error(NetworkError.NO_INTERNET_CONNECTION)
    } catch (e: HttpRequestTimeoutException) {
        Result.Error(NetworkError.REQUEST_TIMEOUT)
    } catch (e: SerializationException) {
        Result.Error(NetworkError.SERIALIZATION)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        Result.Error(NetworkError.UNKNOWN)
    }
}


private fun handleDarwinException(e: DarwinHttpRequestException): Result<Nothing, NetworkError> {
    val nsError = e.origin
    return if (nsError.domain == NSURLErrorDomain) {
        when (nsError.code) {
            NSURLErrorNotConnectedToInternet,
            NSURLErrorNetworkConnectionLost,
            NSURLErrorCannotFindHost,
            NSURLErrorDNSLookupFailed,
            NSURLErrorResourceUnavailable,
            NSURLErrorInternationalRoamingOff,
            NSURLErrorCallIsActive,
            NSURLErrorDataNotAllowed -> {
                return Result.Error(NetworkError.NO_INTERNET_CONNECTION)
            }

            NSURLErrorTimedOut -> {
                return Result.Error(NetworkError.REQUEST_TIMEOUT)
            }

            else -> {
                return Result.Error(NetworkError.UNKNOWN)
            }
        }
    } else Result.Error(NetworkError.UNKNOWN)
}