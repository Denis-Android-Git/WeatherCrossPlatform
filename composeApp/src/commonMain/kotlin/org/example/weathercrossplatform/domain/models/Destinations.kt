package org.example.weathercrossplatform.domain.models

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Serializable

sealed interface Routes : NavKey {
    @Serializable
    data class MainScreenRoute @OptIn(ExperimentalUuidApi::class) constructor(
        //val cityId: Int? = null,
        val pageNumber: Int? = null,
        val forceKey: String = Uuid.random().toString()//Random.nextLong() //to recreate viewmodel each time

    ) : Routes, NavKey

    @Serializable
    data class SearchScreenRoute(
        val pageNumber: Int? = null
    ) : Routes, NavKey

    @Serializable
    data object SettingsScreenRoute : Routes, NavKey
}

