package org.example.weathercrossplatform.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun MainScreen(
    isLoading: Boolean,
    image: String,
    usEpaIndex: Int,
    locationName: String,
    temp: String,
    condition: String,
    feelsLikeC: String,
    error: String
) {
    val scrollState = rememberScrollState()

    val textColor by remember { mutableStateOf(Color.White) }

    Box(
        modifier = Modifier.fillMaxSize()
            .background(
                brush = Brush
                    .linearGradient(
                        colors = listOf(
                            Color.Blue.copy(alpha = 0.9f),
                            Color.Blue.copy(alpha = 0f)
                        )
                    )
            )
    ) {
        AnimatedVisibility(
            visible = isLoading,
            modifier = Modifier.align(Alignment.Center)
        ) {
            CircularProgressIndicator()
        }
        AnimatedVisibility(
            visible = !isLoading
        ) {

            val airQualityText =
                when (usEpaIndex) {
                    1 -> "Хорошо"
                    2 -> "Умеренно"
                    3 -> "Плохое для чувствительных групп"
                    4 -> "Плохое"
                    5 -> "Очень Плохое"
                    6 -> "Опасно"
                    else -> ""
                }

            println("airQualityText = $usEpaIndex")

            Box(modifier = Modifier.fillMaxSize()) {
                AsyncImage(
                    model = image,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillHeight,
                    contentDescription = null
                )
                Column(
                    modifier = Modifier.fillMaxSize()
                        .scrollable(
                            scrollState,
                            orientation = Orientation.Vertical
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 160.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Place,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 52.dp, bottom = 3.dp)
                                .size(15.dp),
                            tint = Color.White
                        )
                        Box(
                            modifier = Modifier
                                .padding(start = 36.dp)
                                .background(
                                    color = Color.Black.copy(alpha = 0.2f),
                                    shape = RoundedCornerShape(16.dp)
                                )
                        ) {
                            Text(
                                modifier = Modifier.padding(
                                    vertical = 2.dp,
                                    horizontal = 16.dp
                                ),
                                text = locationName, color = textColor, fontSize = 20.sp
                            )
                        }
                        Box(
                            modifier = Modifier
                                .padding(start = 36.dp, top = 16.dp)
                                .background(
                                    color = Color.Black.copy(alpha = 0.2f),
                                    shape = RoundedCornerShape(16.dp)
                                )
                        ) {
                            Text(
                                modifier = Modifier.padding(
                                    vertical = 2.dp,
                                    horizontal = 16.dp
                                ),
                                text = "$temp ℃",
                                color = textColor,
                                fontSize = 85.sp
                            )
                        }
                        Column(
                            modifier = Modifier
                                .padding(start = 36.dp, top = 16.dp)
                                .background(
                                    color = Color.Black.copy(alpha = 0.2f),
                                    shape = RoundedCornerShape(16.dp)
                                )
                        ) {
                            Text(
                                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 2.dp),
                                text = "Ощущается $feelsLikeC ℃", color = textColor
                            )
                            Text(
                                modifier = Modifier.padding(start = 16.dp, bottom = 2.dp),
                                text = condition, color = textColor
                            )
                        }
                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 16.dp)
                                .background(
                                    color = Color.White.copy(alpha = 0.2f),
                                    shape = RoundedCornerShape(16.dp)
                                )
                        ) {
                            Row(
                                modifier = Modifier.padding(
                                    vertical = 6.dp,
                                    horizontal = 16.dp
                                )
                            ) {
                                Text(
                                    text = "Качество воздуха: ", color = textColor
                                )
                                Text(
                                    text = airQualityText, color = when (airQualityText) {
                                        "Хорошо" -> Color.Green
                                        "Умеренно" -> Color(0xff47e6d0)
                                        "Плохое для чувствительных групп" -> Color.Yellow
                                        "Плохое" -> Color(0xFF996600)
                                        "Очень Плохое" -> Color(0xFFCC3300)
                                        "Опасно" -> Color(0xFFFF0000)
                                        else -> Color.Green
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
        AnimatedVisibility(
            visible = error.isNotEmpty(),
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = error)
        }
    }
}