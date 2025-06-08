package org.example.weathercrossplatform.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SavedElement(
    cityName: String,
    temperature: String,
    weatherDescription: String,
    high: String,
    low: String,
    index: Int,
    onLongClick: () -> Unit,
    onClick: () -> Unit,
    isLongPressed: Boolean,
    isListContainsElement: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xff335e95).copy(alpha = 0.9f),
                        Color(0xff335e95).copy(alpha = 0.2f)
                    )
                ), shape = RoundedCornerShape(16.dp)
            )
            .combinedClickable(
                onClick = onClick,
                onLongClick = onLongClick
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = cityName, color = Color.White, fontSize = 20.sp)
                    if (index == 0) {
                        Icon(
                            imageVector = Icons.Outlined.Place,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .size(15.dp),
                            tint = Color.White
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(text = weatherDescription, color = Color.White)
            }
            Spacer(modifier = Modifier.weight(1f))
            Column {
                Text(text = "$temperature°C", color = Color.White, fontSize = 20.sp)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "$high / $low", color = Color.White)
            }
            if (isLongPressed) {
                if (isListContainsElement) {
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .background(Color.Blue, shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Done,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .border(1.dp, Color.White, CircleShape)
                    )
                }
            }
        }
    }
}