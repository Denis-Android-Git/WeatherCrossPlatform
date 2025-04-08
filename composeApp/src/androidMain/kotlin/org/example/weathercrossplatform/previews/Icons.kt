package org.example.weathercrossplatform.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.weathercrossplatform.presentation.PressureIndicator


@Preview
@Composable
private fun Preview() {
    PressureIndicator(
        progress = 1.5f,
    )
}