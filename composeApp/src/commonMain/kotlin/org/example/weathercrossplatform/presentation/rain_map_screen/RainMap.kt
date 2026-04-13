package org.example.weathercrossplatform.presentation.rain_map_screen

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.example.weathercrossplatform.presentation.rain_map_screen.components.WeatherSliderThumb

@Composable
fun RainMapRoot(
    viewModel: RainMapViewModel,
    onBackButtonClick: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    RainMapScreen(
        state = state,
        onAction = viewModel::onAction,
        onBackButtonClick = onBackButtonClick
    )
}