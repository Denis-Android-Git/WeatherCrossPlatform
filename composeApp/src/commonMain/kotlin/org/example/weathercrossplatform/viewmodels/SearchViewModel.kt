package org.example.weathercrossplatform.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _expanded = MutableStateFlow(false)
    val expanded = _expanded.asStateFlow()

    fun setSearchQuery(query: String) {
        viewModelScope.launch {
            _searchQuery.update {
                query
            }
        }
    }

    fun setExpanded(expanded: Boolean) {
        viewModelScope.launch {
            _expanded.update {
                expanded
            }
        }
    }
}