package org.example.weathercrossplatform.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.weathercrossplatform.presentation.WindIcon


@Preview
@Composable
private fun Preview() {
    WindIcon(
        progress = 0.3f,
        rotation = 328f
    )
}