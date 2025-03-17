package org.example.weathercrossplatform.data.utils

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

actual object GetScreenHeight {
    @Composable
    actual fun getScreenHeight(): Dp = LocalConfiguration.current.screenHeightDp.dp

    @Composable
    actual fun getBottomBarHeight(): Dp {
        val density = LocalDensity.current
        return with(density) {
            WindowInsets.systemBars.getBottom(this)
                .toDp()
        }
    }

}