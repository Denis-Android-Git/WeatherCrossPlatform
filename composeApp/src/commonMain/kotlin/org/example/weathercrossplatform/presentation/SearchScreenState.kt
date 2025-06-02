package org.example.weathercrossplatform.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.example.weathercrossplatform.domain.actions.SearchScreenActions
import org.example.weathercrossplatform.domain.models.Location
import org.example.weathercrossplatform.viewmodels.SearchViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SearchScreenState(
    searchViewModel: SearchViewModel = koinViewModel(),
    onBackButtonClick: () -> Unit,
    onFoundItemClick: (Location) -> Unit
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
            onQueryChange = {
                searchViewModel.onAction(SearchScreenActions.SetSearchQuery(it))
            },
            expanded = searchScreenState.value.expanded,
            onExpandedChange = {
                searchViewModel.onAction(SearchScreenActions.SetExpanded(it))
                searchViewModel.onAction(SearchScreenActions.SetSearchQuery(""))
            },
            onSearch = {
                searchViewModel.onAction(SearchScreenActions.SearchCities(it))
            },
            cityList = cityList.value,
            locationList = searchScreenState.value.cityList,
            onFoundItemClick = onFoundItemClick,
        )
    }
}