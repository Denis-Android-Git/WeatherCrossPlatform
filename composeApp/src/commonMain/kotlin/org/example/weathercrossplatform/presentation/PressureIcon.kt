package org.example.weathercrossplatform.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.arrow_downward

@Composable
fun PressureIndicator(progress: Float, maxValue: Float = 2f) {
    Box(
        modifier = Modifier
            .size(50.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val strokeWidth = 3.dp.toPx()
            val arcRadius = size.minDimension / 2 - strokeWidth
            val arcSize = Size(arcRadius * 2, arcRadius * 2)
            val topLeft = Offset(center.x - arcRadius, center.y - arcRadius)

            val startAngle = 135f
            val totalSweep = 270f
            val clampedProgress = (progress / maxValue).coerceIn(0f, 1f)
            val progressSweep = totalSweep * clampedProgress

            drawArc(
                color = Color(0xFF444A60),
                startAngle = startAngle,
                sweepAngle = totalSweep,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                topLeft = topLeft,
                size = arcSize
            )

            drawArc(
                color = Color.Cyan,
                startAngle = startAngle,
                sweepAngle = progressSweep,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                topLeft = topLeft,
                size = arcSize
            )
        }
        Icon(
            painter = painterResource(Res.drawable.arrow_downward),
            contentDescription = "Wind Icon",
            tint = Color(0xff47e6d0),
            modifier = Modifier.size(30.dp)
        )
        Text(
            text = "mmHg",
            fontSize = 7.sp,
            color = Color.LightGray,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 4.dp)
        )
    }
}