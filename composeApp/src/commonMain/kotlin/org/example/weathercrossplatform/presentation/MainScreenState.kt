package org.example.weathercrossplatform.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.example.weathercrossplatform.domain.actions.MainScreenActions
import org.example.weathercrossplatform.viewmodels.WeatherViewModel
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenState(
    cityId: Int?,
    onAddButtonClick: () -> Unit,
    onCancelButtonClick: () -> Unit,
    weatherViewModel: WeatherViewModel = koinViewModel()
) {
    val weatherMainScreenState by weatherViewModel.weatherScreenState.collectAsStateWithLifecycle()
    val savedCityList by weatherViewModel.allCities.collectAsStateWithLifecycle()

    if (savedCityList.isNotEmpty()) {
        println("Saved cities count: ${savedCityList.size}")
        savedCityList.forEachIndexed { index, city ->
            println("Saved cities #$index: $city")
        }

    }

    //val state = rememberPullToRefreshState()
    val pagerState = rememberPagerState(pageCount = { savedCityList.size })
    val scope = rememberCoroutineScope()

    LaunchedEffect(cityId) {
        println("LaunchedEffect: cityId = $cityId")
        cityId?.let {
            weatherViewModel.onAction(MainScreenActions.SetCityId(it))
            delay(50)
            weatherViewModel.onAction(MainScreenActions.Init)
            delay(50)
            weatherViewModel.onAction(MainScreenActions.SetCityId(null))
        }
    }
    var currentPageNumber by remember {
        mutableStateOf(0)
    }
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { pageNumber ->
            if (savedCityList.isNotEmpty()) {
                currentPageNumber = pageNumber
                println("pageNumber=$currentPageNumber")
                weatherViewModel.onAction(MainScreenActions.GetWeatherByQuery(savedCityList[pageNumber].coordinates))
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
            weatherViewModel.onAction(MainScreenActions.GetWeatherByQuery(savedCityList[currentPageNumber].coordinates))
        },
//        indicator = {
//
//            MyCustomIndicator(
//                state = state,
//                isRefreshing = weatherMainScreenState.isLoading,
//                modifier = Modifier.align(Alignment.TopCenter)
//            )
//        }
    ) {
        if (
            weatherMainScreenState.error.isNotEmpty()
        //modifier = Modifier.align(Alignment.Center)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {

                Text(text = weatherMainScreenState.error, textAlign = TextAlign.Center)
            }
        }
        if (weatherMainScreenState.weatherDto?.location?.name != null) {

            HorizontalPager(state = pagerState) { pageNumber ->

                val isCurrentLocation = savedCityList[pageNumber].isCurrentLocation
                MainScreen(
                    isLoading = weatherMainScreenState.isLoading,
                    image = weatherMainScreenState.image,
                    usEpaIndex = weatherMainScreenState.weatherDto?.current?.airQuality?.usEpaIndex,
                    locationName = weatherMainScreenState.weatherDto?.location?.name,
                    temp = weatherMainScreenState.weatherDto?.current?.tempC,
                    condition = weatherMainScreenState.weatherDto?.current?.condition?.text,
                    feelsLikeC = weatherMainScreenState.weatherDto?.current?.feelsLikeC.toString(),
                    //error = weatherMainScreenState.error,
                    forecastList = weatherMainScreenState.weatherDto?.forecast?.forecastday,
                    weatherItemList = weatherMainScreenState.weatherItemList,
                    onAddButtonClick = onAddButtonClick,
                    onCancelButtonClick = onCancelButtonClick,
                    onAddCityButtonClick = {
                        weatherViewModel.onAction(MainScreenActions.AddCity(it))
                        scope.launch {
                            delay(150)
                            pagerState.scrollToPage(savedCityList.lastIndex)
                        }
                    },
                    highTemp = weatherMainScreenState.weatherDto?.forecast?.forecastday[0]?.day?.maxTempC,
                    lowTemp = weatherMainScreenState.weatherDto?.forecast?.forecastday[0]?.day?.minTempC,
                    savedCityList = savedCityList,
                    cityId = cityId ?: savedCityList[pageNumber].cityId,
                    coordinates = "${weatherMainScreenState.weatherDto?.location?.lat},${weatherMainScreenState.weatherDto?.location?.lon}",
                    isCurrentLocation = isCurrentLocation
                )
            }
        }
    }
}
