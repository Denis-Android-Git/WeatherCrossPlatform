package org.example.weathercrossplatform.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.wind_arrow

@Composable
fun WindIcon(
    modifier: Modifier = Modifier,
    progress: Float,
    rotation: Float
) {
    Box(
        modifier = modifier
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            progress = { progress },
            color = Color(0xff39577e)
        )
        Icon(
            painter = painterResource(Res.drawable.wind_arrow),
            contentDescription = "Wind Icon",
            tint = Color(0xff39577e),
            modifier = Modifier
                .size(43.dp)
                .rotate((180 +  rotation))
        )
        Box(
            modifier = Modifier.matchParentSize().padding(6.dp)
        ) {
            Text(
                text = "W",
                modifier = Modifier.align(Alignment.CenterStart),
                color = Color.White,
                fontSize = 4.sp
            )
            Text(
                text = "N",
                modifier = Modifier.align(Alignment.TopCenter),
                color = Color.White,
                fontSize = 4.sp
            )
            Text(
                text = "E",
                modifier = Modifier.align(Alignment.CenterEnd),
                color = Color.White,
                fontSize = 4.sp
            )
            Text(
                text = "S",
                modifier = Modifier.align(Alignment.BottomCenter),
                color = Color.White,
                fontSize = 4.sp
            )
            Box(
                modifier = Modifier
                    .background(color = Color(0xff39577e), shape = RoundedCornerShape(50.dp))
                    .size(13.dp)
                    .align(Alignment.Center),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "km/h", color = Color.White,
                    fontSize = 4.sp
                )
            }
        }
    }
}