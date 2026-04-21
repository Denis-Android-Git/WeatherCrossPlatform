package org.example.weathercrossplatform.presentation.rain_map_screen

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.example.weathercrossplatform.presentation.rain_map_screen.components.WeatherSliderThumb
import org.example.weathercrossplatform.presentation.utils.noLiquidGlass


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RainMapScreen(
    state: RainMapState,
    onAction: (RainMapAction) -> Unit,
    onBackButtonClick: () -> Unit
) {
    val animatedSliderValue by animateFloatAsState(
        targetValue = state.sliderValue,
        animationSpec = tween(
            durationMillis = 500,
            easing = FastOutSlowInEasing
        ),
        label = "weather_slider"
    )

    Box(modifier = Modifier.fillMaxSize()) {
        RainMapWebView(
            modifier = Modifier.matchParentSize(),
            latitude = state.latitude,
            longitude = state.longitude,
            zoom = state.zoom,
            date = state.date,
            hour = state.hour
        )

        Slider(
            value = animatedSliderValue,
            onValueChange = {
                onAction(RainMapAction.OnSliderChanged(it))
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 46.dp),
            valueRange = 0f..23f,
            colors = SliderDefaults.colors(
                activeTrackColor = Color.Black.copy(alpha = 0.5f),
                inactiveTrackColor = Color.Black.copy(alpha = 0.2f),
                disabledActiveTrackColor = Color.Black.copy(alpha = 0.5f),
                disabledInactiveTrackColor = Color.Black.copy(alpha = 0.2f)
            ),
            thumb = {
                WeatherSliderThumb(
                    value = state.sliderValue.toInt().toString()
                )
            }
        )
        Box(
            modifier = Modifier.systemBarsPadding().padding(10.dp)
                .noLiquidGlass()
        ) {
            IconButton(
                onClick = onBackButtonClick,
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "back",
                    tint = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun RainMapScreenPreview() {
    RainMapScreen(
        state = RainMapState(),
        onAction = {},
        onBackButtonClick = {}
    )
}