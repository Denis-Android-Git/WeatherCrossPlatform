package org.example.weathercrossplatform.presentation.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kashif_e.backdrop.backdrops.LayerBackdrop
import com.kashif_e.backdrop.backdrops.rememberLayerBackdrop
import org.example.weathercrossplatform.data.utils.UiText
import org.example.weathercrossplatform.presentation.icons.CloudsIcon
import org.example.weathercrossplatform.presentation.icons.FeelsLikeIcon
import org.example.weathercrossplatform.presentation.icons.HumidityIcon
import org.example.weathercrossplatform.presentation.icons.PressureIndicator
import org.example.weathercrossplatform.presentation.icons.UvIcon
import org.example.weathercrossplatform.presentation.icons.WindIcon
import org.example.weathercrossplatform.presentation.utils.myLiquidGlass2
import org.example.weathercrossplatform.presentation.utils.noLiquidGlass
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
    modifier: Modifier = Modifier,
    title: StringResource,
    description: String,
    humidity: Float,
    windProgress: Float,
    pressureProgress: Float,
    cloudsProgress: Float,
    windRotation: Float,
    feelsLikeRotation: Float,
    uvIndex: String,
    isPressureMb: Boolean,
    backdrop: LayerBackdrop,
    isLiquidGlassOn: Boolean
) {

    val descriptionList = description.split(" ")

    val formattedDescription = if (descriptionList.size > 1) {
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.White, fontSize = 24.sp)) {
                append(descriptionList[0])
            }
            withStyle(style = SpanStyle(color = Color.White, fontSize = 16.sp)) {
                append(" ${descriptionList[1]}")
            }
        }
    } else {
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.White, fontSize = 24.sp)) {
                append(descriptionList[0])
            }
        }
    }
    Column(
        modifier = if (isLiquidGlassOn) {
            modifier
                .fillMaxWidth()
                .myLiquidGlass2(backdrop)
//            .background(
//                color = Color.Black.copy(alpha = 0.3f),
//                shape = RoundedCornerShape(16.dp)
//            )
                .padding(horizontal = 16.dp, vertical = 16.dp)
        } else {
            modifier
                .fillMaxWidth()
                .noLiquidGlass()
//            .background(
//                color = Color.Black.copy(alpha = 0.3f),
//                shape = RoundedCornerShape(16.dp)
//            )
                .padding(horizontal = 16.dp, vertical = 16.dp)
        },
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = UiText.MyStringResource(title).asString(), color = Color.LightGray
        )
        Text(
            text = formattedDescription
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

@Preview
@Composable
fun WeatherDetailElementPreview() {
    WeatherDetailElement(
        title = Res.string.pressure,
        description = "786.44 mmHg",
        humidity = 0.78f,
        windProgress = 0.5f,
        pressureProgress = 0.5f,
        cloudsProgress = 0.5f,
        windRotation = 0.5f,
        feelsLikeRotation = 0.5f,
        uvIndex = "5",
        isPressureMb = false,
        backdrop = rememberLayerBackdrop(),
        isLiquidGlassOn = false
    )
}