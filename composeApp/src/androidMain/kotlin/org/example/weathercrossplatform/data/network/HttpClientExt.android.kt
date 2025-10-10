package org.example.weathercrossplatform.data.network

import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerializationException
import org.example.weathercrossplatform.data.utils.NetworkError
import org.example.weathercrossplatform.data.utils.Result
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import kotlin.coroutines.coroutineContext

actual suspend fun <T> platformSafeCall(
    execute: suspend () -> HttpResponse,
    handleResponse: suspend (HttpResponse) -> Result<T, NetworkError>
): Result<T, NetworkError> {
    return try {
        val response = execute()
        handleResponse(response)
    } catch (e: UnknownHostException) {
        Result.Error(NetworkError.NO_INTERNET_CONNECTION)
    } catch (e: UnresolvedAddressException) {
        Result.Error(NetworkError.NO_INTERNET_CONNECTION)
    } catch (e: ConnectException) {
        Result.Error(NetworkError.NO_INTERNET_CONNECTION)
    } catch (e: SocketTimeoutException) {
        Result.Error(NetworkError.REQUEST_TIMEOUT)
    } catch (e: HttpRequestTimeoutException) {
        Result.Error(NetworkError.REQUEST_TIMEOUT)
    } catch (e: SerializationException) {
        Result.Error(NetworkError.SERIALIZATION)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        Result.Error(NetworkError.UNKNOWN)
    }
}