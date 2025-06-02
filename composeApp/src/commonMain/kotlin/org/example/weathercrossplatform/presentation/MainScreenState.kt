package org.example.weathercrossplatform.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
    //val state = rememberPullToRefreshState()

    LaunchedEffect(Unit) {
        cityId?.let {
            weatherViewModel.onAction(MainScreenActions.SetCityId(it))
        }
        weatherViewModel.onAction(MainScreenActions.Init)
    }

    PullToRefreshBox(
        modifier = Modifier.fillMaxSize(),
        isRefreshing = weatherMainScreenState.isLoading,
        onRefresh = {
            weatherViewModel.onAction(MainScreenActions.RefreshPosition)
            weatherViewModel.onAction(MainScreenActions.Init)
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
        MainScreen(
            isLoading = weatherMainScreenState.isLoading,
            image = weatherMainScreenState.image,
            usEpaIndex = weatherMainScreenState.weatherDto?.current?.airQuality?.usEpaIndex,
            locationName = weatherMainScreenState.weatherDto?.location?.name,
            temp = weatherMainScreenState.weatherDto?.current?.tempC,
            condition = weatherMainScreenState.weatherDto?.current?.condition?.text,
            feelsLikeC = weatherMainScreenState.weatherDto?.current?.feelsLikeC.toString(),
            error = weatherMainScreenState.error,
            forecastList = weatherMainScreenState.weatherDto?.forecast?.forecastday,
            weatherItemList = weatherMainScreenState.weatherItemList,
            onAddButtonClick = onAddButtonClick,
            isAddCity = weatherMainScreenState.isAddCity,
            onCancelButtonClick = onCancelButtonClick,
            onAddCityButtonClick = {
                weatherViewModel.onAction(MainScreenActions.AddCity(it))
            },
            highTemp = weatherMainScreenState.weatherDto?.forecast?.forecastday[0]?.day?.maxTempC,
            lowTemp = weatherMainScreenState.weatherDto?.forecast?.forecastday[0]?.day?.minTempC,
            savedCityList = savedCityList
        )
    }
}