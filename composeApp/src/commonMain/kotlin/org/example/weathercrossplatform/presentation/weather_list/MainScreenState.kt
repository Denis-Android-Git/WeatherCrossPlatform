package org.example.weathercrossplatform.presentation.weather_list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import org.example.weathercrossplatform.domain.actions.MainScreenActions
import org.example.weathercrossplatform.domain.models.Orientation
import org.example.weathercrossplatform.presentation.elements.CustomIndicator
import org.example.weathercrossplatform.presentation.elements.ErrorScreen
import org.example.weathercrossplatform.presentation.elements.MyAdaptiveLayout
import org.example.weathercrossplatform.presentation.elements.MyPagerIndicator
import org.example.weathercrossplatform.presentation.utils.currentDeviceConfiguration

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun MainScreenState(
    modifier: Modifier,
    isFirstLaunch: Boolean,
    onAddButtonClick: (Int) -> Unit,
    onSettingsClick: () -> Unit,
    onCancelButtonClick: () -> Unit,
    weatherViewModel: WeatherViewModel,
    orientation: MutableState<String>,
    pageNumberFromSearchScreen: Int?,
    cityIdFromSearchScreen: Int?,
    onAddCityButtonClick: () -> Unit
) {
    val configuration = currentDeviceConfiguration()
    val weatherMainScreenState by weatherViewModel.weatherScreenState.collectAsStateWithLifecycle()
    val currentOrientation = rememberUpdatedState(
        if (configuration.isPortrait) Orientation.Portrait.value
        else Orientation.Landscape.value
    )

    LaunchedEffect(currentOrientation.value) {
        orientation.value = currentOrientation.value
    }
    LaunchedEffect(isFirstLaunch) {
        if (isFirstLaunch) {
            weatherViewModel.onAction(MainScreenActions.RefreshPosition)
            weatherViewModel.onAction(MainScreenActions.Init(orientation.value))
        }
    }

    LaunchedEffect(cityIdFromSearchScreen) {
        if (cityIdFromSearchScreen != null) {
            weatherViewModel.onAction(MainScreenActions.SetCityId(cityIdFromSearchScreen))
            weatherViewModel.onAction(
                MainScreenActions.GetWeatherByQuery(
                    query = "id:$cityIdFromSearchScreen",
                    orientation = orientation.value
                )
            )
        }
    }

    val pagerState = rememberPagerState(
        initialPage = pageNumberFromSearchScreen ?: 0,
        pageCount = {
            if (weatherMainScreenState.isAddCity) 1 else weatherMainScreenState.savedCities.size
        })
    val scope = rememberCoroutineScope()

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }
            .distinctUntilChanged()
            .collect { pageNumber ->
                if (weatherMainScreenState.savedCities.isNotEmpty()) {
                    weatherViewModel.onAction(MainScreenActions.UpdatePage(pageNumber))
                    weatherViewModel.onAction(
                        MainScreenActions.GetWeatherByQuery(
                            weatherMainScreenState.savedCities[pageNumber].coordinates,
                            orientation.value
                        )
                    )
                }
            }
    }

    val state = rememberPullToRefreshState()
    PullToRefreshBox(
        state = state,
        modifier = modifier.fillMaxSize().background(
            brush = Brush
                .linearGradient(
                    colors = listOf(
                        Color(0xFF357BD9).copy(alpha = 0.9f),
                        Color(0xFF357BD9).copy(alpha = 0f)
                    )
                )
        ),
        isRefreshing = weatherMainScreenState.isLoading,
        indicator = {
            CustomIndicator(
                modifier = Modifier.align(Alignment.TopCenter)
                    .systemBarsPadding(),//padding(top = 56.dp),
                state = state,
                isRefreshing = weatherMainScreenState.isLoading,
                containerColor = Color.Transparent,
                color = Color.White,
                size = 40.dp
            )
        },
        onRefresh = {
            scope.launch {
                if (weatherMainScreenState.savedCities.isNotEmpty()) {
                    val query =
                        weatherMainScreenState.savedCities[pagerState.currentPage].coordinates
                    val isCurrentLocation =
                        weatherMainScreenState.savedCities[pagerState.currentPage].isCurrentLocation
                    weatherViewModel.onAction(
                        MainScreenActions.PullToRefresh(
                            query,
                            isCurrentLocation,
                            orientation = orientation.value
                        )
                    )
                } else {
                    weatherViewModel.onAction(MainScreenActions.Init(orientation.value))
                }
            }
        },
    ) {

        MyAdaptiveLayout { topPadding ->
            if (weatherMainScreenState.weatherDto?.location?.name != null && weatherMainScreenState.savedCities.isNotEmpty()) {
                HorizontalPager(
                    state = pagerState,
                    userScrollEnabled = !weatherMainScreenState.isLoading
                ) { pageNumber ->
                    val isCurrentLocation =
                        weatherMainScreenState.savedCities[pageNumber].isCurrentLocation
                    val cityId = weatherMainScreenState.cityId
                        ?: weatherMainScreenState.savedCities[pageNumber].cityId
                    MainScreen(
                        onAddButtonClick = { onAddButtonClick(pageNumber) },
                        onCancelButtonClick = onCancelButtonClick,
                        onAddCityButtonClick = {
                            scope.launch {
                                weatherViewModel.onAction(MainScreenActions.AddCity(cityId))
                                delay(150)
                                pagerState.animateScrollToPage(weatherMainScreenState.savedCities.lastIndex)
                            }
                            onAddCityButtonClick()
                        },
                        savedCityList = weatherMainScreenState.savedCities,
                        cityId = weatherMainScreenState.cityId
                            ?: weatherMainScreenState.savedCities[pageNumber].cityId,
                        isCurrentLocation = isCurrentLocation,
                        weatherMainScreenState = weatherMainScreenState,
                        onSettingsClick = onSettingsClick,
                        modifier = modifier,
                        topPadding = topPadding

                    )
                }
                AnimatedVisibility(
                    visible = !weatherMainScreenState.isAddCity,
                    modifier = Modifier.align(Alignment.TopStart).systemBarsPadding()
                        .padding(start = 16.dp),
                ) {
                    MyPagerIndicator(
                        pagerState = pagerState
                    )
                }
            }
            weatherMainScreenState.error?.let {
                ErrorScreen(errorMessage = it.asString())
            }
        }
    }
}