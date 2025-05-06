package org.example.weathercrossplatform.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.weathercrossplatform.data.database.SavedWeatherItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    query: String,
    onBackButtonClick: () -> Unit,
    onQueryChange: (String) -> Unit,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    onSearch: (String) -> Unit,
    cityList: List<SavedWeatherItem>
) {

    Column(
        modifier = Modifier.fillMaxSize()
            .systemBarsPadding()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AnimatedVisibility(!expanded) {
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
        SearchBar(
            modifier = Modifier
                .fillMaxWidth(),
            shadowElevation = 10.dp,
            colors = SearchBarDefaults.colors(
                containerColor = Color.Black
            ),
            inputField = {
                SearchBarDefaults.InputField(
                    query = query,
                    onQueryChange = {
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
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 128.dp)
            ) {
                items(10) { index ->
                    Text(text = "Item $index")
                }
            }

        }
        LazyColumn {
            item {
                Text(text = " Текущее место",
                    modifier = Modifier.padding(start = 16.dp, bottom = 8.dp),
                    color = Color.Gray)
            }
            items(cityList) {
                SavedElement(
                    cityName = it.cityName,
                    temperature = it.temperature.toString(),
                    weatherDescription = it.weatherDescription,
                    high = it.highTemperature.toString(),
                    low = it.lowTemperature.toString()
                )
            }
        }
    }
}