package org.example.weathercrossplatform.presentation.search_weather

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.example.weathercrossplatform.data.database.SavedWeatherItem
import org.example.weathercrossplatform.data.logger_impl.MyLoggerImpl
import org.example.weathercrossplatform.domain.logger.MyLogger
import org.example.weathercrossplatform.domain.models.Location
import org.example.weathercrossplatform.presentation.elements.FoundItem
import org.example.weathercrossplatform.presentation.elements.SavedElement
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    query: String,
    onBackButtonClick: () -> Unit,
    onQueryChange: (String) -> Unit,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    onSearch: (String) -> Unit,
    cityList: List<SavedWeatherItem>,
    allCitiesInOriginalOrder: List<SavedWeatherItem>,
    locationList: List<Location>,
    onFoundItemClick: (Location) -> Unit,
    onLongClick: (SavedWeatherItem) -> Unit,
    onClick: (SavedWeatherItem) -> Unit,
    tempListToDelete: List<SavedWeatherItem>,
    onDelete: () -> Unit,
    clearTempList: () -> Unit,
    onSavedItemClick: (Int) -> Unit,
    myLogger: MyLogger = MyLoggerImpl
) {

    val isLongPressed = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .systemBarsPadding()
                .padding(horizontal = 16.dp)
        ) {
            AnimatedVisibility(!expanded && !isLongPressed.value) {
                Column {
                    IconButton(
                        onClick = onBackButtonClick
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "back",
                            tint = Color.White
                        )
                    }
                    Text(text = "Поиск городов", color = Color.White, fontSize = 24.sp)
                }
            }
            AnimatedVisibility(isLongPressed.value) {
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
                        text = "Выбрано ${tempListToDelete.size}",
                        color = Color.White,
                        fontSize = 24.sp
                    )
                }
            }
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                shadowElevation = 10.dp,
                colors = SearchBarDefaults.colors(
                    containerColor = Color.Black
                ),
                inputField = {
                    SearchBarDefaults.InputField(
                        query = query,
                        onQueryChange = {
                            myLogger.debug("onQueryChange: $it")
                            onQueryChange(it)
                        },
                        onSearch = {
                            onSearch(it)
                        },
                        expanded = expanded,
                        onExpandedChange = {
                            onExpandedChange(it)
                        },
                        placeholder = {
                            Text(text = "Введите название города")
                        },
                        leadingIcon = {
                            AnimatedVisibility(!expanded) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search"
                                )
                            }
                        },
                        trailingIcon = {
                            AnimatedVisibility(expanded) {
                                Text(
                                    text = "Отмена",
                                    modifier = Modifier.clickable {
                                        onExpandedChange(false)
                                    })
                            }
                        },
                        colors = SearchBarDefaults.inputFieldColors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            cursorColor = Color.White
                        )
                    )
                },
                expanded = expanded,
                onExpandedChange = {
                    onExpandedChange(it)
                }
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(0.dp, 8.dp, 0.dp, 0.dp)
                ) {
                    items(locationList) {
                        FoundItem(
                            city = it.name,
                            country = it.country,
                            onClick = {
                                onFoundItemClick(it)
                            }
                        )
                    }
                }

            }
            LazyColumn(
                modifier = Modifier.padding(top = 16.dp)
            ) {
                item {
                    Text(
                        text = " Текущее место",
                        modifier = Modifier.padding(start = 16.dp, bottom = 8.dp),
                        color = Color.Gray
                    )
                }
                itemsIndexed(cityList) { index, savedCity ->
                    val originalIndex = allCitiesInOriginalOrder.indexOf(savedCity)
                    SavedElement(
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
                                        myLogger.debug("onClick_isLongPressed.value")
                                        onClick(savedCity)
                                    }
                                } else {
                                    myLogger.debug("onClick_onSavedItemClick $originalIndex")
                                    onSavedItemClick(originalIndex)
                                }
                            }
                        },
                        isLongPressed = isLongPressed.value,
                        isListContainsElement = tempListToDelete.contains(savedCity),
                        isCurrentLocation = savedCity.isCurrentLocation
                    )
                }
            }
        }
        AnimatedVisibility(
            isLongPressed.value,
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            ) {
                IconButton(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = onDelete
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "More",
                        tint = Color.White
                    )
                }
                Text(
                    text = "Delete",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    color = Color.White,
                    fontSize = 11.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    SearchScreen(
        query = "good",
        onBackButtonClick = { },
        onQueryChange = {},
        expanded = false,
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
                coordinates = "",
                isCurrentLocation = false
            )
        ),
        locationList = emptyList(),
        onFoundItemClick = {},
        onLongClick = {},
        onClick = {},
        tempListToDelete = emptyList(),
        onDelete = { },
        clearTempList = {},
        onSavedItemClick = {},
        allCitiesInOriginalOrder = emptyList()
    )
}
