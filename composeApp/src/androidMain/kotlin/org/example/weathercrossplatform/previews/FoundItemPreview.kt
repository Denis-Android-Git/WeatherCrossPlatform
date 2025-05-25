package org.example.weathercrossplatform.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.example.weathercrossplatform.presentation.FoundItem

@Preview
@Composable
private fun Preview() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        FoundItem(
            city = "Moscow",
            country = "Russia",
            onClick = {}
        )
    }
}