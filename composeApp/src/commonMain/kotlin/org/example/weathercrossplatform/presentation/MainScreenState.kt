package org.example.weathercrossplatform.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.example.weathercrossplatform.viewmodels.WeatherViewModel
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenState(
    weatherViewModel: WeatherViewModel = koinViewModel()
) {
    val weatherMainScreenState by weatherViewModel.weatherScreenState.collectAsStateWithLifecycle()
    //val state = rememberPullToRefreshState()

    PullToRefreshBox(
        isRefreshing = weatherMainScreenState.isLoading,
        onRefresh = {
            weatherViewModel.refreshPosition()
        },
//        indicator = {
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
            temp = weatherMainScreenState.weatherDto?.current?.tempC.toString(),
            condition = weatherMainScreenState.weatherDto?.current?.condition?.text,
            feelsLikeC = weatherMainScreenState.weatherDto?.current?.feelsLikeC.toString(),
            error = weatherMainScreenState.error,
            forecastList = weatherMainScreenState.weatherDto?.forecast?.forecastday,
            weatherItemList = weatherMainScreenState.weatherItemList
        )
    }
}