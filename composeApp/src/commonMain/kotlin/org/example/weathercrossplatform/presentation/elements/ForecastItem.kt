package org.example.weathercrossplatform.presentation.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.painterResource
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.clouds

@Composable
fun ForecastItem(
    date: String,
    low: String,
    high: String,
    image: String,
    isTempC: Boolean
) {
    val icon = image.replace("//", "https://")

    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = date,
                modifier = Modifier.weight(0.4f),
                color = Color.White
            )
            AsyncImage(
                model = icon,
                modifier = Modifier.size(34.dp).weight(0.2f),
                error = painterResource(Res.drawable.clouds),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(9.dp))
            Text(
                text = when {
                    isTempC -> "$low ℃"
                    else -> "$low ℉"
                },
                modifier = Modifier.weight(0.2f),
                color = Color.White
            )
            //Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = when {
                    isTempC -> "$high ℃"
                    else -> "$high ℉"
                },
                modifier = Modifier.weight(0.2f),
                textAlign = TextAlign.End,
                color = Color.White
            )

        }
        HorizontalDivider(
            modifier = Modifier.padding(top = 2.dp),
            color = Color.LightGray,
            thickness = 1.dp
        )
    }
}

@Preview
@Composable
fun ForecastItemPreview() {
    ForecastItem(
        date = "Today",
        low = "15",
        high = "22",
        image = "//cdn.weatherapi.com/weather/64x64/day/113.png",
        isTempC = true
    )
}