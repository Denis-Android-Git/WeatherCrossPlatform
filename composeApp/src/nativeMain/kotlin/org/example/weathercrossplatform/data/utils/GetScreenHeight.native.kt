package org.example.weathercrossplatform.data.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import platform.UIKit.UIScreen

actual object GetScreenHeight {
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    actual fun getScreenHeight(): Dp = LocalWindowInfo.current.containerSize.height.pxToPoint().dp
    @Composable
    actual fun getBottomBarHeight(): Dp {
        return 100.dp
    }

    private fun Int.pxToPoint(): Double = this.toDouble() / UIScreen.mainScreen.scale
}