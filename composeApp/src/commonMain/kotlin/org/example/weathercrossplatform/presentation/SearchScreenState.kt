package org.example.weathercrossplatform.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.example.weathercrossplatform.viewmodels.SearchViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SearchScreenState(
    searchViewModel: SearchViewModel = koinViewModel(),
    onBackButtonClick: () -> Unit
) {

    val searchScreenState = searchViewModel.searchScreenState.collectAsStateWithLifecycle()

    val cityList = searchViewModel.allCities.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        SearchScreen(
            query = searchScreenState.value.searchQuery,
            onBackButtonClick = onBackButtonClick,
            onQueryChange = searchViewModel::setSearchQuery,
            expanded = searchScreenState.value.expanded,
            onExpandedChange = searchViewModel::setExpanded,
            onSearch = {},
            cityList = cityList.value
        )
    }
}