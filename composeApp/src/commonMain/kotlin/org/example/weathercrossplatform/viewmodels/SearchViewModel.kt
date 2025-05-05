package org.example.weathercrossplatform.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.weathercrossplatform.data.database.SavedWeatherItem
import org.example.weathercrossplatform.data.database.WeatherDao
import org.example.weathercrossplatform.domain.models.SearchScreenViewState

class SearchViewModel(
    private val weatherDao: WeatherDao
) : ViewModel() {
    private val _searchScreenState = MutableStateFlow(SearchScreenViewState())
    val searchScreenState = _searchScreenState.asStateFlow()

    init {
        viewModelScope.launch {
            weatherDao.upsertWeather(
                SavedWeatherItem(
                    cityName = "One"
                )
            )
            weatherDao.upsertWeather(
                SavedWeatherItem(
                    cityName = "Two"
                )
            )
        }
    }

    val allCities = weatherDao.getWeather()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )


    fun setSearchQuery(query: String) {
        viewModelScope.launch {
            _searchScreenState.update {
                it.copy(searchQuery = query)
            }
        }
    }

    fun setExpanded(expanded: Boolean) {
        viewModelScope.launch {
            _searchScreenState.update {
                it.copy(expanded = expanded)
            }
        }
    }
}