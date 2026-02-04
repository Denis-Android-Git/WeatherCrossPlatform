package org.example.weathercrossplatform.presentation.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kashif_e.backdrop.backdrops.LayerBackdrop
import com.kashif_e.backdrop.backdrops.rememberLayerBackdrop
import kotlinx.coroutines.launch
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.example.weathercrossplatform.data.logger_impl.MyLoggerImpl
import org.example.weathercrossplatform.domain.logger.MyLogger
import org.example.weathercrossplatform.domain.models.Condition
import org.example.weathercrossplatform.domain.models.Hour
import org.example.weathercrossplatform.presentation.utils.myLiquidGlass2
import org.example.weathercrossplatform.presentation.utils.noLiquidGlass
import org.jetbrains.compose.resources.stringResource
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources._24h_forecast
import kotlin.time.Clock

@Composable
fun Forecast24Hour(
    modifier: Modifier = Modifier,
    hours: List<Hour>,
    isTempC: Boolean,
    isWindKmh: Boolean,
    myLogger: MyLogger = MyLoggerImpl,
    backdrop: LayerBackdrop,
    isLiquidGlassOn: Boolean
) {

    val maxTemp = hours.maxOf { if (isTempC) it.tempC.toFloat() else it.tempF.toFloat() }
    val minTemp = hours.minOf { if (isTempC) it.tempC.toFloat() else it.tempF.toFloat() }
    val rowState = rememberLazyListState()

    val currentTime = Clock.System.now()
    val hour = currentTime.toLocalDateTime(TimeZone.currentSystemDefault()).hour

    val scope = rememberCoroutineScope()
    scope.launch {
        myLogger.debug("currentTime: animateScrollToItem")
        rowState.animateScrollToItem(hour)
    }

    Column(
        modifier = if (isLiquidGlassOn) {
            modifier
                .fillMaxWidth()
                .myLiquidGlass2(backdrop)
        } else {
            modifier
                .fillMaxWidth()
                .noLiquidGlass()
        }
        //.background(color = Color.Black.copy(alpha = 0.3f), shape = RoundedCornerShape(16.dp)),
    ) {
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 26.dp),
            text = stringResource(Res.string._24h_forecast), color = Color.LightGray
        )

        LazyRow(
            modifier = Modifier.padding(bottom = 16.dp),
            state = rowState
        ) {
            itemsIndexed(hours) { index, item ->
                val icon = item.condition.icon.replace("//", "https://")
                val time = item.time.substringAfter(" ")
                myLogger.debug("item_time: ${item.time}")
                val prevTemp = when {
                    isTempC -> if (index > 0) hours[index - 1].tempC.toFloat() else item.tempC.toFloat()
                    else -> if (index > 0) hours[index - 1].tempF.toFloat() else item.tempF.toFloat()
                }
                ForecastRowItem(
                    temp = if (isTempC) item.tempC.toString() else item.tempF.toString(),
                    icon = icon,
                    wind = if (isWindKmh) item.windKph.toString() else item.windMph.toString(),
                    time = time,
                    previousTemp = prevTemp,
                    maxTemp = maxTemp,
                    minTemp = minTemp,
                    isWindKmh = isWindKmh
                )
            }
        }
    }
}

@Preview
@Composable
fun HourForecastElementPreview() {
    val sampleHours = listOf(
        Hour(
            chanceOfRain = 0,
            chanceOfSnow = 0,
            cloud = 10,
            condition = Condition(
                code = 1000,
                icon = "//cdn.weatherapi.com/weather/64x64/day/113.png",
                text = "Sunny"
            ),
            dewPointC = 12.0,
            dewPointF = 53.6,
            feelsLikeC = 18.0,
            feelsLikeF = 64.4,
            gustKph = 15.0,
            gustMph = 9.3,
            heatIndexC = 18.0,
            heatIndexF = 64.4,
            humidity = 60,
            isDay = 1,
            precipIn = 0.0,
            precipMm = 0.0,
            pressureIn = 30.1,
            pressureMb = 1018.0,
            snowCm = 0.0,
            tempC = 18.0,
            tempF = 64.4,
            time = "2024-01-15 00:00",
            timeEpoch = 1705276800,
            uv = 0.0,
            visKm = 10.0,
            visMiles = 6.2,
            willItRain = 0,
            willItSnow = 0,
            windDegree = 180,
            windDir = "S",
            windKph = 12.0,
            windMph = 7.5,
            windChillC = 18.0,
            windChillF = 64.4
        ),
        Hour(
            chanceOfRain = 0,
            chanceOfSnow = 0,
            cloud = 5,
            condition = Condition(
                code = 1000,
                icon = "//cdn.weatherapi.com/weather/64x64/night/113.png",
                text = "Clear"
            ),
            dewPointC = 11.0,
            dewPointF = 51.8,
            feelsLikeC = 16.0,
            feelsLikeF = 60.8,
            gustKph = 12.0,
            gustMph = 7.5,
            heatIndexC = 16.0,
            heatIndexF = 60.8,
            humidity = 65,
            isDay = 0,
            precipIn = 0.0,
            precipMm = 0.0,
            pressureIn = 30.1,
            pressureMb = 1018.0,
            snowCm = 0.0,
            tempC = 16.0,
            tempF = 60.8,
            time = "2024-01-15 03:00",
            timeEpoch = 1705287600,
            uv = 0.0,
            visKm = 10.0,
            visMiles = 6.2,
            willItRain = 0,
            willItSnow = 0,
            windDegree = 180,
            windDir = "S",
            windKph = 10.0,
            windMph = 6.2,
            windChillC = 16.0,
            windChillF = 60.8
        ),
        Hour(
            chanceOfRain = 0,
            chanceOfSnow = 0,
            cloud = 0,
            condition = Condition(
                code = 1000,
                icon = "//cdn.weatherapi.com/weather/64x64/night/113.png",
                text = "Clear"
            ),
            dewPointC = 10.0,
            dewPointF = 50.0,
            feelsLikeC = 14.0,
            feelsLikeF = 57.2,
            gustKph = 10.0,
            gustMph = 6.2,
            heatIndexC = 14.0,
            heatIndexF = 57.2,
            humidity = 70,
            isDay = 0,
            precipIn = 0.0,
            precipMm = 0.0,
            pressureIn = 30.1,
            pressureMb = 1018.0,
            snowCm = 0.0,
            tempC = 14.0,
            tempF = 57.2,
            time = "2024-01-15 06:00",
            timeEpoch = 1705298400,
            uv = 0.0,
            visKm = 10.0,
            visMiles = 6.2,
            willItRain = 0,
            willItSnow = 0,
            windDegree = 180,
            windDir = "S",
            windKph = 8.0,
            windMph = 5.0,
            windChillC = 14.0,
            windChillF = 57.2
        ),
        Hour(
            chanceOfRain = 0,
            chanceOfSnow = 0,
            cloud = 5,
            condition = Condition(
                code = 1000,
                icon = "//cdn.weatherapi.com/weather/64x64/day/113.png",
                text = "Sunny"
            ),
            dewPointC = 12.0,
            dewPointF = 53.6,
            feelsLikeC = 16.0,
            feelsLikeF = 60.8,
            gustKph = 12.0,
            gustMph = 7.5,
            heatIndexC = 16.0,
            heatIndexF = 60.8,
            humidity = 65,
            isDay = 1,
            precipIn = 0.0,
            precipMm = 0.0,
            pressureIn = 30.1,
            pressureMb = 1018.0,
            snowCm = 0.0,
            tempC = 16.0,
            tempF = 60.8,
            time = "2024-01-15 09:00",
            timeEpoch = 1705309200,
            uv = 2.0,
            visKm = 10.0,
            visMiles = 6.2,
            willItRain = 0,
            willItSnow = 0,
            windDegree = 180,
            windDir = "S",
            windKph = 10.0,
            windMph = 6.2,
            windChillC = 16.0,
            windChillF = 60.8
        ),
        Hour(
            chanceOfRain = 0,
            chanceOfSnow = 0,
            cloud = 10,
            condition = Condition(
                code = 1000,
                icon = "//cdn.weatherapi.com/weather/64x64/day/113.png",
                text = "Sunny"
            ),
            dewPointC = 13.0,
            dewPointF = 55.4,
            feelsLikeC = 20.0,
            feelsLikeF = 68.0,
            gustKph = 15.0,
            gustMph = 9.3,
            heatIndexC = 20.0,
            heatIndexF = 68.0,
            humidity = 55,
            isDay = 1,
            precipIn = 0.0,
            precipMm = 0.0,
            pressureIn = 30.0,
            pressureMb = 1016.0,
            snowCm = 0.0,
            tempC = 20.0,
            tempF = 68.0,
            time = "2024-01-15 12:00",
            timeEpoch = 1705320000,
            uv = 6.0,
            visKm = 10.0,
            visMiles = 6.2,
            willItRain = 0,
            willItSnow = 0,
            windDegree = 200,
            windDir = "SSW",
            windKph = 14.0,
            windMph = 8.7,
            windChillC = 20.0,
            windChillF = 68.0
        ),
        Hour(
            chanceOfRain = 0,
            chanceOfSnow = 0,
            cloud = 15,
            condition = Condition(
                code = 1000,
                icon = "//cdn.weatherapi.com/weather/64x64/day/113.png",
                text = "Sunny"
            ),
            dewPointC = 14.0,
            dewPointF = 57.2,
            feelsLikeC = 22.0,
            feelsLikeF = 71.6,
            gustKph = 18.0,
            gustMph = 11.2,
            heatIndexC = 22.0,
            heatIndexF = 71.6,
            humidity = 50,
            isDay = 1,
            precipIn = 0.0,
            precipMm = 0.0,
            pressureIn = 29.9,
            pressureMb = 1013.0,
            snowCm = 0.0,
            tempC = 22.0,
            tempF = 71.6,
            time = "2024-01-15 15:00",
            timeEpoch = 1705330800,
            uv = 7.0,
            visKm = 10.0,
            visMiles = 6.2,
            willItRain = 0,
            willItSnow = 0,
            windDegree = 220,
            windDir = "SW",
            windKph = 16.0,
            windMph = 9.9,
            windChillC = 22.0,
            windChillF = 71.6
        ),
        Hour(
            chanceOfRain = 0,
            chanceOfSnow = 0,
            cloud = 20,
            condition = Condition(
                code = 1003,
                icon = "//cdn.weatherapi.com/weather/64x64/day/116.png",
                text = "Partly cloudy"
            ),
            dewPointC = 15.0,
            dewPointF = 59.0,
            feelsLikeC = 21.0,
            feelsLikeF = 69.8,
            gustKph = 16.0,
            gustMph = 9.9,
            heatIndexC = 21.0,
            heatIndexF = 69.8,
            humidity = 55,
            isDay = 1,
            precipIn = 0.0,
            precipMm = 0.0,
            pressureIn = 29.9,
            pressureMb = 1013.0,
            snowCm = 0.0,
            tempC = 21.0,
            tempF = 69.8,
            time = "2024-01-15 18:00",
            timeEpoch = 1705341600,
            uv = 4.0,
            visKm = 10.0,
            visMiles = 6.2,
            willItRain = 0,
            willItSnow = 0,
            windDegree = 200,
            windDir = "SSW",
            windKph = 14.0,
            windMph = 8.7,
            windChillC = 21.0,
            windChillF = 69.8
        ),
        Hour(
            chanceOfRain = 0,
            chanceOfSnow = 0,
            cloud = 25,
            condition = Condition(
                code = 1003,
                icon = "//cdn.weatherapi.com/weather/64x64/night/116.png",
                text = "Partly cloudy"
            ),
            dewPointC = 14.0,
            dewPointF = 57.2,
            feelsLikeC = 19.0,
            feelsLikeF = 66.2,
            gustKph = 14.0,
            gustMph = 8.7,
            heatIndexC = 19.0,
            heatIndexF = 66.2,
            humidity = 60,
            isDay = 0,
            precipIn = 0.0,
            precipMm = 0.0,
            pressureIn = 30.0,
            pressureMb = 1016.0,
            snowCm = 0.0,
            tempC = 19.0,
            tempF = 66.2,
            time = "2024-01-15 21:00",
            timeEpoch = 1705352400,
            uv = 0.0,
            visKm = 10.0,
            visMiles = 6.2,
            willItRain = 0,
            willItSnow = 0,
            windDegree = 180,
            windDir = "S",
            windKph = 12.0,
            windMph = 7.5,
            windChillC = 19.0,
            windChillF = 66.2
        )
    )

    Forecast24Hour(
        hours = sampleHours,
        isTempC = true,
        isWindKmh = true,
        backdrop = rememberLayerBackdrop(),
        isLiquidGlassOn = false
    )
}


//
//@Composable
//fun ForecastRowItem(
//    temp: String,
//    icon: Any,
//    wind: String,
//    time: String,
//    previousTemp: Float,
//    maxTemp: Float,
//    minTemp: Float,
//    isWindKmh: Boolean
//) {
//    val tempRange = maxTemp - minTemp
//    var boxHeight by remember {
//        mutableFloatStateOf(0f)
//    }
//
//    Column(
//        verticalArrangement = Arrangement.spacedBy(3.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Box(
//            modifier = Modifier
//                .height(40.dp)
//                .width(85.dp)
//                .onGloballyPositioned { coordinates ->
//                    boxHeight = coordinates.size.height.toFloat()
//                }
//                .drawBehind {
//                    val normalizedPrevY =
//                        size.height - ((previousTemp - minTemp) / tempRange) * size.height
//                    val normalizedCurrentY =
//                        size.height - ((temp.toFloat() - minTemp) / tempRange) * size.height
//                    drawLine(
//                        color = Color.Green,
//                        start = Offset(0f, normalizedPrevY),
//                        end = Offset(size.width, normalizedCurrentY),
//                        strokeWidth = 4.dp.toPx()
//                    )
//                },
//            contentAlignment = Alignment.Center
//        ) {
//            if (boxHeight > 0f) {
//                Text(
//                    modifier = Modifier
//                        .offset(y = with(LocalDensity.current) {
//                            (boxHeight - ((temp.toFloat() - minTemp) / tempRange) * boxHeight - 110).toDp()
//                        }),
//                    text = "$temp°",
//                    color = Color.White
//                )
//            }
//        }
//        AsyncImage(model = icon, contentDescription = null, modifier = Modifier.size(40.dp))
//        Text(text = if (isWindKmh) "$wind km/h" else "$wind mp/h", color = Color.White)
//        Text(text = time, color = Color.White)
//    }
//}