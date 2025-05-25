package org.example.weathercrossplatform.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.weathercrossplatform.data.utils.onError
import org.example.weathercrossplatform.data.utils.onSuccess
import org.example.weathercrossplatform.domain.actions.SearchScreenActions
import org.example.weathercrossplatform.domain.models.SearchScreenViewState
import org.example.weathercrossplatform.domain.repo.DataBaseRepo
import org.example.weathercrossplatform.domain.repo.WeatherRepo

class SearchViewModel(
    dataBaseRepo: DataBaseRepo,
    private val weatherRepo: WeatherRepo
) : ViewModel() {
    private val _searchScreenState = MutableStateFlow(SearchScreenViewState())
    val searchScreenState = _searchScreenState.asStateFlow()

    val allCities = dataBaseRepo.getWeatherList()
        .map { list ->
            if (list.size <= 1) {
                list
            } else {
                listOf(list.first()) + list.drop(1).reversed()
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun onAction(action: SearchScreenActions) {
        when (action) {
            is SearchScreenActions.SearchCities -> searchCities(action.city)
            is SearchScreenActions.SetExpanded -> setExpanded(action.expanded)
            is SearchScreenActions.SetSearchQuery -> setSearchQuery(action.query)
        }
    }

    private fun setSearchQuery(query: String) {
        viewModelScope.launch {
            _searchScreenState.update {
                it.copy(searchQuery = query)
            }
            if (query.length > 2) {
                searchCities(query)
            }
        }
    }

    private fun searchCities(query: String) {
        println("searchCities: $query")
        viewModelScope.launch {
            _searchScreenState.update {
                it.copy(loading = true)
            }
            weatherRepo.searchPlaces(query)
                .onSuccess { locationList ->
                    _searchScreenState.update {
                        it.copy(loading = false, cityList = locationList)
                    }
                }
                .onError { error ->
                    _searchScreenState.update {
                        it.copy(loading = false, error = error.name)

                    }
                }
        }
    }

    private fun setExpanded(expanded: Boolean) {
        viewModelScope.launch {
            _searchScreenState.update {
                it.copy(expanded = expanded)
            }
        }
    }
}