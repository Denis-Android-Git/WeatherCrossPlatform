package org.example.weathercrossplatform.presentation.icons

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.feels_like_arrow

@Composable
fun FeelsLikeIcon(
    modifier: Modifier = Modifier,
    rotationAngle: Float
) {
    Box(
        modifier = modifier
            .padding(16.dp)
            .size(60.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val strokeWidth = 4.dp.toPx()
            val arcRadius = size.minDimension / 2 - strokeWidth
            val arcSize = Size(arcRadius * 2, arcRadius * 2)
            val topLeft = Offset(center.x - arcRadius, center.y - arcRadius)

            val startAngle = 135f
            val totalSweep = 270f
            drawArc(
                brush = Brush.sweepGradient(
                    0.15f to Color.Red,
                    0.2f to Color.Blue,
                    0.63f to Color.Blue,
                    0.64f to Color.Green,
                    0.86f to Color.Green,
                    0.87f to Color.Red,
                    1f to Color.Red
                ),
                startAngle = startAngle,
                sweepAngle = totalSweep,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                topLeft = topLeft,
                size = arcSize
            )
        }
        Icon(
            painter = painterResource(Res.drawable.feels_like_arrow),
            tint = Color.White,
            contentDescription = null,
            modifier = Modifier.size(40.dp).rotate(rotationAngle)
        )
    }
}