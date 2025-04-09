package org.example.weathercrossplatform.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.example.weathercrossplatform.data.utils.GetScreenHeight
import org.example.weathercrossplatform.domain.models.Forecastday
import org.example.weathercrossplatform.domain.models.WeatherItem

@Composable
fun MainScreen(
    isLoading: Boolean,
    image: String,
    usEpaIndex: Int?,
    locationName: String?,
    temp: String?,
    condition: String?,
    feelsLikeC: String?,
    error: String,
    forecastList: List<Forecastday>?,
    weatherItemList: List<WeatherItem>
) {

    val textColor by remember { mutableStateOf(Color.White) }

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
            visible = !isLoading && locationName != null
        ) {

            val airQualityText =
                when (usEpaIndex) {
                    1 -> "Хорошо"
                    2 -> "Умеренно"
                    3 -> "Плохое для чувствительных групп"
                    4 -> "Плохое"
                    5 -> "Очень Плохое"
                    6 -> "Опасно"
                    else -> ""
                }

            println("airQualityText = $usEpaIndex")

            Box(modifier = Modifier.fillMaxSize()) {
                AsyncImage(
                    model = image,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillHeight,
                    contentDescription = null
                )
                val scrollState = rememberScrollState()
                val maxScrollToFade = 1000f
                val animatedAlpha by animateFloatAsState(
                    targetValue = (1f - (scrollState.value / maxScrollToFade)).coerceIn(0f, 1f)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 160.dp)
                        .graphicsLayer {
                            alpha = animatedAlpha
                        }
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Place,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 52.dp, bottom = 3.dp)
                            .size(15.dp),
                        tint = Color.White
                    )
                    Box(
                        modifier = Modifier
                            .padding(start = 36.dp)
                            .background(
                                color = Color.Black.copy(alpha = 0.2f),
                                shape = RoundedCornerShape(16.dp)
                            )
                    ) {
                        Text(
                            modifier = Modifier.padding(
                                vertical = 2.dp,
                                horizontal = 16.dp
                            ),
                            text = locationName.toString(), color = textColor, fontSize = 20.sp
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(start = 36.dp, top = 16.dp)
                            .background(
                                color = Color.Black.copy(alpha = 0.2f),
                                shape = RoundedCornerShape(16.dp)
                            )
                    ) {
                        Text(
                            modifier = Modifier.padding(
                                vertical = 2.dp,
                                horizontal = 16.dp
                            ),
                            text = "$temp ℃",
                            color = textColor,
                            fontSize = 85.sp
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 36.dp, top = 16.dp)
                            .background(
                                color = Color.Black.copy(alpha = 0.2f),
                                shape = RoundedCornerShape(16.dp)
                            )
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 2.dp),
                            text = "Ощущается $feelsLikeC ℃", color = textColor
                        )
                        Text(
                            modifier = Modifier.padding(start = 16.dp, bottom = 2.dp, end = 16.dp),
                            text = condition.toString(), color = textColor
                        )
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 16.dp)
                            .background(
                                color = Color.White.copy(alpha = 0.2f),
                                shape = RoundedCornerShape(16.dp)
                            )
                    ) {
                        Row(
                            modifier = Modifier.padding(
                                vertical = 6.dp,
                                horizontal = 16.dp
                            )
                        ) {
                            Text(
                                text = "Качество воздуха: ", color = textColor
                            )
                            Text(
                                text = airQualityText, color = when (airQualityText) {
                                    "Хорошо" -> Color.Green
                                    "Умеренно" -> Color(0xff47e6d0)
                                    "Плохое для чувствительных групп" -> Color.Yellow
                                    "Плохое" -> Color(0xFF996600)
                                    "Очень Плохое" -> Color(0xFFCC3300)
                                    "Опасно" -> Color(0xFFFF0000)
                                    else -> Color.Green
                                }
                            )
                        }
                    }
                }

                val height =
                    GetScreenHeight.getScreenHeight() - 160.dp - GetScreenHeight.getBottomBarHeight()

                Column(
                    modifier = Modifier.fillMaxWidth()
                        .fillMaxHeight()
                        .verticalScroll(scrollState)
                        .padding(top = height, bottom = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    forecastList?.let { forecastListDayList ->
                        ForecastElement(
                            forecastList = forecastListDayList
                        )
                        HourForecastElement(
                            hours = forecastListDayList[0].hour
                        )
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            modifier = Modifier.height(370.dp)
                                .fillMaxWidth()
                                .padding(horizontal = 6.dp),
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp),
                            userScrollEnabled = false
                        ) {
                            items(weatherItemList) { item ->
                                WeatherDetailElement(
                                    title = item.title,
                                    description = item.description,
                                    humidity = weatherItemList[0].progress,
                                    windProgress = weatherItemList[1].progress,
                                    pressureProgress = weatherItemList[2].progress,
                                    cloudsProgress = weatherItemList[3].progress,
                                    windRotation = weatherItemList[1].rotation
                                )
                            }
                        }
                    }
                }
            }
        }
        AnimatedVisibility(
            visible = error.isNotEmpty(),
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = error, textAlign = TextAlign.Center)
        }
    }
}


@Composable
fun App() {
    val screenSize = remember { mutableStateOf(Pair(-1, -1)) }
    Layout(
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    "Screen size: ${screenSize.value.first}x${screenSize.value.second}px",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        },
        measurePolicy = { measurables, constraints ->
            // Use the max width and height from the constraints
            val width = constraints.maxWidth
            val height = constraints.maxHeight

            screenSize.value = Pair(width, height)
            println("Width: $width, height: $height")

            // Measure and place children composables
            val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }

            layout(width, height) {
                var yPosition = 0
                placeables.forEach { placeable ->
                    placeable.placeRelative(x = 0, y = yPosition)
                    yPosition += placeable.height
                }
            }
        }
    )
}