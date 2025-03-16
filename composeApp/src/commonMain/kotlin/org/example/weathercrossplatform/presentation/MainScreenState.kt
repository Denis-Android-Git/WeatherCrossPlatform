package org.example.weathercrossplatform.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.example.weathercrossplatform.viewmodels.WeatherViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreenState(
    weatherViewModel: WeatherViewModel = koinViewModel()
) {
    val weatherMainScreenState by weatherViewModel.weatherScreenState.collectAsStateWithLifecycle()


    MainScreen(
        isLoading = weatherMainScreenState.isLoading,
        image = weatherMainScreenState.image,
        usEpaIndex = weatherMainScreenState.weatherDto?.current?.airQuality?.usEpaIndex ?: 0,
        locationName = weatherMainScreenState.weatherDto?.location?.name ?: "",
        temp = weatherMainScreenState.weatherDto?.current?.tempC.toString(),
        condition = weatherMainScreenState.weatherDto?.current?.condition?.text ?: "",
        feelsLikeC = weatherMainScreenState.weatherDto?.current?.feelsLikeC.toString(),
        error = weatherMainScreenState.error,
        forecastList = weatherMainScreenState.weatherDto?.forecast?.forecastday
    )
}