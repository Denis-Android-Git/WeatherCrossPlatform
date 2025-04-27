package org.example.weathercrossplatform.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun ForecastItem(
    date: String,
    low: String,
    high: String,
    image: String
) {
    val icon = image.replace("//", "https://")

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = date, color = Color.White)
            AsyncImage(
                model = icon, contentDescription = null,
                modifier = Modifier.padding(start = 130.dp)
            )
            Text(
                text = "$low ℃", color = Color.White,
                modifier = Modifier.padding(start = 200.dp)
            )
            Text(
                text = "$high ℃", color = Color.White,
                modifier = Modifier.align(Alignment.CenterEnd)
            )

        }
        HorizontalDivider(
            modifier = Modifier.padding(top = 2.dp),
            color = Color.LightGray,
            thickness = 1.dp
        )
    }
}