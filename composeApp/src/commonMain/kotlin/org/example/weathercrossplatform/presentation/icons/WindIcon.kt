package org.example.weathercrossplatform.presentation.icons

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
            modifier = Modifier.size(60.dp),
            progress = { progress },
            color = Color.Red
        )
        Icon(
            modifier = Modifier
                .size(60.dp)
                .rotate((180 + rotation)),
            painter = painterResource(Res.drawable.wind_arrow),
            contentDescription = "Wind Icon",
            tint = Color.Red
        )
        Box(
            modifier = Modifier.size(60.dp)
        ) {
            Text(
                text = "W",
                modifier = Modifier.align(Alignment.CenterStart).padding(start = 6.dp),
                color = Color.White,
                fontSize = 6.sp
            )
            Text(
                text = "N",
                modifier = Modifier.align(Alignment.TopCenter),
                color = Color.White,
                fontSize = 6.sp
            )
            Text(
                text = "E",
                modifier = Modifier.align(Alignment.CenterEnd).padding(end = 6.dp),
                color = Color.White,
                fontSize = 6.sp
            )
            Text(
                text = "S",
                modifier = Modifier.align(Alignment.BottomCenter),
                color = Color.White,
                fontSize = 6.sp
            )
            Box(
                modifier = Modifier
                    .background(color = Color.Red, shape = RoundedCornerShape(50.dp))
                    .size(10.dp)
                    .align(Alignment.Center),
                contentAlignment = Alignment.Center
            ) {}
        }
    }
}