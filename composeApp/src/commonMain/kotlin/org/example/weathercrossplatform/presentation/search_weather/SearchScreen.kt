package org.example.weathercrossplatform.presentation.search_weather

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kashif_e.backdrop.backdrops.layerBackdrop
import com.kashif_e.backdrop.backdrops.rememberLayerBackdrop
import kotlinx.coroutines.launch
import org.example.weathercrossplatform.data.database.SavedWeatherItem
import org.example.weathercrossplatform.domain.models.Location
import org.example.weathercrossplatform.domain.models.SearchScreenViewState
import org.example.weathercrossplatform.presentation.elements.FoundItem
import org.example.weathercrossplatform.presentation.elements.SavedElement
import org.example.weathercrossplatform.presentation.utils.currentDeviceConfiguration
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.cancel
import weathercrossplatform.composeapp.generated.resources.chosen
import weathercrossplatform.composeapp.generated.resources.city_search
import weathercrossplatform.composeapp.generated.resources.current_place
import weathercrossplatform.composeapp.generated.resources.delete
import weathercrossplatform.composeapp.generated.resources.enter_city
import weathercrossplatform.composeapp.generated.resources.im_13
import weathercrossplatform.composeapp.generated.resources.landscape_13
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class,
    ExperimentalUuidApi::class
)
@Composable
fun SearchScreen(
    modifier: Modifier,
    searchScreenState: SearchScreenViewState,
    onBackButtonClick: () -> Unit,
    onQueryChange: (String) -> Unit,
    onExpandedChange: (Boolean) -> Unit,
    onSearch: (String) -> Unit,
    cityList: List<SavedWeatherItem>,
    allCitiesInOriginalOrder: List<SavedWeatherItem>,
    onFoundItemClick: (Location) -> Unit,
    onSearchedItemClick: (Int?) -> Unit,
    onLongClick: (SavedWeatherItem) -> Unit,
    onClick: (SavedWeatherItem) -> Unit,
    onDelete: () -> Unit,
    clearTempList: () -> Unit,
    onSavedItemClick: (Int) -> Unit
) {
    val isLongPressed = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val backdrop = rememberLayerBackdrop()
    val configuration = currentDeviceConfiguration()
    val backGround by rememberUpdatedState(
        if (configuration.isPortrait) Res.drawable.im_13 else Res.drawable.landscape_13
    )

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(backGround),
            contentDescription = null,
            modifier = Modifier
                .layerBackdrop(backdrop),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = if (searchScreenState.expanded) {
                Modifier.fillMaxSize()
            } else {
                Modifier.fillMaxSize()
                    .systemBarsPadding()//padding between Box and systemBars
                    .padding(horizontal = 8.dp)
            }
        ) {
            AnimatedVisibility(!searchScreenState.expanded && !isLongPressed.value) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(
                        onClick = onBackButtonClick
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "back",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = stringResource(Res.string.city_search),
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        color = Color.White, fontSize = 24.sp
                    )
                }
            }
            AnimatedVisibility(isLongPressed.value) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        IconButton(
                            onClick = {
                                isLongPressed.value = false
                                clearTempList()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear",
                                tint = Color.White
                            )
                        }
                        Text(
                            text = "${stringResource(Res.string.chosen)} ${searchScreenState.tempListToDelete.size}",
                            color = Color.White,
                            fontSize = 24.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Column {
                        IconButton(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            onClick = {
                                onDelete()
                                isLongPressed.value = false
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "More",
                                tint = Color.White
                            )
                        }
                        Text(
                            text = stringResource(Res.string.delete),
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            color = Color.White,
                            fontSize = 11.sp
                        )
                    }
                }
            }

            SearchBar(
                modifier = Modifier
                    .widthIn(max = 600.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                shadowElevation = 10.dp,
                colors = SearchBarDefaults.colors(
                    containerColor = Color.Black
                ),
                inputField = {
                    SearchBarDefaults.InputField(
                        query = searchScreenState.searchQuery,
                        onQueryChange = {
                            onQueryChange(it)
                        },
                        onSearch = {
                            onSearch(it)
                        },
                        expanded = searchScreenState.expanded,
                        onExpandedChange = {
                            onExpandedChange(it)
                        },
                        modifier = Modifier
                            .padding(horizontal = 16.dp),
                        placeholder = {
                            Text(text = stringResource(Res.string.enter_city))
                        },
                        leadingIcon = {

                            AnimatedVisibility(!searchScreenState.expanded) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search",
                                    tint = Color.White
                                )
                            }
                        },
                        trailingIcon = {
                            AnimatedVisibility(searchScreenState.expanded) {
                                Text(
                                    text = stringResource(Res.string.cancel),
                                    modifier = Modifier
                                        .padding(end = 16.dp)
                                        .clickable {
                                            onExpandedChange(false)
                                        })
                            }
                        },
                        colors = SearchBarDefaults.inputFieldColors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            cursorColor = Color.White,
                            focusedContainerColor = Color.DarkGray,
                            unfocusedContainerColor = Color.Black,
                            focusedPlaceholderColor = Color.White,
                            unfocusedPlaceholderColor = Color.White,
                            focusedTrailingIconColor = Color.White,
                            unfocusedTrailingIconColor = Color.White
                        )
                    )
                },
                expanded = searchScreenState.expanded,
                onExpandedChange = {
                    onExpandedChange(it)
                }
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    contentPadding = PaddingValues(0.dp, 8.dp, 0.dp, 0.dp)
                ) {
                    if (searchScreenState.foundCityList.isEmpty()) {
                        items(
                            searchScreenState.searchedCities,
                            key = {
                                it.cityId ?: Uuid.random()
                            }
                        ) {
                            FoundItem(
                                city = it.name,
                                country = it.country,
                                hasBeenSearched = true,
                                onClick = {
                                    onSearchedItemClick(it.cityId)
                                }
                            )
                        }
                    }
                    items(
                        searchScreenState.foundCityList,
                        key = {
                            it.id ?: Uuid.random()
                        }
                    ) {
                        FoundItem(
                            city = it.name,
                            country = it.country,
                            onClick = {
                                onFoundItemClick(it)
                            }
                        )
                    }
                    item {
                        AnimatedVisibility(
                            visible = searchScreenState.loading
                        ) {
                            LoadingIndicator(
                                color = Color.White
                            )
                        }
                    }
                }

            }
            LazyColumn(
                modifier = Modifier
                    .widthIn(max = 600.dp)
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text(
                        text = stringResource(Res.string.current_place),
                        modifier = Modifier.padding(start = 16.dp),
                        color = Color.Gray
                    )
                }
                itemsIndexed(
                    cityList,
                    key = { _, item ->
                        item.coordinates
                    }
                ) { index, savedCity ->
                    val originalIndex = allCitiesInOriginalOrder.indexOf(savedCity)
                    SavedElement(
                        modifier = Modifier.animateItem(),
                        cityName = savedCity.cityName,
                        temperature = savedCity.temperature.toString(),
                        weatherDescription = savedCity.weatherDescription,
                        high = savedCity.highTemperature.toString(),
                        low = savedCity.lowTemperature.toString(),
                        index = index,
                        onLongClick = {
                            if (!savedCity.isCurrentLocation) {
                                isLongPressed.value = true
                                onLongClick(savedCity)
                            }
                        },
                        onClick = {
                            scope.launch {
                                if (isLongPressed.value) {
                                    if (!savedCity.isCurrentLocation) {
                                        onClick(savedCity)
                                    }
                                } else {
                                    onSavedItemClick(originalIndex)
                                }
                            }
                        },
                        isLongPressed = isLongPressed.value,
                        isListContainsElement = searchScreenState.tempListToDelete.contains(
                            savedCity
                        ),
                        isCurrentLocation = savedCity.isCurrentLocation,
                        isTempC = searchScreenState.isTempC,
                        backdrop = backdrop,
                        isLiquidGlassOn = searchScreenState.isLiquidGlassOn
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
//        AnimatedVisibility(
//            isLongPressed.value,
//            modifier = Modifier.align(Alignment.BottomCenter)
//        ) {
//            Column(
//                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
//            ) {
//                IconButton(
//                    modifier = Modifier.align(Alignment.CenterHorizontally),
//                    onClick = {
//                        onDelete()
//                        isLongPressed.value = false
//                    }
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.Delete,
//                        contentDescription = "More",
//                        tint = Color.White
//                    )
//                }
//                Text(
//                    text = stringResource(Res.string.delete),
//                    modifier = Modifier.align(Alignment.CenterHorizontally),
//                    color = Color.White,
//                    fontSize = 11.sp
//                )
//            }
//        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Preview
@Composable
fun Preview() {
    CircularWavyProgressIndicator(
        color = Color.White,
        wavelength = 5.dp,
        waveSpeed = 5.dp
    )
    SearchScreen(
        onBackButtonClick = { },
        onQueryChange = {},
        onExpandedChange = {},
        onSearch = {},
        cityList = listOf(
            SavedWeatherItem(
                cityName = "Moscow",
                temperature = 12.5,
                weatherDescription = "cloudy",
                highTemperature = 20.0,
                lowTemperature = 10.0,
                cityId = 1,
                coordinates = "",
                isCurrentLocation = true
            ),
            SavedWeatherItem(
                cityName = "London",
                temperature = 15.0,
                weatherDescription = "sunny",
                highTemperature = 22.0,
                lowTemperature = 12.0,
                cityId = 2,
                coordinates = "23232",
                isCurrentLocation = false
            )
        ),
        onFoundItemClick = {},
        onLongClick = {},
        onClick = {},
        onDelete = { },
        clearTempList = {},
        onSavedItemClick = {},
        allCitiesInOriginalOrder = emptyList(),
        searchScreenState = SearchScreenViewState(
            expanded = false,
            foundCityList = listOf(
                Location(
                    name = "Moscow",
                    country = "Russia",
                    lat = 55.7558,
                    lon = 37.6173,
                    id = 1,
                    region = "Moscow",
                    url = ""
                )
            )
        ),
        modifier = Modifier,
        onSearchedItemClick = {}
    )
}
