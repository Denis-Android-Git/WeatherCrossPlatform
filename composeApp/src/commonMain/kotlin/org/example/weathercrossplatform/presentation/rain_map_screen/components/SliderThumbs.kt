package org.example.weathercrossplatform.presentation.rain_map_screen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RoundThumb(
    value: String,
) {
    Box(
        modifier = Modifier
            .size(44.dp)
            .background(
                color = Color(0xFF2D6CDF),
                shape = CircleShape
            )
            .border(2.dp, Color.White, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = value,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SquareThumb(
    value: String
) {
    Box(
        modifier = Modifier
            .shadow(8.dp, RoundedCornerShape(12.dp))
            .background(
                color = Color(0xFF1E1E1E),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 10.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = value,
            color = Color.White,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun WeatherSliderThumb(
    value: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.offset(y = (-25).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .shadow(10.dp, RoundedCornerShape(14.dp))
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(Color(0xFF334155), Color(0xFF0F172A))
                        ),
                        shape = RoundedCornerShape(14.dp)
                    )
                    .padding(horizontal = 5.dp, vertical = 2.dp)
            ) {
                Text(
                    text = value,
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Canvas(
                modifier = Modifier.size(width = 12.dp, height = 6.dp)
            ) {
                val path = Path().apply {
                    moveTo(0f, 0f)
                    lineTo(size.width / 2f, size.height)
                    lineTo(size.width, 0f)
                    close()
                }
                drawPath(path, color = Color(0xFF1F2937))
            }
        }

        Box(
            modifier = Modifier
                .size(18.dp)
                .background(Color.White, CircleShape)
                .border(3.dp, Color(0xFF3B82F6), CircleShape)
        )
    }
}


@Preview
@Composable
fun SliderThumbsPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        RoundThumb(value = "12")
        Spacer(modifier = Modifier.height(16.dp))
        SquareThumb(value = "12")
        Spacer(modifier = Modifier.height(16.dp))
        WeatherSliderThumb(value = "12")
    }
}




