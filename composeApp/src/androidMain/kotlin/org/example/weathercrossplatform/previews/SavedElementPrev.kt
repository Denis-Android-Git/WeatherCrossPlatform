package org.example.weathercrossplatform.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.weathercrossplatform.presentation.SavedElement

@Preview
@Composable
private fun Preview() {
    SavedElement(
        cityName = "New York",
        temperature = "72",
        weatherDescription = "Sunny",
        high = "75",
        low = "68",
        index = 0,
        onLongClick = { },
        onClick = {},
        isLongPressed = true,
        isListContainsElement = true
    )
}