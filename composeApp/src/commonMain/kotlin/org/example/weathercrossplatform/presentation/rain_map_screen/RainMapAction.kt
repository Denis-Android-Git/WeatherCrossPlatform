package org.example.weathercrossplatform.presentation.rain_map_screen

sealed interface RainMapAction {
    data class OnDateChanged(val value: String) : RainMapAction
    data class OnHourChanged(val value: String) : RainMapAction
    data class OnZoomChanged(val delta: Int) : RainMapAction
    data object OnReloadClick : RainMapAction
}
