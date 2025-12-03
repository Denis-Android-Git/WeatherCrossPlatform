package org.example.weathercrossplatform.domain.models

import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    data class MainScreenRoute(
        val cityId: Int? = null,
        val pageNumber: Int? = null
    ) : Routes

    @Serializable
    data class SearchScreenRoute(
        val pageNumber: Int? = null
    ) : Routes

    @Serializable
    data object SettingsScreenRoute : Routes
}

