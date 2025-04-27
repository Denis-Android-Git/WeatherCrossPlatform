package org.example.weathercrossplatform.presentation.icons

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin


@Composable
fun UvIcon(
    modifier: Modifier = Modifier,
    uvIndex: String
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

            val uvValue = uvIndex.toIntOrNull() ?: 0
            val maxUv = 11f

            val progress = (uvValue / maxUv).coerceIn(0f, 1f)

            drawArc(
                brush = Brush.sweepGradient(
                    0.2f to Color(0xFF8F00FF),
                    0.4f to Color.Green,
                    0.65f to Color.Yellow,
                    0.83f to Color.Red,
                    1f to Color(0xFF8F00FF)
                ),
                startAngle = startAngle,
                sweepAngle = totalSweep,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                topLeft = topLeft,
                size = arcSize
            )
            val sweepAngle = startAngle + totalSweep * progress
            val radians = sweepAngle * (PI / 180)

            val ballRadius = 6.dp.toPx()

            val ballCenter = Offset(
                x = center.x + arcRadius * cos(radians).toFloat(),
                y = center.y + arcRadius * sin(radians).toFloat()
            )

            drawCircle(
                color = when (uvIndex) {
                    "0" -> Color.Green
                    "1" -> Color.Green
                    "2" -> Color.Green
                    "3" -> Color.Yellow
                    "4" -> Color.Yellow
                    "5" -> Color.Yellow
                    "6" -> Color.Red
                    "7" -> Color.Red
                    "8" -> Color.Red
                    "9" -> Color(0xFF8F00FF)
                    "10" -> Color(0xFF8F00FF)
                    else -> Color(0xFF8F00FF)
                },
                radius = ballRadius,
                center = ballCenter
            )
        }
        Text(
            text = uvIndex,
            fontSize = 27.sp,
            color = Color.White
        )
    }
}