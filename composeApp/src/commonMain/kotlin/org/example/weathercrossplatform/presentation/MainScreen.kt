package org.example.weathercrossplatform.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.style.TextAlign
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.example.weathercrossplatform.data.database.SavedWeatherItem
import org.example.weathercrossplatform.data.utils.GetScreenHeight
import org.example.weathercrossplatform.domain.models.Astro
import org.example.weathercrossplatform.domain.models.Condition
import org.example.weathercrossplatform.domain.models.Day
import org.example.weathercrossplatform.domain.models.Forecastday
import org.example.weathercrossplatform.domain.models.Hour
import org.example.weathercrossplatform.domain.models.WeatherItem

@Composable
fun MainScreen(
    cityId: Int?,
    isLoading: Boolean,
    image: String,
    usEpaIndex: Int?,
    locationName: String?,
    temp: Double?,
    highTemp: Double?,
    lowTemp: Double?,
    condition: String?,
    feelsLikeC: String?,
    error: String,
    forecastList: List<Forecastday>?,
    weatherItemList: List<WeatherItem>,
    savedCityList: List<SavedWeatherItem>,
    onAddButtonClick: () -> Unit,
    onCancelButtonClick: () -> Unit,
    onAddCityButtonClick: (SavedWeatherItem) -> Unit,
    coordinates: String
) {

    val textColor by remember { mutableStateOf(Color.White) }
    val airQualityText by rememberUpdatedState(
        newValue = when (usEpaIndex) {
            1 -> "Хорошо"
            2 -> "Умеренно"
            3 -> "Плохое для чувствительных групп"
            4 -> "Плохое"
            5 -> "Очень Плохое"
            6 -> "Опасно"
            else -> ""
        }
    )

    println("airQualityText = $usEpaIndex")

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
            visible = !isLoading && locationName != null,
            enter = fadeIn(),
            exit = fadeOut()
        ) {

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
                            .padding(start = 36.dp, top = 16.dp, end = 36.dp)
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
                            modifier = Modifier.height(600.dp)
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
                                    windRotation = weatherItemList[1].rotation,
                                    uvIndex = weatherItemList[4].uvIndex.toString(),
                                    feelsLikeRotation = weatherItemList[5].rotation
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
        AnimatedVisibility(
            visible = savedCityList.any {
                println("it.cityId: ${it.cityId}, cityId: $cityId")
                it.cityId == cityId
            },
            modifier = Modifier.align(Alignment.TopEnd).padding(top = 40.dp, end = 16.dp)
        ) {
            IconButton(
                onClick = onAddButtonClick
            ) {
                Icon(
                    imageVector = Icons.Default.Add, contentDescription = "Add",
                    modifier = Modifier.size(35.dp),
                    tint = Color.White
                )
            }
        }
        AnimatedVisibility(
            visible = !savedCityList.any {
                println("it.cityId: ${it.cityId}, cityId: $cityId")
                it.cityId == cityId
            },
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 40.dp, start = 6.dp, end = 6.dp)
            ) {
                Button(
                    onClick = onCancelButtonClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black.copy(alpha = 0.2f),
                    )
                ) {
                    Text(text = "Отмена", color = Color.White, fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {
                        onAddCityButtonClick(
                            SavedWeatherItem(
                                cityName = locationName ?: "",
                                //latitude = latitude,
                                //longitude = longitude,
                                temperature = temp ?: 0.0,
                                weatherDescription = condition ?: "",
                                highTemperature = highTemp ?: 0.0,
                                lowTemperature = lowTemp ?: 0.0,
                                cityId = cityId,
                                coordinates = coordinates,
                                isCurrentLocation = false,
                            )
                        )
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black.copy(alpha = 0.2f),
                    )
                ) {
                    Text(text = "Добавить", color = Color.White, fontSize = 20.sp)
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    val mockHours = listOf(
        Hour(
            chanceOfRain = 0,
            chanceOfSnow = 0,
            cloud = 25,
            condition = Condition(
                text = "Sunny",
                icon = "//cdn.weatherapi.com/weather/64x64/day/116.png",
                code = 1000
            ),
            dewPointC = 12.0,
            dewPointF = 53.6,
            feelsLikeC = 27.0,
            feelsLikeF = 80.6,
            gustKph = 15.0,
            gustMph = 9.3,
            heatIndexC = 27.0,
            heatIndexF = 80.6,
            humidity = 45,
            isDay = 1,
            precipIn = 0.0,
            precipMm = 0.0,
            pressureIn = 29.91,
            pressureMb = 1013.0,
            snowCm = 0.0,
            tempC = 25.0,
            tempF = 77.0,
            time = "12:00",
            timeEpoch = 1705312800,
            uv = 6.0,
            visKm = 10.0,
            visMiles = 6.2,
            willItRain = 0,
            willItSnow = 0,
            windDegree = 315,
            windDir = "NW",
            windKph = 10.0,
            windMph = 6.2,
            windChillC = 24.0,
            windChillF = 75.2
        )
    )

    val mockForecast = listOf(
        Forecastday(
            astro = Astro(
                isMoonUp = 0,
                isSunUp = 1,
                moonIllumination = 25,
                moonPhase = "Waxing Crescent",
                moonrise = "02:15 AM",
                moonset = "01:30 PM",
                sunrise = "06:30 AM",
                sunset = "06:45 PM"
            ),
            date = "2024-01-15",
            dateEpoch = 1705276800,
            day = Day(
                avghumidity = 65,
                avgTempC = 23.0,
                avgTempF = 73.4,
                avgVisKm = 10.0,
                avgVisMiles = 6.2,
                condition = Condition(
                    text = "Partly cloudy",
                    icon = "//cdn.weatherapi.com/weather/64x64/day/116.png",
                    code = 1003
                ),
                dailyChanceOfRain = 10,
                dailyChanceOfSnow = 0,
                dailyWillItRain = 0,
                dailyWillItSnow = 0,
                maxTempC = 28.0,
                maxTempF = 82.4,
                maxWindKph = 15.0,
                maxWindMph = 9.3,
                minTempC = 18.0,
                minTempF = 64.4,
                totalPrecipIn = 0.0,
                totalPrecipMm = 0.0,
                totalSnowCm = 0.0,
                uv = 6.0
            ),
            hour = mockHours
        )
    )

    val mockWeatherItems = listOf(
        WeatherItem(
            title = "Влажность",
            description = "45%",
            progress = 0.45f,
            rotation = 0f,
            uvIndex = 0
        ),
        WeatherItem(
            title = "Ветер",
            description = "10 км/ч",
            progress = 0.3f,
            rotation = 315f,
            uvIndex = 0
        ),
        WeatherItem(
            title = "Давление",
            description = "1013 мб",
            progress = 0.65f,
            rotation = 0f,
            uvIndex = 0
        ),
        WeatherItem(
            title = "Облачность",
            description = "25%",
            progress = 0.25f,
            rotation = 0f,
            uvIndex = 0
        ),
        WeatherItem(
            title = "УФ индекс",
            description = "Высокий",
            progress = 0f,
            rotation = 0f,
            uvIndex = 6
        ),
        WeatherItem(
            title = "Ощущается",
            description = "27°",
            progress = 0f,
            rotation = 90f,
            uvIndex = 0
        )
    )

    val mockSavedCities = listOf(
        SavedWeatherItem(
            cityName = "Москва",
            temperature = 22.0,
            weatherDescription = "Солнечно",
            highTemperature = 25.0,
            lowTemperature = 18.0,
            cityId = 1,
            coordinates = "55.7558,37.6176",
            isCurrentLocation = true
        )
    )

    MainScreen(
        cityId = 1,
        isLoading = false,
        image = "https://images.unsplash.com/photo-1519904981063-b0cf448d479e",
        usEpaIndex = 2,
        locationName = "Москва",
        temp = 23.0,
        highTemp = 28.0,
        lowTemp = 18.0,
        condition = "Переменная облачность",
        feelsLikeC = "25",
        error = "",
        forecastList = mockForecast,
        weatherItemList = mockWeatherItems,
        savedCityList = mockSavedCities,
        onAddButtonClick = { },
        onCancelButtonClick = { },
        onAddCityButtonClick = { },
        coordinates = "55.7558,37.6176"
    )
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