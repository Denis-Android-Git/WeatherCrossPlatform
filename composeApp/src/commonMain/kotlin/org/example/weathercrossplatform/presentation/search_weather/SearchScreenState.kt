package org.example.weathercrossplatform.presentation.search_weather

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.launch
import org.example.weathercrossplatform.domain.actions.SearchScreenActions
import org.example.weathercrossplatform.domain.models.Location
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SearchScreenState(
    modifier: Modifier,
    searchViewModel: SearchViewModel = koinViewModel(),
    onBackButtonClick: (Int?) -> Unit,
    onFoundItemClick: (Location) -> Unit,
    onSearchedItemClick: (Int?) -> Unit,
    onSavedItemClick: (Int) -> Unit
) {

    val scope = rememberCoroutineScope()
    val searchScreenState by searchViewModel.searchScreenState.collectAsStateWithLifecycle()

    SearchScreen(
        modifier = modifier,
        onBackButtonClick = { onBackButtonClick(searchScreenState.pageNumber) },
        onQueryChange = {
            searchViewModel.onAction(SearchScreenActions.SetSearchQuery(it))
        },
        onExpandedChange = {
            searchViewModel.onAction(SearchScreenActions.SetExpanded(it))
            searchViewModel.onAction(SearchScreenActions.SetSearchQuery(""))
        },
        onSearch = {
            searchViewModel.onAction(SearchScreenActions.SearchCities(it))
        },
        cityList = searchScreenState.allCities,
        onFoundItemClick = {
            onFoundItemClick(it)
            searchViewModel.onAction(
                SearchScreenActions.AddFoundLocationToDb(
                    name = it.name, country = it.country, cityId = it.id
                )
            )
        },
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
        onDelete = {
            searchViewModel.onAction(SearchScreenActions.DeleteTempCityList(searchScreenState.tempListToDelete))
        },
        clearTempList = {
            searchViewModel.onAction(SearchScreenActions.SetTempList(null))
        },
        onSavedItemClick = {
            onSavedItemClick(it)
        },
        allCitiesInOriginalOrder = searchScreenState.allCitiesInOriginalOrder,
        searchScreenState = searchScreenState,
        onSearchedItemClick = onSearchedItemClick
    )
}