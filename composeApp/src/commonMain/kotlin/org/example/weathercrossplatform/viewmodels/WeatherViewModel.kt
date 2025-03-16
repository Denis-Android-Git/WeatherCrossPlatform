package org.example.weathercrossplatform.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.weathercrossplatform.data.locationservice.LocationService
import org.example.weathercrossplatform.data.repo_impl.WeatherRepoImpl
import org.example.weathercrossplatform.data.utils.onError
import org.example.weathercrossplatform.data.utils.onSuccess
import org.example.weathercrossplatform.domain.models.Coordinates
import org.example.weathercrossplatform.domain.models.WeatherMainScreenState

class WeatherViewModel(
    private val locationService: LocationService,
    private val weatherRepoImpl: WeatherRepoImpl
) : ViewModel() {

    private val coordinates = MutableStateFlow<Coordinates?>(null)

    private val _weatherScreenState = MutableStateFlow(WeatherMainScreenState())
    val weatherScreenState = _weatherScreenState.asStateFlow()

    init {
        viewModelScope.launch {
            locationService.getLocation().collectLatest { position ->
                coordinates.update {
                    position
                }
            }
        }
    }

    init {
        viewModelScope.launch {
            _weatherScreenState.value = _weatherScreenState.value.copy(
                isLoading = true
            )
            coordinates.collectLatest { coordinates ->
                coordinates?.let {
                    val query = "${it.latitude},${it.longitude}"
                    weatherRepoImpl.getCurrentWeather(query)
                        .onSuccess { weather ->

                            val imageQuery = when (weather.current.condition.text) {
                                "Ясно" -> "clear"
                                "Солнечно" -> "sunny"
                                else -> weather.current.condition.text
                            }

                            weatherRepoImpl.getImageList(imageQuery)
                                .onSuccess { imageList ->
                                    val image = imageList.results.take(30).random().urls.regular
                                    _weatherScreenState.value = _weatherScreenState.value.copy(
                                        image = image,
                                        isLoading = false,
                                        weatherDto = weather
                                    )
                                }
                                .onError { error ->
                                    _weatherScreenState.value = _weatherScreenState.value.copy(
                                        error = error.name,
                                        isLoading = false,
                                        weatherDto = weather
                                    )
                                }
                        }
                        .onError { networkError ->
                            _weatherScreenState.value = _weatherScreenState.value.copy(
                                isLoading = false,
                                error = networkError.name
                            )
                        }
                }
            }
        }
    }
}