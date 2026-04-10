package org.example.weathercrossplatform.presentation.rain_map_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.example.weathercrossplatform.data.constants.Constants.MAP_REFRESH_INTERVAL
import org.example.weathercrossplatform.data.logger_impl.MyLoggerImpl
import org.example.weathercrossplatform.domain.logger.MyLogger
import org.example.weathercrossplatform.domain.models.Coordinates
import kotlin.math.roundToInt
import kotlin.time.Clock

class RainMapViewModel(
    private val coordinates: Coordinates?,
    private val myLogger: MyLogger = MyLoggerImpl
) : ViewModel() {

    private var hasLoadedInitialData = false

    private val currentHour =
        Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).hour

    private var autoSlideJob: Job? = null

    private val _state = MutableStateFlow(RainMapState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                updateCoordinates(coordinates)
                observeAutoSlide()
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = RainMapState()
        )

    private fun observeAutoSlide() {
        state
            .map { it.isAutoSlide }
            .distinctUntilChanged()
            .onEach { isAuto ->
                myLogger.debug("check_auto_slide isAuto = $isAuto")
                if (isAuto) {
                    if (autoSlideJob?.isActive == true) return@onEach
                    autoSlideJob = viewModelScope.launch {
                        slideOverMap(currentHour, 23)
                        while (true) {
                            slideOverMap(0, 23)
                        }
                    }
                } else {
                    autoSlideJob?.cancel()
                    autoSlideJob = null
                }
            }.launchIn(viewModelScope)
    }

    private suspend fun slideOverMap(from: Int, to: Int) {
        for (i in from..to) {
            reloadMap(i)
            _state.update { it.copy(sliderValue = i.toFloat()) }
            delay(MAP_REFRESH_INTERVAL)
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
            is RainMapAction.OnSliderChanged -> sliderChanged(action.value.roundToInt().toFloat())
        }
    }

    private fun sliderChanged(value: Float) {
        _state.update {
            it.copy(
                sliderValue = value,
                isAutoSlide = false
            )
        }
        reloadMap(value.toInt())
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
