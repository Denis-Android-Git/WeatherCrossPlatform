package org.example.weathercrossplatform.domain.models

data class SearchScreenViewState(
    val searchQuery: String = "",
    val expanded: Boolean = false,
    val loading: Boolean = false,
    val cityList: List<Location> = emptyList(),
    val error: String? = null
)
