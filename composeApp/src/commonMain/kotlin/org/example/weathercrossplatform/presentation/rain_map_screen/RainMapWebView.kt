package org.example.weathercrossplatform.presentation.rain_map_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun RainMapWebView(
    latitude: Double,
    longitude: Double,
    zoom: Int,
    date: String,
    hour: String,
    modifier: Modifier = Modifier
)