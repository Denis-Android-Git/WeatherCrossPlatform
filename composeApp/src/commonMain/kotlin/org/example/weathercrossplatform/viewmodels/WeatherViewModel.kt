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
import org.example.weathercrossplatform.domain.models.WeatherItem
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
            try {
                _weatherScreenState.value = _weatherScreenState.value.copy(
                    isLoading = true
                )
                coordinates.collectLatest { coordinates ->
                    coordinates?.let {
                        val query = "${it.latitude},${it.longitude}"

                        println("query=$query")

                        weatherRepoImpl.getCurrentWeather(query)
                            .onSuccess { weather ->

                                println("windRotation = ${weather.current.windDegree}, ${weather.current.windDir}")

                                val weatherItemList = createWeatherItemList(
                                    humidity = weather.current.humidity,
                                    windSpeed = weather.current.windKph,
                                    windRotation = weather.current.windDegree,
                                    pressure = weather.current.pressureMb,
                                    clouds = weather.current.cloud
                                )

                                val imageQuery = when (weather.current.condition.text) {
                                    "Солнечно" -> "sunny"
                                    "Ясно" -> "clear sky"
                                    "Переменная облачность" -> "cloudy"
                                    else -> weather.current.condition.text
                                }

                                println("imageQuery=$imageQuery")

                                weatherRepoImpl.getImageList(imageQuery)
                                    .onSuccess { imageList ->
                                        val image = imageList.results.take(30).random().urls.regular
                                        _weatherScreenState.value = _weatherScreenState.value.copy(
                                            image = image,
                                            isLoading = false,
                                            weatherDto = weather,
                                            weatherItemList = weatherItemList
                                        )
                                    }
                                    .onError { error ->
                                        _weatherScreenState.value = _weatherScreenState.value.copy(
                                            error = error.name,
                                            isLoading = false,
                                            weatherDto = weather,
                                            weatherItemList = weatherItemList
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
            } catch (e: Exception) {
                _weatherScreenState.value = _weatherScreenState.value.copy(
                    isLoading = false,
                    error = e.message.toString()
                )
            }
        }
    }

    private fun createWeatherItemList(
        humidity: Int,
        windSpeed: Double,
        windRotation: Int,
        pressure: Double,
        clouds: Int
    ): List<WeatherItem> {
        return listOf(
            WeatherItem(
                title = "Humidity",
                description = "$humidity %",
                progress = humidity * 0.01.toFloat(),
                rotation = 0f
            ),
            WeatherItem(
                title = "Wind",
                description = "$windSpeed km/h",
                progress = (windSpeed * 0.01).toFloat(),
                rotation = windRotation.toFloat()
            ),
            WeatherItem(
                title = "Pressure",
                description = "$pressure mmHg",
                progress = (pressure * 0.001).toFloat(),
                rotation = 0f
            ),
            WeatherItem(
                title = "Clouds",
                description = "$clouds %",
                progress = clouds * 0.01.toFloat(),
                rotation = 0f
            )
        )
    }
}