package org.example.weathercrossplatform.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.water_drop

@Composable
fun HumidityIcon(
    modifier: Modifier = Modifier,
    progress: Float
) {
    Box(
        modifier = modifier
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            progress = { progress },
            color = Color(0xff0b63da)
        )
        Icon(
            painterResource(Res.drawable.water_drop), contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = Color(0xff0b63da)
        )
    }
}