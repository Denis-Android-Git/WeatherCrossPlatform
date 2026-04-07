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
import org.example.weathercrossplatform.data.logger_impl.MyLoggerImpl
import org.example.weathercrossplatform.domain.logger.MyLogger
import org.example.weathercrossplatform.domain.models.Coordinates

class RainMapViewModel(
    private val coordinates: Coordinates?,
    private val myLogger: MyLogger = MyLoggerImpl
) : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(RainMapState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                updateCoordinates(coordinates)
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
                    reloadMap(i)
                    _state.update { it.copy(sliderValue = i.toFloat()) }
                    delay(1500)
                }
            }
        }
    }

    private fun updateCoordinates(coordinates: Coordinates?) {
        myLogger.debug("check_coordinates coordinates in RainMapViewModel = $coordinates")
        if (coordinates == null) return
        _state.update {
            it.copy(latitude = coordinates.latitude, longitude = coordinates.longitude)
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

    private fun reloadMap(localHour: Int) {
        val current = _state.value
        val utcDateTime = currentTimeToUtcDateTime(localHour)
        myLogger.debug("check_coordinates coordinates in RainMapState = latitude = ${current.latitude}, longitude = ${current.longitude}")
        myLogger.debug("check_time localHour = $localHour, UTC hour = ${utcDateTime.hour} UTC date = ${utcDateTime.date}")
        _state.value = current.copy(
            date = utcDateTime.date,
            hour = utcDateTime.hour,
            currentTileUrl = buildTileTemplate(
                date = utcDateTime.date,
                hour = utcDateTime.hour
            ),
            mapHtml = buildRainMapHtml(
                latitude = current.latitude,
                longitude = current.longitude,
                zoom = current.zoom,
                date = utcDateTime.date,
                hour = utcDateTime.hour
            )
        )
    }
}
