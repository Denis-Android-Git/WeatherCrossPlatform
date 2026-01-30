package org.example.weathercrossplatform.presentation.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.example.weathercrossplatform.presentation.utils.DeviceConfiguration
import org.example.weathercrossplatform.presentation.utils.currentDeviceConfiguration

@Composable
fun MyAdaptiveLayout(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.(paddingTop: Dp) -> Unit
) {
    val configuration = currentDeviceConfiguration()
    var topPadding: Dp
    when (configuration) {
        DeviceConfiguration.MOBILE_PORTRAIT -> {
            topPadding = 160.dp
            Box(modifier = modifier.fillMaxSize()) {
                content(topPadding)
            }
        }

        DeviceConfiguration.MOBILE_LANDSCAPE -> {
            topPadding = 16.dp
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.TopCenter
            ) {
                    content(topPadding)
            }
        }

        DeviceConfiguration.TABLET_PORTRAIT,
        DeviceConfiguration.TABLET_LANDSCAPE,
        DeviceConfiguration.DESKTOP -> {
            topPadding = 16.dp
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.TopCenter
            ) {
                content(topPadding)
            }
        }
    }
}
