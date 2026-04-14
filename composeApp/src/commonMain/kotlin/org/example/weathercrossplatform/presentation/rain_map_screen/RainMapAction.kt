package org.example.weathercrossplatform.presentation.rain_map_screen

sealed interface RainMapAction {
    data class OnSliderChanged(val value: Float) : RainMapAction
}
