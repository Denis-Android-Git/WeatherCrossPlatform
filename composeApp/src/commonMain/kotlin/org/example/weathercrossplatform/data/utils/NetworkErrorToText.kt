package org.example.weathercrossplatform.data.utils

import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.air_quality_level_1
import weathercrossplatform.composeapp.generated.resources.air_quality_level_2
import weathercrossplatform.composeapp.generated.resources.air_quality_level_3
import weathercrossplatform.composeapp.generated.resources.air_quality_level_4
import weathercrossplatform.composeapp.generated.resources.air_quality_level_5
import weathercrossplatform.composeapp.generated.resources.air_quality_level_6
import weathercrossplatform.composeapp.generated.resources.error_bad_request
import weathercrossplatform.composeapp.generated.resources.error_conflict
import weathercrossplatform.composeapp.generated.resources.error_forbidden
import weathercrossplatform.composeapp.generated.resources.error_no_internet
import weathercrossplatform.composeapp.generated.resources.error_not_found
import weathercrossplatform.composeapp.generated.resources.error_payload_too_large
import weathercrossplatform.composeapp.generated.resources.error_request_timeout
import weathercrossplatform.composeapp.generated.resources.error_serialization
import weathercrossplatform.composeapp.generated.resources.error_server
import weathercrossplatform.composeapp.generated.resources.error_service_unavailable
import weathercrossplatform.composeapp.generated.resources.error_too_many_requests
import weathercrossplatform.composeapp.generated.resources.error_unauthorized
import weathercrossplatform.composeapp.generated.resources.error_unknown


fun NetworkError.toUiText(): UiText {
    val resource = when (this) {
        NetworkError.BAD_REQUEST -> Res.string.error_bad_request
        NetworkError.REQUEST_TIMEOUT -> Res.string.error_request_timeout
        NetworkError.INTERNAL_SERVER_ERROR -> Res.string.error_server
        NetworkError.NOT_FOUND -> Res.string.error_not_found
        NetworkError.UNAUTHORIZED -> Res.string.error_unauthorized
        NetworkError.FORBIDDEN -> Res.string.error_forbidden
        NetworkError.UNKNOWN -> Res.string.error_unknown
        NetworkError.CONFLICT -> Res.string.error_conflict
        NetworkError.TOO_MANY_REQUESTS -> Res.string.error_too_many_requests
        NetworkError.NO_INTERNET_CONNECTION -> Res.string.error_no_internet
        NetworkError.PAYLOAD_TOO_LARGE -> Res.string.error_payload_too_large
        NetworkError.SERVER_ERROR -> Res.string.error_server
        NetworkError.SERVICE_UNAVAILABLE -> Res.string.error_service_unavailable
        NetworkError.SERIALIZATION -> Res.string.error_serialization
    }
    return UiText.MyStringResource(resource)
}

fun Int.toUiText(): UiText {
    val resource = when (this) {
        1 -> Res.string.air_quality_level_1
        2 -> Res.string.air_quality_level_2
        3 -> Res.string.air_quality_level_3
        4 -> Res.string.air_quality_level_4
        5 -> Res.string.air_quality_level_5
        6 -> Res.string.air_quality_level_6
        else -> Res.string.air_quality_level_1
    }
    return UiText.MyStringResource(resource)
}