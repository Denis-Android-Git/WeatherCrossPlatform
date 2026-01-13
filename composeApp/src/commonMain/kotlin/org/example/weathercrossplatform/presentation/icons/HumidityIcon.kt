package org.example.weathercrossplatform.presentation.icons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.weathercrossplatform.presentation.image_vectors.WaterDrop
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HumidityIcon(
    modifier: Modifier = Modifier,
    progress: Float
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(60.dp),
            progress = { progress },
            color = Color(0xff0b63da)
        )
        Icon(
            imageVector = WaterDrop, contentDescription = null,
            modifier = Modifier.size(40.dp),
            tint = Color(0xff0b63da)
        )
    }
}

@Preview
@Composable
fun HumidityIconPreview() {
    HumidityIcon(
        progress = 0.5f
    )
}