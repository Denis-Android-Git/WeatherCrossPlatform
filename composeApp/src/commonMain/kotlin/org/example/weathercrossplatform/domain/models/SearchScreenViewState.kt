package org.example.weathercrossplatform.domain.models

import org.example.weathercrossplatform.data.database.SavedWeatherItem

data class SearchScreenViewState(
    val searchQuery: String = "",
    val expanded: Boolean = false,
    val loading: Boolean = false,
    val cityList: List<Location> = emptyList(),
    val error: String? = null,
    val tempListToDelete: List<SavedWeatherItem> = emptyList(),
    val pageNumber: Int? = null,
    val allCitiesInOriginalOrder: List<SavedWeatherItem> = emptyList(),
    val allCities: List<SavedWeatherItem> = emptyList()
)
