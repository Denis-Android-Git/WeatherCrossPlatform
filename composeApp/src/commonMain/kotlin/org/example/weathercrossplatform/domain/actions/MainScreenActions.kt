package org.example.weathercrossplatform.domain.actions

import org.example.weathercrossplatform.data.database.SavedWeatherItem

sealed interface MainScreenActions {
    data class Init(val orientation: String) : MainScreenActions
    data class SetCityId(val cityId: Int?) : MainScreenActions
    object RefreshPosition : MainScreenActions
    data class AddCity(val city: SavedWeatherItem) : MainScreenActions
    data class GetWeatherByQuery(
        val query: String, val orientation: String,
    ) : MainScreenActions

    data class PullToRefresh(
        val query: String, val isCurrentLocation: Boolean, val orientation: String,
    ) : MainScreenActions

    data class UpdatePage(val page: Int) : MainScreenActions
}