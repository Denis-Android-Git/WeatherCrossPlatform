package org.example.weathercrossplatform.presentation.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.example.weathercrossplatform.presentation.utils.DeviceConfiguration
import org.example.weathercrossplatform.presentation.utils.currentDeviceConfiguration

@Composable
fun MyAdaptiveLayout(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    val configuration = currentDeviceConfiguration()

    when (configuration) {
        DeviceConfiguration.MOBILE_PORTRAIT -> {
            Box(modifier = modifier.fillMaxSize()) {
                content()
            }
        }

        DeviceConfiguration.MOBILE_LANDSCAPE -> {

        }
        DeviceConfiguration.TABLET_PORTRAIT -> TODO()
        DeviceConfiguration.TABLET_LANDSCAPE -> TODO()
        DeviceConfiguration.DESKTOP -> TODO()
    }
}
