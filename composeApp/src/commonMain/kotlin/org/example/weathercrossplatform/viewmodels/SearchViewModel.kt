package org.example.weathercrossplatform.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.weathercrossplatform.domain.models.SearchScreenViewState
import org.example.weathercrossplatform.domain.repo.DataBaseRepo

class SearchViewModel(
    dataBaseRepo: DataBaseRepo
) : ViewModel() {
    private val _searchScreenState = MutableStateFlow(SearchScreenViewState())
    val searchScreenState = _searchScreenState.asStateFlow()

    val allCities = dataBaseRepo.getWeatherList()
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