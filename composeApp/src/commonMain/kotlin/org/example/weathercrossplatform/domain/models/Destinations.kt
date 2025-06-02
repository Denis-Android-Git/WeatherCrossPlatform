package org.example.weathercrossplatform.domain.models

import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    data object SearchScreenRoute : Routes

    @Serializable
    data class MainScreenRoute(
        val cityId: Int? = null
    ) : Routes
}

