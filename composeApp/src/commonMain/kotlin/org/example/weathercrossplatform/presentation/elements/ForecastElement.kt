package org.example.weathercrossplatform.presentation.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kashif_e.backdrop.backdrops.LayerBackdrop
import com.kashif_e.backdrop.backdrops.rememberLayerBackdrop
import org.example.weathercrossplatform.domain.models.Astro
import org.example.weathercrossplatform.domain.models.Condition
import org.example.weathercrossplatform.domain.models.Day
import org.example.weathercrossplatform.domain.models.Forecastday
import org.example.weathercrossplatform.presentation.modifier.myLiquidGlass2
import org.jetbrains.compose.resources.stringResource
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources._3_day_forecast
import weathercrossplatform.composeapp.generated.resources.today
import weathercrossplatform.composeapp.generated.resources.tomorrow

@Composable
fun ThreeDaysForecast(
    forecastList: List<Forecastday>,
    isTempC: Boolean,
    backdrop: LayerBackdrop,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .myLiquidGlass2(backdrop)
            .padding(horizontal = 6.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(start = 26.dp),
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
        forecastList.forEachIndexed { index, it ->
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

@Preview
@Composable
fun ForecastElementPreview() {
    val sampleForecastList = listOf(
        Forecastday(
            astro = Astro(
                isMoonUp = 1,
                isSunUp = 1,
                moonIllumination = 45,
                moonPhase = "Waning Crescent",
                moonrise = "02:30 AM",
                moonset = "01:15 PM",
                sunrise = "06:45 AM",
                sunset = "07:30 PM"
            ),
            date = "2024-01-15",
            dateEpoch = 1705276800,
            day = Day(
                avghumidity = 65,
                avgTempC = 18.5,
                avgTempF = 65.3,
                avgVisKm = 10.0,
                avgVisMiles = 6.2,
                condition = Condition(
                    code = 1000,
                    icon = "//cdn.weatherapi.com/weather/64x64/day/113.png",
                    text = "Sunny"
                ),
                dailyChanceOfRain = 0,
                dailyChanceOfSnow = 0,
                dailyWillItRain = 0,
                dailyWillItSnow = 0,
                maxTempC = -22.0,
                maxTempF = 71.6,
                maxWindKph = 15.0,
                maxWindMph = 9.3,
                minTempC = -15.0,
                minTempF = 59.0,
                totalPrecipIn = 0.0,
                totalPrecipMm = 0.0,
                totalSnowCm = 0.0,
                uv = 5.0
            ),
            hour = emptyList()
        ),
        Forecastday(
            astro = Astro(
                isMoonUp = 1,
                isSunUp = 1,
                moonIllumination = 50,
                moonPhase = "Waning Crescent",
                moonrise = "03:15 AM",
                moonset = "02:00 PM",
                sunrise = "06:44 AM",
                sunset = "07:31 PM"
            ),
            date = "2024-01-16",
            dateEpoch = 1705363200,
            day = Day(
                avghumidity = 70,
                avgTempC = 16.0,
                avgTempF = 60.8,
                avgVisKm = 8.0,
                avgVisMiles = 5.0,
                condition = Condition(
                    code = 1063,
                    icon = "//cdn.weatherapi.com/weather/64x64/day/176.png",
                    text = "Patchy rain possible"
                ),
                dailyChanceOfRain = 60,
                dailyChanceOfSnow = 0,
                dailyWillItRain = 1,
                dailyWillItSnow = 0,
                maxTempC = 19.0,
                maxTempF = 66.2,
                maxWindKph = 20.0,
                maxWindMph = 12.4,
                minTempC = 13.0,
                minTempF = 55.4,
                totalPrecipIn = 0.15,
                totalPrecipMm = 3.8,
                totalSnowCm = 0.0,
                uv = 4.0
            ),
            hour = emptyList()
        ),
        Forecastday(
            astro = Astro(
                isMoonUp = 0,
                isSunUp = 1,
                moonIllumination = 55,
                moonPhase = "New Moon",
                moonrise = "04:00 AM",
                moonset = "02:45 PM",
                sunrise = "06:43 AM",
                sunset = "07:32 PM"
            ),
            date = "2024-01-17",
            dateEpoch = 1705449600,
            day = Day(
                avghumidity = 75,
                avgTempC = 14.5,
                avgTempF = 58.1,
                avgVisKm = 6.0,
                avgVisMiles = 3.7,
                condition = Condition(
                    code = 1003,
                    icon = "//cdn.weatherapi.com/weather/64x64/day/116.png",
                    text = "Partly cloudy"
                ),
                dailyChanceOfRain = 30,
                dailyChanceOfSnow = 0,
                dailyWillItRain = 0,
                dailyWillItSnow = 0,
                maxTempC = 17.0,
                maxTempF = 62.6,
                maxWindKph = 18.0,
                maxWindMph = 11.2,
                minTempC = 12.0,
                minTempF = 53.6,
                totalPrecipIn = 0.05,
                totalPrecipMm = 1.3,
                totalSnowCm = 0.0,
                uv = 3.5
            ),
            hour = emptyList()
        )
    )

    ThreeDaysForecast(
        forecastList = sampleForecastList,
        isTempC = true,
        backdrop = rememberLayerBackdrop()
    )
}