package org.example.weathercrossplatform.presentation.elements

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
import androidx.compose.foundation.lazy.itemsIndexed
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
import org.jetbrains.compose.resources.stringResource
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources._3_day_forecast
import weathercrossplatform.composeapp.generated.resources.today
import weathercrossplatform.composeapp.generated.resources.tomorrow

@Composable
fun ForecastElement(
    forecastList: List<Forecastday>,
    isTempC: Boolean
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
            Text(text = stringResource(Res.string._3_day_forecast), color = Color.LightGray)
        }
        LazyColumn(
            modifier = Modifier.padding(horizontal = 16.dp),
            contentPadding = PaddingValues(2.dp)
        ) {
            itemsIndexed(forecastList) { index, it ->
                ForecastItem(
                    date = when (index) {
                        0 -> stringResource(Res.string.today)
                        1 -> stringResource(Res.string.tomorrow)
                        else -> it.date
                    },
                    low = if (isTempC) it.day.minTempC.toString() else it.day.minTempF.toString(),
                    high = if (isTempC) it.day.maxTempC.toString() else it.day.maxTempF.toString(),
                    image = it.day.condition.icon,
                    isTempC = isTempC
                )
            }
        }
    }
}