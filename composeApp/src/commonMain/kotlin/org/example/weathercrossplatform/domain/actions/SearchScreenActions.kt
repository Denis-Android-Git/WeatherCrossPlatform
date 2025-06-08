package org.example.weathercrossplatform.domain.actions

import org.example.weathercrossplatform.data.database.SavedWeatherItem

sealed interface SearchScreenActions {
    data class SetSearchQuery(val query: String) : SearchScreenActions
    data class SearchCities(val city: String) : SearchScreenActions
    data class SetExpanded(val expanded: Boolean) : SearchScreenActions
    data class SetTempList(val item: SavedWeatherItem) : SearchScreenActions
    data class DeleteTempCityList(val tempList: List<SavedWeatherItem>) : SearchScreenActions
}