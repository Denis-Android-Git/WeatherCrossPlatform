package org.example.weathercrossplatform.domain.models

import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    data object SearchScreenRoute : Routes

    @Serializable
    data class MainScreenRoute(
        val city: Int? = null
    ) : Routes
}

