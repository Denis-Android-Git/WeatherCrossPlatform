package org.example.weathercrossplatform.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.example.weathercrossplatform.domain.models.Hour

@Composable
fun HourForecastElement(
    hours: List<Hour>
) {
    val maxTemp by remember { mutableFloatStateOf(hours.maxOf { it.tempC.toFloat() }) }
    val minTemp by remember { mutableFloatStateOf(hours.minOf { it.tempC.toFloat() }) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp)
            .background(color = Color.Black.copy(alpha = 0.3f), shape = RoundedCornerShape(16.dp)),
    ) {
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 26.dp),
            text = "Прогноз на 24ч", color = Color.LightGray
        )

        LazyRow(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            itemsIndexed(hours) { index, item ->
                val icon = item.condition.icon.replace("//", "https://")
                val time = item.time.substringAfter(" ")
                val prevTemp =
                    if (index > 0) hours[index - 1].tempC.toFloat() else item.tempC.toFloat()
                ForecastRowItem(
                    temp = item.tempC.toString(),
                    icon = icon,
                    wind = item.windKph.toString(),
                    time = time,
                    previousTemp = prevTemp,
                    maxTemp = maxTemp,
                    minTemp = minTemp
                )
            }
        }
    }
}

@Composable
fun ForecastRowItem(
    temp: String,
    icon: String,
    wind: String,
    time: String,
    previousTemp: Float,
    maxTemp: Float,
    minTemp: Float
) {
    val tempRange = maxTemp - minTemp
    var boxHeight by remember {
        mutableFloatStateOf(0f)
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .height(40.dp)
                .width(85.dp)
                .onGloballyPositioned { coordinates ->
                    boxHeight = coordinates.size.height.toFloat()
                }
                .drawBehind {
                    val normalizedPrevY =
                        size.height - ((previousTemp - minTemp) / tempRange) * size.height
                    val normalizedCurrentY =
                        size.height - ((temp.toFloat() - minTemp) / tempRange) * size.height
                    drawLine(
                        color = Color.Green,
                        start = Offset(0f, normalizedPrevY),
                        end = Offset(size.width, normalizedCurrentY),
                        strokeWidth = 4.dp.toPx()
                    )
                },
            contentAlignment = Alignment.Center
        ) {
            if (boxHeight > 0f) {
                Text(
                    modifier = Modifier
                        .offset(y = with(LocalDensity.current) {
                            (boxHeight - ((temp.toFloat() - minTemp) / tempRange) * boxHeight - 110).toDp()
                        }),
                    text = "$temp°",
                    color = Color.LightGray
                )
            }
        }
        AsyncImage(model = icon, contentDescription = null)
        Text(text = "$wind km/h", color = Color.LightGray)
        Text(text = time, color = Color.LightGray)
    }
}