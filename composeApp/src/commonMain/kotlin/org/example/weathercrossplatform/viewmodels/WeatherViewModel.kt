package org.example.weathercrossplatform.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.weathercrossplatform.data.database.SavedWeatherItem
import org.example.weathercrossplatform.data.locationservice.LocationService
import org.example.weathercrossplatform.data.repo_impl.WeatherRepoImpl
import org.example.weathercrossplatform.data.utils.onError
import org.example.weathercrossplatform.data.utils.onSuccess
import org.example.weathercrossplatform.domain.models.Coordinates
import org.example.weathercrossplatform.domain.models.WeatherItem
import org.example.weathercrossplatform.domain.models.WeatherMainScreenState
import org.example.weathercrossplatform.domain.repo.DataBaseRepo
import kotlin.math.roundToInt

class WeatherViewModel(
    private val locationService: LocationService,
    private val weatherRepoImpl: WeatherRepoImpl,
    private val dataBaseRepo: DataBaseRepo
) : ViewModel() {

    private val coordinates = MutableStateFlow<Coordinates?>(null)

    private val _weatherScreenState = MutableStateFlow(WeatherMainScreenState())
    val weatherScreenState = _weatherScreenState.asStateFlow()

    init {
        refreshPosition()
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                coordinates.collectLatest { coordinates ->

                    coordinates?.let {
                        val query = "${it.latitude},${it.longitude}"

                        println("query=$query")

                        weatherRepoImpl.getCurrentWeather(query)
                            .onSuccess { weather ->

                                dataBaseRepo.saveWeather(
                                    weather = SavedWeatherItem(
                                        id = 0,
                                        cityName = weather.location.name,
                                        latitude = it.latitude,
                                        longitude = it.longitude,
                                        temperature = weather.current.tempC,
                                        weatherDescription = weather.current.condition.text,
                                        highTemperature = weather.forecast.forecastday[0].day.maxTempC,
                                        lowTemperature = weather.forecast.forecastday[0].day.minTempC
                                    )
                                )

                                println("windRotation = ${weather.current.windDegree}, ${weather.current.windDir}")
                                println("pressure = ${weather.current.pressureMb}, ${weather.current.pressureIn}")
                                println("uv = ${weather.current.uv}")

                                val weatherItemList = createWeatherItemList(
                                    humidity = weather.current.humidity,
                                    windSpeed = weather.current.windKph,
                                    windRotation = weather.current.windDegree,
                                    pressure = (weather.current.pressureMb * 0.75).roundToInt(),//перевод в мм ртутного столба
                                    clouds = weather.current.cloud,
                                    uvIndex = weather.current.uv.toInt(),
                                    feelsLike = weather.current.feelsLikeC,
                                    rotationFeelsLike = calculateRotationAngle(
                                        weather.current.tempC,
                                        weather.current.feelsLikeC
                                    )
                                )

                                val imageQuery = when (weather.current.condition.text) {
                                    "Солнечно" -> "sunny"
                                    "Ясно" -> "clear sky"
                                    "Переменная облачность" -> "cloudy"
                                    "Местами грозы" -> "thunderstorm"
                                    "Небольшой дождь со снегом" -> "rain and snow"
                                    "Пасмурно" -> "overcast"
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

    fun refreshPosition() {
        viewModelScope.launch(Dispatchers.IO) {
            _weatherScreenState.value = _weatherScreenState.value.copy(
                isLoading = true
            )
            locationService.getLocation().collectLatest { position ->
                coordinates.update {
                    position
                }
            }
        }
    }

    private fun createWeatherItemList(
        humidity: Int,
        windSpeed: Double,
        windRotation: Int,
        pressure: Int,
        clouds: Int,
        uvIndex: Int,
        feelsLike: Double,
        rotationFeelsLike: Float
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
            ),
            WeatherItem(
                title = "Uv",
                description = when (uvIndex) {
                    in 0..2 -> "Low"
                    in 3..5 -> "Moderate"
                    in 6..8 -> "High"
                    in 8..11 -> "Extreme"
                    else -> ""
                },
                rotation = 0f,
                uvIndex = uvIndex
            ),
            WeatherItem(
                title = "Feels Like",
                description = "$feelsLike°C",
                rotation = rotationFeelsLike,
            )
        )
    }

    private fun calculateRotationAngle(temperature: Double, feelsLike: Double): Float {
        val diff = feelsLike - temperature
        return (diff * 20).toFloat()
    }
}