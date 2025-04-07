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


@Composable
fun WeatherDetailElement(
    title: String,
    description: String,
    humidityProgress: Float,
    windProgress: Float,
    rotation: Float
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
                    progress = humidityProgress
                )
            }

            "Wind" -> {
                WindIcon(
                    modifier = Modifier.align(Alignment.End),
                    progress = windProgress,
                    rotation = rotation
                )
            }
        }
    }
}