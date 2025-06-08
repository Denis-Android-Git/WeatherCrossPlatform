package org.example.weathercrossplatform.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.launch
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

    val scope = rememberCoroutineScope()
    val searchScreenState by searchViewModel.searchScreenState.collectAsStateWithLifecycle()
    val cityList by searchViewModel.allCities.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        SearchScreen(
            query = searchScreenState.searchQuery,
            onBackButtonClick = onBackButtonClick,
            onQueryChange = {
                searchViewModel.onAction(SearchScreenActions.SetSearchQuery(it))
            },
            expanded = searchScreenState.expanded,
            onExpandedChange = {
                searchViewModel.onAction(SearchScreenActions.SetExpanded(it))
                searchViewModel.onAction(SearchScreenActions.SetSearchQuery(""))
            },
            onSearch = {
                searchViewModel.onAction(SearchScreenActions.SearchCities(it))
            },
            cityList = cityList,
            locationList = searchScreenState.cityList,
            onFoundItemClick = onFoundItemClick,
            onLongClick = {
                scope.launch {
                    searchViewModel.onAction(SearchScreenActions.SetTempList(it))
                }
            },
            onClick = {
                scope.launch {
                    searchViewModel.onAction(SearchScreenActions.SetTempList(it))
                }
            },
            tempListToDelete = searchScreenState.tempListToDelete,
            onDelete = {
                searchViewModel.onAction(SearchScreenActions.DeleteTempCityList(searchScreenState.tempListToDelete))
            }
        )
    }
}