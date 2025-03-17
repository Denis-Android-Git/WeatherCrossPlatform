package org.example.weathercrossplatform.data.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

expect object GetScreenHeight {

    @Composable
    fun getScreenHeight(): Dp

    @Composable
    fun getBottomBarHeight(): Dp
}