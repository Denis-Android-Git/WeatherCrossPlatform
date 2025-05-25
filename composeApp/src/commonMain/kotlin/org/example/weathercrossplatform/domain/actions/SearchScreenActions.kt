package org.example.weathercrossplatform.domain.actions

sealed interface SearchScreenActions {
    data class SetSearchQuery(val query: String) : SearchScreenActions
    data class SearchCities(val city: String) : SearchScreenActions
    data class SetExpanded(val expanded: Boolean) : SearchScreenActions
}