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
import org.example.weathercrossplatform.network.dto.CurrentWeatherDto

class WeatherViewModel(
    private val locationService: LocationService,
    private val weatherRepoImpl: WeatherRepoImpl
) : ViewModel() {
    private val coordinates = MutableStateFlow<Coordinates?>(null)

    private val _weather = MutableStateFlow<CurrentWeatherDto?>(null)
    val weather = _weather.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

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
            coordinates.collectLatest { coordinates ->
                coordinates?.let {
                    val query = "${it.latitude},${it.longitude}"
                    weatherRepoImpl.getCurrentWeather(query)
                        .onSuccess { weather ->
                            _weather.update {
                                weather
                            }
                        }
                        .onError { networkError ->
                            _error.value = networkError.name
                        }
                }
            }
        }
    }
}