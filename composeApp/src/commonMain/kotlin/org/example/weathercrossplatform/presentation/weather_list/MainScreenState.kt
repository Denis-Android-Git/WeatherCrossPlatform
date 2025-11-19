package org.example.weathercrossplatform.presentation.weather_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.example.weathercrossplatform.data.logger_impl.MyLoggerImpl
import org.example.weathercrossplatform.domain.actions.MainScreenActions
import org.example.weathercrossplatform.domain.logger.MyLogger
import org.example.weathercrossplatform.presentation.elements.ErrorScreen
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreenState(
    isFirstLaunch: Boolean,
    onAddButtonClick: (Int) -> Unit,
    onCancelButtonClick: () -> Unit,
    myLogger: MyLogger = MyLoggerImpl,
    weatherViewModel: WeatherViewModel = koinViewModel()
) {

    LaunchedEffect(isFirstLaunch) {
        if (isFirstLaunch) {
            weatherViewModel.onAction(MainScreenActions.RefreshPosition)
            weatherViewModel.onAction(MainScreenActions.Init)
        }
        myLogger.debug("isFirstLaunch: $isFirstLaunch")
    }

    val weatherMainScreenState by weatherViewModel.weatherScreenState.collectAsStateWithLifecycle()

    val pagerState = rememberPagerState(
        initialPage = weatherMainScreenState.pageNumberFromSearchScreen ?: 0,
        pageCount = { weatherMainScreenState.savedCities.size })
    val scope = rememberCoroutineScope()
    var currentPageNumber by remember {
        mutableStateOf(0)
    }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { pageNumber ->
            if (weatherMainScreenState.savedCities.isNotEmpty()) {
                currentPageNumber = pageNumber
                myLogger.debug("fun_GetWeatherByQuery, pageNumber= in pagerState $currentPageNumber")
                myLogger.debug("fun_GetWeatherByQuery, LaunchedEffect pagerState")
                weatherViewModel.onAction(MainScreenActions.GetWeatherByQuery(weatherMainScreenState.savedCities[pageNumber].coordinates))
            }
        }
    }
    PullToRefreshBox(
        modifier = Modifier.fillMaxSize().background(
            brush = Brush
                .linearGradient(
                    colors = listOf(
                        Color.Blue.copy(alpha = 0.9f),
                        Color.Blue.copy(alpha = 0f)
                    )
                )
        ),
        isRefreshing = weatherMainScreenState.isLoading,
        onRefresh = {
            weatherViewModel.onAction(MainScreenActions.GetWeatherByQuery(weatherMainScreenState.savedCities[currentPageNumber].coordinates))
        },
    ) {
        if (weatherMainScreenState.weatherDto?.location?.name != null) {

            HorizontalPager(state = pagerState) { pageNumber ->

                val isCurrentLocation = weatherMainScreenState.savedCities[pageNumber].isCurrentLocation
                MainScreen(
                    onAddButtonClick = { onAddButtonClick(pageNumber) },
                    onCancelButtonClick = onCancelButtonClick,
                    onAddCityButtonClick = {
                        scope.launch {
                            weatherViewModel.onAction(MainScreenActions.AddCity(it))
                            delay(150)
                            pagerState.scrollToPage(weatherMainScreenState.savedCities.lastIndex)
                        }
                    },
                    savedCityList = weatherMainScreenState.savedCities,
                    cityId = weatherMainScreenState.cityId ?: weatherMainScreenState.savedCities[pageNumber].cityId,
                    isCurrentLocation = isCurrentLocation,
                    weatherMainScreenState = weatherMainScreenState,
                )
            }
        }
        if (weatherMainScreenState.error.isNotEmpty()) {
            ErrorScreen(errorMessage = weatherMainScreenState.error)
        }
    }
}

//val state = rememberPullToRefreshState()

//        indicator = {
//
//            MyCustomIndicator(
//                state = state,
//                isRefreshing = weatherMainScreenState.isLoading,
//                modifier = Modifier.align(Alignment.TopCenter)
//            )
//        }
