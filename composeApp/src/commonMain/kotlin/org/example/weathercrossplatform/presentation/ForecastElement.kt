package org.example.weathercrossplatform.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.weathercrossplatform.domain.models.Forecastday

@Composable
fun ForecastElement(
    forecastList: List<Forecastday>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp)
            .height(150.dp)
            .background(color = Color.Black.copy(alpha = 0.3f), shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier.size(15.dp)
            )
            Text(text = "Прогноз на 3 дня", color = Color.LightGray)
        }
        LazyColumn(
            modifier = Modifier.padding(horizontal = 16.dp),
            contentPadding = PaddingValues(2.dp)
        ) {
            items(forecastList) {
                ForecastItem(
                    date = it.date,
                    low = it.day.minTempC.toString(),
                    high = it.day.maxTempC.toString(),
                    image = it.day.condition.icon
                )
            }
        }
    }
}