package org.example.weathercrossplatform.presentation.weather_list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionOnScreen
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.kashif_e.backdrop.backdrops.layerBackdrop
import com.kashif_e.backdrop.backdrops.rememberLayerBackdrop
import org.example.weathercrossplatform.data.constants.Constants.ALPHA_THRESHOLD
import org.example.weathercrossplatform.data.database.SavedWeatherItem
import org.example.weathercrossplatform.data.network.dto.ForecastDto
import org.example.weathercrossplatform.data.utils.UiText
import org.example.weathercrossplatform.data.utils.toUiText
import org.example.weathercrossplatform.domain.models.AirQuality
import org.example.weathercrossplatform.domain.models.Astro
import org.example.weathercrossplatform.domain.models.Condition
import org.example.weathercrossplatform.domain.models.Current
import org.example.weathercrossplatform.domain.models.Day
import org.example.weathercrossplatform.domain.models.Forecast
import org.example.weathercrossplatform.domain.models.Forecastday
import org.example.weathercrossplatform.domain.models.Hour
import org.example.weathercrossplatform.domain.models.Location
import org.example.weathercrossplatform.domain.models.WeatherItem
import org.example.weathercrossplatform.domain.models.WeatherMainScreenState
import org.example.weathercrossplatform.presentation.elements.FloatingToolBar
import org.example.weathercrossplatform.presentation.elements.Forecast24Hour
import org.example.weathercrossplatform.presentation.elements.LiquidButton
import org.example.weathercrossplatform.presentation.elements.ThreeDaysForecast
import org.example.weathercrossplatform.presentation.elements.WeatherDetailElement
import org.example.weathercrossplatform.presentation.utils.currentDeviceConfiguration
import org.example.weathercrossplatform.presentation.utils.myLiquidGlass2
import org.example.weathercrossplatform.presentation.utils.noLiquidGlass
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.add
import weathercrossplatform.composeapp.generated.resources.air_quality
import weathercrossplatform.composeapp.generated.resources.air_quality_level_1
import weathercrossplatform.composeapp.generated.resources.air_quality_level_2
import weathercrossplatform.composeapp.generated.resources.air_quality_level_3
import weathercrossplatform.composeapp.generated.resources.air_quality_level_4
import weathercrossplatform.composeapp.generated.resources.air_quality_level_5
import weathercrossplatform.composeapp.generated.resources.air_quality_level_6
import weathercrossplatform.composeapp.generated.resources.cancel
import weathercrossplatform.composeapp.generated.resources.clouds
import weathercrossplatform.composeapp.generated.resources.feels_like
import weathercrossplatform.composeapp.generated.resources.forecast_by
import weathercrossplatform.composeapp.generated.resources.humidity
import weathercrossplatform.composeapp.generated.resources.pressure
import weathercrossplatform.composeapp.generated.resources.uv
import weathercrossplatform.composeapp.generated.resources.weather_api
import weathercrossplatform.composeapp.generated.resources.wind

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier,
    weatherMainScreenState: WeatherMainScreenState,
    cityId: Int?,
    savedCityList: List<SavedWeatherItem>,
    onAddButtonClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onCancelButtonClick: () -> Unit,
    onAddCityButtonClick: () -> Unit,
    isCurrentLocation: Boolean,
    topPadding: Dp,
    //myLogger: MyLogger = MyLoggerImpl
) {

    val textColor = Color.White
    val airQualityText =
        weatherMainScreenState.weatherDto?.current?.airQuality?.usEpaIndex?.toUiText()

    val lazyListState = rememberLazyListState()

    var fabYPosition by remember {
        mutableStateOf(0f)
    }
    var fabMaxYPosition by rememberSaveable {
        mutableStateOf(0f)
    }

    LaunchedEffect(fabYPosition) {
        if (fabYPosition > fabMaxYPosition) {
            fabMaxYPosition = fabYPosition
        }
    }

    var firstElementInLazyColumnYPosition by remember {
        mutableStateOf(0f)
    }
    var firstElementMaxYPosition by rememberSaveable { mutableStateOf(0f) }

    LaunchedEffect(firstElementInLazyColumnYPosition) {
        if (firstElementInLazyColumnYPosition > firstElementMaxYPosition) {
            firstElementMaxYPosition = firstElementInLazyColumnYPosition
        }
    }

    val animatedAlpha by animateFloatAsState(
        targetValue = ((firstElementInLazyColumnYPosition - (fabMaxYPosition + ALPHA_THRESHOLD)) /
                (firstElementMaxYPosition - (fabMaxYPosition + ALPHA_THRESHOLD))).coerceIn(0f, 1f)
    )

    val configuration = currentDeviceConfiguration()
    val cityKey = weatherMainScreenState.weatherDto?.location?.name
    val updatedKey = weatherMainScreenState.weatherDto?.current?.lastUpdatedEpoch

    val randomPicNumber by rememberUpdatedState(newValue = weatherMainScreenState.randomPicNumber)
    val imageError = if (configuration.isPortrait) {
        weatherMainScreenState.appPhotoList[randomPicNumber]
    } else {
        weatherMainScreenState.landscapePhotoList[randomPicNumber]
    }

    //myLogger.debug("imageError = $imageError")

    val stableImageModel =
        remember(cityKey, updatedKey, configuration.isPortrait, weatherMainScreenState.image) {
            weatherMainScreenState.image.ifEmpty {
                imageError
            }
        }

    val density = LocalDensity.current
    val totalPadding = 100.dp
    var columnHeight by remember {
        mutableStateOf(0.dp)
    }
    val backdrop = rememberLayerBackdrop()

    Scaffold(
        contentWindowInsets = WindowInsets.safeDrawing,
        containerColor = Color.Black,
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        AnimatedVisibility(
                            visible = animatedAlpha == 0f,
                            enter = slideInVertically(
                                initialOffsetY = { it },
                            ),
                            exit = slideOutVertically(
                                targetOffsetY = { it }
                            )
                        ) {
                            Text(
                                text = weatherMainScreenState.weatherDto?.location?.name.toString(),
                                color = Color.White, fontSize = 20.sp
                            )
                        }
                    }
                },
                expandedHeight = 30.dp,
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black,
                    scrolledContainerColor = Color.Black
                )
            )
        }
    )
    { paddingValues ->
        Box(
            modifier = modifier.fillMaxSize().padding(paddingValues)
        ) {
            AnimatedVisibility(
                visible = !weatherMainScreenState.isLoading && weatherMainScreenState.weatherDto?.location?.name != null,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    AsyncImage(
                        model = stableImageModel,
                        error = painterResource(imageError),
                        modifier = Modifier.fillMaxSize().layerBackdrop(backdrop),
                        contentScale = ContentScale.Crop,
                        contentDescription = null
                    )
                    Box(
                        modifier = Modifier
                            .widthIn(max = 600.dp).align(Alignment.Center)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = topPadding, start = 16.dp, end = 16.dp)
                                .graphicsLayer {
                                    alpha = animatedAlpha
                                }
                                .onGloballyPositioned {
                                    columnHeight = with(density) {
                                        it.size.height.toDp()
                                    }
                                }
                        ) {
                            if (isCurrentLocation) {
                                Icon(
                                    imageVector = Icons.Outlined.Place,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(
                                            start = 16.dp,
                                            bottom = 3.dp
                                        )
                                        .size(15.dp),
                                    tint = Color.White
                                )
                            }
                            Box(
                                modifier = if (weatherMainScreenState.isLiquidGlassOn) {
                                    Modifier
                                        .myLiquidGlass2(backdrop)
                                } else {
                                    Modifier.noLiquidGlass()

                                }
                            ) {
                                Text(
                                    modifier = Modifier.padding(
                                        vertical = 2.dp,
                                        horizontal = 16.dp
                                    ),
                                    text = weatherMainScreenState.weatherDto?.location?.name.toString(),
                                    color = textColor,
                                    fontSize = 20.sp
                                )
                            }

                            Box(
                                modifier = if (weatherMainScreenState.isLiquidGlassOn) {
                                    Modifier
                                        .padding(top = 8.dp)
                                        .myLiquidGlass2(backdrop)
                                } else {
                                    Modifier
                                        .padding(top = 8.dp)
                                        .noLiquidGlass()
                                }
                            ) {
                                Text(
                                    modifier = Modifier.padding(
                                        vertical = 2.dp,
                                        horizontal = 16.dp
                                    ),
                                    text = if (weatherMainScreenState.isTempC) "${weatherMainScreenState.weatherDto?.current?.tempC} ℃" else "${weatherMainScreenState.weatherDto?.current?.tempF} ℉",
                                    color = textColor,
                                    fontSize = 85.sp
                                )
                            }
                            Column(
                                modifier = if (weatherMainScreenState.isLiquidGlassOn) {
                                    Modifier
                                        .padding(top = 16.dp)
                                        .myLiquidGlass2(backdrop)
                                } else {
                                    Modifier
                                        .padding(top = 16.dp)
                                        .noLiquidGlass()
                                }
                            ) {
                                Text(
                                    modifier = Modifier.padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                        top = 2.dp
                                    ),
                                    text = when {
                                        weatherMainScreenState.isTempC -> "${stringResource(Res.string.feels_like)} ${weatherMainScreenState.weatherDto?.current?.feelsLikeC} ℃"
                                        else -> "${stringResource(Res.string.feels_like)} ${weatherMainScreenState.weatherDto?.current?.feelsLikeF} ℉"
                                    }, color = textColor
                                )
                                Text(
                                    modifier = Modifier.padding(
                                        start = 16.dp,
                                        bottom = 2.dp,
                                        end = 16.dp
                                    ),
                                    text = weatherMainScreenState.weatherDto?.current?.condition?.text.toString(),
                                    color = textColor
                                )
                            }
                            Box(
                                modifier = if (weatherMainScreenState.isLiquidGlassOn) {
                                    Modifier
                                        .align(Alignment.CenterHorizontally)
                                        .padding(top = 16.dp)
                                        .myLiquidGlass2(backdrop)
                                } else {
                                    Modifier
                                        .align(Alignment.CenterHorizontally)
                                        .padding(top = 16.dp)
                                        .noLiquidGlass()
                                }
                            ) {
                                Row(
                                    modifier = Modifier.padding(
                                        vertical = 6.dp,
                                        horizontal = 16.dp
                                    )
                                ) {
                                    Text(
                                        text = stringResource(Res.string.air_quality),
                                        color = textColor
                                    )
                                    airQualityText?.asString()?.let { airQuality ->
                                        Text(
                                            text = airQuality, color = airQuality.toColor()
                                        )
                                    }
                                }
                            }
                        }
                        val paddingSum = (columnHeight + topPadding + totalPadding)

                        LazyColumn(
                            state = lazyListState,
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentPadding = PaddingValues(
                                top = paddingSum,
                                bottom = 20.dp,
                                start = 6.dp,
                                end = 6.dp
                            ),
                            verticalArrangement = Arrangement.spacedBy(6.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            weatherMainScreenState.weatherDto?.forecast?.forecastday?.let { forecastListDayList ->
                                item {
                                    ThreeDaysForecast(
                                        modifier = Modifier.onGloballyPositioned {
                                            firstElementInLazyColumnYPosition =
                                                it.positionOnScreen().y
                                        },
                                        forecastList = forecastListDayList,
                                        isTempC = weatherMainScreenState.isTempC,
                                        backdrop = backdrop,
                                        isLiquidGlassOn = weatherMainScreenState.isLiquidGlassOn
                                    )
                                }
                                item {
                                    Forecast24Hour(
                                        hours = forecastListDayList[0].hour,
                                        isTempC = weatherMainScreenState.isTempC,
                                        isWindKmh = weatherMainScreenState.isWindKph,
                                        backdrop = backdrop,
                                        isLiquidGlassOn = weatherMainScreenState.isLiquidGlassOn
                                    )
                                }
                                item {
                                    LazyVerticalGrid(
                                        columns = GridCells.Fixed(2),
                                        modifier = Modifier.height(500.dp)
                                            .fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                                        verticalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        items(
                                            weatherMainScreenState.weatherItemList,
                                            key = {
                                                it.id
                                            }
                                        ) { item ->
                                            WeatherDetailElement(
                                                title = item.title,
                                                description = when (item.description) {
                                                    is String -> item.description
                                                    is StringResource -> UiText.MyStringResource(
                                                        item.description
                                                    )
                                                        .asString()

                                                    else -> ""
                                                },
                                                humidity = weatherMainScreenState.weatherItemList[0].progress,
                                                windProgress = weatherMainScreenState.weatherItemList[1].progress,
                                                pressureProgress = weatherMainScreenState.weatherItemList[2].progress,
                                                cloudsProgress = weatherMainScreenState.weatherItemList[3].progress,
                                                windRotation = weatherMainScreenState.weatherItemList[1].rotation,
                                                uvIndex = weatherMainScreenState.weatherItemList[4].uvIndex.toString(),
                                                feelsLikeRotation = weatherMainScreenState.weatherItemList[5].rotation,
                                                isPressureMb = weatherMainScreenState.isPressureMb,
                                                backdrop = backdrop,
                                                isLiquidGlassOn = weatherMainScreenState.isLiquidGlassOn
                                            )
                                        }
                                    }
                                }
                                item {
                                    Text(
                                        text = stringResource(Res.string.forecast_by),
                                        fontSize = 11.sp,
                                        color = textColor,
                                    )
                                }
                                item {
                                    Image(
                                        painterResource(Res.drawable.weather_api),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .width(60.dp)
                                            .clip(RoundedCornerShape(6.dp))
                                    )
                                }
                            }
                        }
                    }
                }
            }
            val cityIdList = savedCityList.associateBy {
                it.cityId
            }
            val isCityIdListContainsCityId = cityIdList.containsKey(cityId)
            AnimatedVisibility(
                visible = isCityIdListContainsCityId && animatedAlpha != 0f,
                modifier = Modifier.align(Alignment.TopEnd).padding(4.dp)
            ) {
                FloatingToolBar(
                    modifier = Modifier.onGloballyPositioned {
                        fabYPosition = it.positionOnScreen().y
                    },
                    onSearchClick = onAddButtonClick,
                    onSettingsClick = onSettingsClick
                )
            }
            AnimatedVisibility(
                visible = !isCityIdListContainsCityId,
                modifier = Modifier.align(Alignment.TopStart)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 40.dp, start = 6.dp, end = 6.dp)
                ) {
                    if (weatherMainScreenState.isLiquidGlassOn) {
                        LiquidButton(
                            onClick = onCancelButtonClick,
                            backdrop = backdrop
                        ) {
                            Text(
                                text = stringResource(Res.string.cancel),
                                color = Color.White,
                                fontSize = 20.sp
                            )
//                        BasicText(
//                            stringResource(Res.string.cancel),
//                            style = TextStyle(Color.Black, 15.sp)
//                        )
                        }
                    } else {
                        Button(
                            onClick = onCancelButtonClick,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black.copy(alpha = 0.2f),
                            )
                        ) {
                            Text(
                                text = stringResource(Res.string.cancel),
                                color = Color.White,
                                fontSize = 20.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    if (weatherMainScreenState.isLiquidGlassOn) {
                        LiquidButton(
                            onClick = {
                                onAddCityButtonClick()
                            },
                            backdrop = backdrop
                        ) {
                            Text(
                                text = stringResource(Res.string.add),
                                color = Color.White,
                                fontSize = 20.sp
                            )
//                        BasicText(
//                            stringResource(Res.string.add),
//                            style = TextStyle(Color.Black, 15.sp)
//                        )
                        }
                    } else {
                        Button(
                            onClick = {
                                onAddCityButtonClick()
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black.copy(alpha = 0.2f),
                            )
                        ) {
                            Text(
                                text = stringResource(Res.string.add),
                                color = Color.White,
                                fontSize = 20.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun String.toColor(): Color {
    return when (this) {
        stringResource(Res.string.air_quality_level_1) -> Color.Green
        stringResource(Res.string.air_quality_level_2) -> Color(0xff47e6d0)
        stringResource(Res.string.air_quality_level_3) -> Color.Yellow
        stringResource(Res.string.air_quality_level_4) -> Color(0xFF996600)
        stringResource(Res.string.air_quality_level_5) -> Color(0xFFCC3300)
        stringResource(Res.string.air_quality_level_6) -> Color(0xFFFF0000)
        else -> Color.Green
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    val mockWeatherItems = listOf(
        WeatherItem(
            title = Res.string.humidity,
            description = "45%",
            progress = 0.45f,
            rotation = 0f,
            uvIndex = 0,
            id = 1
        ),
        WeatherItem(
            title = Res.string.wind,
            description = "10 км/ч",
            progress = 0.3f,
            rotation = 315f,
            uvIndex = 0,
            id = 2
        ),
        WeatherItem(
            title = Res.string.pressure,
            description = "1013 мб",
            progress = 0.65f,
            rotation = 0f,
            uvIndex = 0,
            id = 3
        ),
        WeatherItem(
            title = Res.string.clouds,
            description = "25%",
            progress = 0.25f,
            rotation = 0f,
            uvIndex = 0,
            id = 4
        ),
        WeatherItem(
            title = Res.string.uv,
            description = "Высокий",
            progress = 0f,
            rotation = 0f,
            uvIndex = 6,
            id = 5
        ),
        WeatherItem(
            title = Res.string.feels_like,
            description = "27°",
            progress = 0f,
            rotation = 90f,
            uvIndex = 0,
            id = 6
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
    val dto = ForecastDto(
        current = Current(
            airQuality = AirQuality(
                usEpaIndex = 2,
                pm25 = 12.0,
                pm10 = 18.0,
                o3 = 40.0,
                no2 = 8.0,
                co = 0.4,
                so2 = 2.0
            ),
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
            lastUpdated = "2024-01-15 12:00",
            lastUpdatedEpoch = 1705312800,
            precipIn = 0.0,
            precipMm = 0.0,
            pressureIn = 29.91,
            pressureMb = 1013.0,
            tempC = 25.0,
            tempF = 77.0,
            uv = 6.0,
            visKm = 10.0,
            visMiles = 6.2,
            windDegree = 315,
            windDir = "NW",
            windKph = 10.0,
            windMph = 6.2,
            windChillC = 24.0,
            windChillF = 75.2
        ),
        forecast = Forecast(forecastday = mockForecast),
        location = Location(
            country = "Россия",
            id = 1,
            lat = 55.7558,
            lon = 37.6176,
            name = "Москва",
            region = "Москва",
            url = null
        )
    )
    MainScreen(
        cityId = 1,
        savedCityList = mockSavedCities,
        onAddButtonClick = { },
        onCancelButtonClick = { },
        onAddCityButtonClick = { },
        isCurrentLocation = true,
        weatherMainScreenState = WeatherMainScreenState(
            weatherItemList = mockWeatherItems,
            weatherDto = dto
        ),
        onSettingsClick = {},
        modifier = Modifier,
        topPadding = 50.dp
    )
}

val mockHours = listOf(
    Hour(
        chanceOfRain = 0.0,
        chanceOfSnow = 0.0,
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
            dailyChanceOfRain = 1.0,
            dailyChanceOfSnow = 0.0,
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
    ),
    Forecastday(
        astro = Astro(
            isMoonUp = 8847,
            isSunUp = 1545,
            moonIllumination = 2751,
            moonPhase = "atqui",
            moonrise = "veri",
            moonset = "vivamus",
            sunrise = "ceteros",
            sunset = "qui"
        ), date = "eget", dateEpoch = 1295,
        day = Day(
            avghumidity = 7916,
            avgTempC = 168.169,
            avgTempF = 170.171,
            avgVisKm = 172.173,
            avgVisMiles = 174.175,
            condition = Condition(
                code = 1125, icon = "facilisi", text = "populo"

            ),
            dailyChanceOfRain = 7.358,
            dailyChanceOfSnow = 5.564,
            dailyWillItRain = 1626,
            dailyWillItSnow = 9274,
            maxTempC = 176.177,
            maxTempF = 178.179,
            maxWindKph = 180.181,
            maxWindMph = 182.183,
            minTempC = 184.185,
            minTempF = 186.187,
            totalPrecipIn = 188.189,
            totalPrecipMm = 190.191,
            totalSnowCm = 192.193,
            uv = 194.195

        ), hour = listOf()
    )
)

//
//@Composable
//fun App() {
//    val screenSize = remember { mutableStateOf(Pair(-1, -1)) }
//    Layout(
//        content = {
//            Box(modifier = Modifier.fillMaxSize()) {
//                Text(
//                    "Screen size: ${screenSize.value.first}x${screenSize.value.second}px",
//                    modifier = Modifier.align(Alignment.Center)
//                )
//            }
//        },
//        measurePolicy = { measurables, constraints ->
//            // Use the max width and height from the constraints
//            val width = constraints.maxWidth
//            val height = constraints.maxHeight
//
//            screenSize.value = Pair(width, height)
//            //myLogger("Width: $width, height: $height")
//
//            // Measure and place children composables
//            val placeables = measurables.map { measurable ->
//                measurable.measure(constraints)
//            }
//
//            layout(width, height) {
//                var yPosition = 0
//                placeables.forEach { placeable ->
//                    placeable.placeRelative(x = 0, y = yPosition)
//                    yPosition += placeable.height
//                }
//            }
//        }
//    )
//}