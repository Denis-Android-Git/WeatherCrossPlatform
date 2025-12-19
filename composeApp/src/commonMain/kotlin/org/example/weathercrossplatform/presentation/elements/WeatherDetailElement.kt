package org.example.weathercrossplatform.presentation.elements

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
import org.example.weathercrossplatform.data.utils.UiText
import org.example.weathercrossplatform.presentation.icons.CloudsIcon
import org.example.weathercrossplatform.presentation.icons.FeelsLikeIcon
import org.example.weathercrossplatform.presentation.icons.HumidityIcon
import org.example.weathercrossplatform.presentation.icons.PressureIndicator
import org.example.weathercrossplatform.presentation.icons.UvIcon
import org.example.weathercrossplatform.presentation.icons.WindIcon
import org.jetbrains.compose.resources.StringResource
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.clouds
import weathercrossplatform.composeapp.generated.resources.feels_like
import weathercrossplatform.composeapp.generated.resources.humidity
import weathercrossplatform.composeapp.generated.resources.pressure
import weathercrossplatform.composeapp.generated.resources.uv
import weathercrossplatform.composeapp.generated.resources.wind


@Composable
fun WeatherDetailElement(
    title: StringResource,
    description: String,
    humidity: Float,
    windProgress: Float,
    pressureProgress: Float,
    cloudsProgress: Float,
    windRotation: Float,
    feelsLikeRotation: Float,
    uvIndex: String,
    isPressureMb: Boolean
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
            text = UiText.MyStringResource(title).asString(), color = Color.LightGray
        )
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            fontSize = 25.sp,
            text = description, color = Color.White
        )
        when (title) {
            Res.string.humidity -> {
                HumidityIcon(
                    modifier = Modifier.align(Alignment.End),
                    progress = humidity
                )
            }

            Res.string.wind -> {
                WindIcon(
                    modifier = Modifier.align(Alignment.End),
                    progress = windProgress,
                    rotation = windRotation
                )
            }

            Res.string.pressure -> {
                PressureIndicator(
                    modifier = Modifier.align(Alignment.End),
                    progress = pressureProgress,
                    isPressureMb = isPressureMb,
                )
            }

            Res.string.clouds -> {
                CloudsIcon(
                    modifier = Modifier.align(Alignment.End),
                    progress = cloudsProgress,
                )
            }

            Res.string.uv -> {
                UvIcon(
                    modifier = Modifier.align(Alignment.End),
                    uvIndex = uvIndex
                )
            }

            Res.string.feels_like -> {
                FeelsLikeIcon(
                    modifier = Modifier.align(Alignment.End),
                    rotationAngle = feelsLikeRotation
                )
            }
        }
    }
}