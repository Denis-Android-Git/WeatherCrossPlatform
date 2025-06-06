package org.example.weathercrossplatform.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.weathercrossplatform.presentation.icons.CloudsIcon
import org.example.weathercrossplatform.presentation.icons.FeelsLikeIcon
import org.example.weathercrossplatform.presentation.icons.HumidityIcon
import org.example.weathercrossplatform.presentation.icons.PressureIndicator
import org.example.weathercrossplatform.presentation.icons.UvIcon
import org.example.weathercrossplatform.presentation.icons.WindIcon


@Composable
fun WeatherDetailElement(
    title: String,
    description: String,
    humidity: Float,
    windProgress: Float,
    pressureProgress: Float,
    cloudsProgress: Float,
    windRotation: Float,
    feelsLikeRotation: Float,
    uvIndex: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.Black.copy(alpha = 0.3f),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 6.dp),
            text = title, color = Color.LightGray
        )
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            fontSize = 25.sp,
            text = description, color = Color.White
        )
        when (title) {
            "Humidity" -> {
                HumidityIcon(
                    modifier = Modifier.align(Alignment.End),
                    progress = humidity
                )
            }

            "Wind" -> {
                WindIcon(
                    modifier = Modifier.align(Alignment.End),
                    progress = windProgress,
                    rotation = windRotation
                )
            }

            "Pressure" -> {
                PressureIndicator(
                    modifier = Modifier.align(Alignment.End),
                    progress = pressureProgress,
                )
            }

            "Clouds" -> {
                CloudsIcon(
                    modifier = Modifier.align(Alignment.End),
                    progress = cloudsProgress,
                )
            }

            "Uv" -> {
                UvIcon(
                    modifier = Modifier.align(Alignment.End),
                    uvIndex = uvIndex
                )
            }

            "Feels Like" -> {
                FeelsLikeIcon(
                    modifier = Modifier.align(Alignment.End),
                    rotationAngle = feelsLikeRotation
                )
            }
        }
    }
}