package org.example.weathercrossplatform.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.example.weathercrossplatform.viewmodels.WeatherViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreen(
    weatherViewModel: WeatherViewModel = koinViewModel()
) {
    val weather by weatherViewModel.weather.collectAsStateWithLifecycle()
    val error by weatherViewModel.error.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Granted")
        weather?.let {
            Text(text = "${it.current.tempC} - ${it.location.name}")
        }
        error?.let {
            Text(text = it)
        }
    }
}