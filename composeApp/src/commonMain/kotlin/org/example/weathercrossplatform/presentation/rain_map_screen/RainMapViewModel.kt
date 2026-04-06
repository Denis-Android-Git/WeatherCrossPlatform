package org.example.weathercrossplatform.presentation.rain_map_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RainMapViewModel : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(RainMapState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                /** Load initial data here **/
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = RainMapState()
        )

    init {
        viewModelScope.launch {
            while (true) {
                for (i in 0..23) {
                    val hour = i.toString().padStart(2, '0')
                    println("testing = $hour")
                    reloadMap(hour)
                    delay(1500)
                }
            }
        }
    }

    fun onAction(action: RainMapAction) {
        when (action) {
            is RainMapAction.OnDateChanged -> {
                _state.value = _state.value.copy(date = action.value)
            }

            is RainMapAction.OnHourChanged -> {
                val normalizedHour = action.value.filter { it.isDigit() }.take(2)
                _state.value = _state.value.copy(hour = normalizedHour)
            }

            is RainMapAction.OnZoomChanged -> {
                _state.value = _state.value.copy(
                    zoom = (_state.value.zoom + action.delta).coerceIn(3, 8)
                )
                //reloadMap()
            }

            RainMapAction.OnReloadClick -> {
                //reloadMap()
            }
        }
    }

    private fun reloadMap(hour: String) {
        val current = _state.value
//        val normalizedHour =
//            current.hour.toIntOrNull()?.coerceIn(0, 23)?.toString()?.padStart(2, '0')
//                ?: currentUtcHour()
        val normalizedDate = current.date.takeIf { it.matches(Regex("\\d{8}")) } ?: currentUtcDate()
        _state.value = current.copy(
            date = normalizedDate,
            hour = hour,//normalizedHour,
            currentTileUrl = buildTileTemplate(
                date = normalizedDate,
                hour = hour,//normalizedHour
            ),
            mapHtml = buildRainMapHtml(
                latitude = current.latitude,
                longitude = current.longitude,
                zoom = current.zoom,
                date = normalizedDate,
                hour = hour//normalizedHour
            )
        )
    }
}
