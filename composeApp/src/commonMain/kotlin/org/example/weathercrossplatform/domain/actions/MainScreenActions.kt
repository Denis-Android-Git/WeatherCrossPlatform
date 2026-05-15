package org.example.weathercrossplatform.domain.actions

sealed interface MainScreenActions {
    data class Init(val orientation: String) : MainScreenActions
    data class SetCityId(val cityId: Int?) : MainScreenActions
    object RefreshPosition : MainScreenActions
    data class AddCity(val cityId: Int?) : MainScreenActions
    data class GetWeatherByQuery(
        val query: String, val orientation: String,
    ) : MainScreenActions

    data class PullToRefresh(
        val query: String, val isCurrentLocation: Boolean, val orientation: String,
    ) : MainScreenActions

    data class UpdatePage(val page: Int) : MainScreenActions
}