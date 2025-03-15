package org.example.weathercrossplatform.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.example.weathercrossplatform.domain.models.WeatherMainScreenState

@Composable
fun MainScreen(
    weatherMainScreenState: WeatherMainScreenState
) {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier.fillMaxSize()
            .background(
                brush = Brush
                    .linearGradient(
                        colors = listOf(
                            Color.Blue.copy(alpha = 0.9f),
                            Color.Blue.copy(alpha = 0f)
                        )
                    )
            )
    ) {
        AnimatedVisibility(
            visible = weatherMainScreenState.isLoading,
            modifier = Modifier.align(Alignment.Center)
        ) {
            CircularProgressIndicator()
        }
        AnimatedVisibility(
            visible = !weatherMainScreenState.isLoading
        ) {

            val icon =
                weatherMainScreenState.weatherDto?.current?.condition?.icon?.replace(
                    "//",
                    "https://"
                )
            val airQualityText =
                when (weatherMainScreenState.weatherDto?.current?.airQuality?.usEpaIndex) {
                    in 0..50 -> "Качество воздуха: Хорошо"
                    in 51..100 -> "Качество воздуха: Умеренно"
                    in 101..150 -> "Качество воздуха: Плохое для чувствительных групп"
                    in 151..200 -> "Качество воздуха: Плохое"
                    in 201..300 -> "Качество воздуха: Очень Плохое"
                    else -> "Качество воздуха: Опасно"
                }

            println("airQualityText = ${weatherMainScreenState.weatherDto?.current?.airQuality?.usEpaIndex}")

            Column(
                modifier = Modifier.fillMaxSize()
                    .scrollable(
                        scrollState,
                        orientation = Orientation.Vertical
                    )
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    AsyncImage(
                        model = icon,
                        modifier = Modifier.fillMaxWidth(),
                        contentDescription = null
                    )
                    Column(
                        modifier = Modifier.padding(start = 16.dp, top = 40.dp)
                    ) {
                        weatherMainScreenState.weatherDto?.let {
                            Text(text = it.location.name, color = Color.White, fontSize = 20.sp)
                            Icon(
                                imageVector = Icons.Filled.LocationOn,
                                contentDescription = null
                            )
                            Text(
                                text = it.current.tempC.toString(),
                                color = Color.White,
                                fontSize = 25.sp
                            )
                            Text(text = it.current.condition.text)
                            Text(text = "Ощущается ${it.current.feelsLikeC}")

                            Text(text = airQualityText)
                        }
                    }
                }
            }
        }
        AnimatedVisibility(
            visible = weatherMainScreenState.error.isNotEmpty(),
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = weatherMainScreenState.error)
        }
    }
}