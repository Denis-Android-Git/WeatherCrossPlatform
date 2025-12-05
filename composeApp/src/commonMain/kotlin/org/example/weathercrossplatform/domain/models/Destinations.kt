package org.example.weathercrossplatform.domain.models

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable

sealed interface Routes : NavKey {
    @Serializable
    data class MainScreenRoute(
        val cityId: Int? = null,
        val pageNumber: Int? = null
    ) : Routes, NavKey

    @Serializable
    data class SearchScreenRoute(
        val pageNumber: Int? = null
    ) : Routes, NavKey

    @Serializable
    data object SettingsScreenRoute : Routes, NavKey
}

