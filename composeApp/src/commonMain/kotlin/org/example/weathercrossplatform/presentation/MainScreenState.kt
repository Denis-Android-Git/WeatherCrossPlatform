package org.example.weathercrossplatform.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent
import org.example.weathercrossplatform.viewmodels.WeatherViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreenState(
    weatherViewModel: WeatherViewModel = koinViewModel()
) {
    val weatherMainScreenState by weatherViewModel.weatherScreenState.collectAsStateWithLifecycle()

    MainScreen(
        weatherMainScreenState = weatherMainScreenState
    )
}