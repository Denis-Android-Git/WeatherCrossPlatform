package org.example.weathercrossplatform.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FoundItem(
    city: String,
    country: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .height(60.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 14.dp
        ),
        border = BorderStroke(1.dp, Color.DarkGray)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(start = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = city, color = Color.White, fontSize = 20.sp)
            Text(text = country, color = Color.Gray, fontSize = 15.sp)
        }
    }
}