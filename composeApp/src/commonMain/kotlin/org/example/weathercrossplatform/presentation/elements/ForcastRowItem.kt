package org.example.weathercrossplatform.presentation.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun ForecastRowItem(
    temp: String,
    icon: Any,
    wind: String,
    time: String,
    previousTemp: Float,
    maxTemp: Float,
    minTemp: Float,
    isWindKmh: Boolean
) {
    val tempRange = maxTemp - minTemp

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$temp°",
            color = Color.White
        )
        Box(
            modifier = Modifier
                .height(40.dp)
                .width(85.dp)
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
                })
        AsyncImage(model = icon, contentDescription = null, modifier = Modifier.size(40.dp))
        Text(text = if (isWindKmh) "$wind km/h" else "$wind mp/h", color = Color.White)
        Text(text = time, color = Color.White)
    }
}

@Preview
@Composable
fun ForecastRowItemPreview() {
    ForecastRowItem(
        temp = "20",
        icon = "https://cdn.weatherapi.com/weather/64x64/day/113.png",
        wind = "12",
        time = "12:00",
        previousTemp = 18.0f,
        maxTemp = 25.0f,
        minTemp = 10.0f,
        isWindKmh = true
    )
}