package org.example.weathercrossplatform.presentation.weather_list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.weathercrossplatform.data.database.SavedWeatherItem
import org.example.weathercrossplatform.data.locationservice.LocationService
import org.example.weathercrossplatform.data.repo_impl.WeatherRepoImpl
import org.example.weathercrossplatform.data.utils.onError
import org.example.weathercrossplatform.data.utils.onSuccess
import org.example.weathercrossplatform.data.utils.toUiText
import org.example.weathercrossplatform.domain.actions.MainScreenActions
import org.example.weathercrossplatform.domain.logger.MyLogger
import org.example.weathercrossplatform.domain.models.Coordinates
import org.example.weathercrossplatform.domain.models.WeatherItem
import org.example.weathercrossplatform.domain.models.WeatherMainScreenState
import org.example.weathercrossplatform.domain.repo.DataBaseRepo
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.im_10
import kotlin.math.roundToInt

class WeatherViewModel(
    private val locationService: LocationService,
    private val weatherRepoImpl: WeatherRepoImpl,
    private val dataBaseRepo: DataBaseRepo,
    private val myLogger: MyLogger,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val pageNumberFromSearchScreen = savedStateHandle.get<Int>("pageNumber")
    private val cityIdFromSearchScreen = savedStateHandle.get<Int>("cityId")

    private val coordinates = MutableStateFlow<Coordinates?>(null)
    private val _weatherScreenState = MutableStateFlow(WeatherMainScreenState())
    val weatherScreenState = _weatherScreenState.asStateFlow()
    private val allCities = dataBaseRepo.getWeatherList()

    init {
        viewModelScope.launch {
            myLogger.debug("pageNumberFromSearchScreen = $pageNumberFromSearchScreen")
            myLogger.debug("cityIdFromSearchScreen = $cityIdFromSearchScreen")

            _weatherScreenState.update {
                it.copy(
                    pageNumberFromSearchScreen = pageNumberFromSearchScreen
                )
            }
        }
        viewModelScope.launch {
            allCities.collectLatest { savedCities ->
                _weatherScreenState.update {
                    it.copy(
                        savedCities = savedCities
                    )
                }
            }
        }
        cityIdFromSearchScreen?.let {
            setCityId(it)
        }
        viewModelScope.launch {
            myLogger.debug("getWeatherByQuery in pageNumberFromSearchScreen let block = $pageNumberFromSearchScreen")
            pageNumberFromSearchScreen?.let { page ->
                val savedCities = allCities.firstOrNull() ?: emptyList()
                //myLogger.debug("getWeatherByQuery savedCities = ${savedCities.joinToString("\n") { item -> item.cityName }}")
                if (page in savedCities.indices) {
                    getWeatherByQuery(savedCities[page].coordinates)
                }
                _weatherScreenState.update {
                    it.copy(
                        pageNumber = page
                    )
                }
            }
        }
        viewModelScope.launch {
            weatherScreenState.value.cityId?.let { cityId ->
                myLogger.debug("getWeatherByQuery in let block")
                getWeatherByQuery("id:$cityId")
            }
        }
    }

    fun onAction(actions: MainScreenActions) {
        when (actions) {
            MainScreenActions.Init -> init()
            MainScreenActions.RefreshPosition -> refreshPosition()
            is MainScreenActions.SetCityId -> setCityId(actions.cityId)
            is MainScreenActions.AddCity -> addCity(actions.city)
            is MainScreenActions.GetWeatherByQuery -> {
                myLogger.debug("fun_GetWeatherByQuery, MainScreenActions.GetWeatherByQuery")
                viewModelScope.launch {
                    getWeatherByQuery(actions.query)
                }
            }

            is MainScreenActions.UpdatePage -> updatePage(actions.page)
        }
    }

    fun updatePage(page: Int) {
        viewModelScope.launch {
            myLogger.debug("fun_GetWeatherByQuery, pageNumber in updatePage $page")
            _weatherScreenState.update {
                it.copy(
                    pageNumber = page
                )
            }
        }
    }

    private fun addCity(city: SavedWeatherItem) {
        viewModelScope.launch {
            dataBaseRepo.saveWeather(city)
            _weatherScreenState.update { it.copy(isAddCity = false) }
        }
    }

    private fun init() {
        myLogger.debug("fun_init")
        viewModelScope.launch(Dispatchers.IO) {
            myLogger.debug("city_id = ${_weatherScreenState.value.cityId}")
            if (_weatherScreenState.value.cityId == null) {
                myLogger.debug("cityId == null")
                coordinates.collect { coordinates ->
                    coordinates?.let {
                        val query = "${it.latitude},${it.longitude}"
                        myLogger.debug("fun_GetWeatherByQuery, init cityId == null")
                        getWeatherByQuery(query, it.latitude, it.longitude)
                    }
                }
            } else {
                myLogger.debug("fun_GetWeatherByQuery, init cityId not null")
                getWeatherByQuery("id:${_weatherScreenState.value.cityId}")
            }
        }
    }

    private fun setCityId(cityId: Int?) {
        viewModelScope.launch {
            myLogger.debug("fun_setCityId: cityId = $cityId")
            _weatherScreenState.update { it.copy(cityId = cityId, isAddCity = true) }
        }
    }

    private suspend fun getWeatherByQuery(
        query: String,
        latitude: Double? = null,
        longitude: Double? = null
    ) {
        myLogger.debug("fun_getWeatherByQuery")
        _weatherScreenState.value = _weatherScreenState.value.copy(isLoading = true)
        weatherRepoImpl.getCurrentWeather(query)
            .onSuccess { weather ->
                myLogger.debug("location.id = ${weather.location.id}")
                if (latitude != null && longitude != null) {
                    dataBaseRepo.clearCurrentLocation()
                    dataBaseRepo.saveWeather(
                        weather = SavedWeatherItem(
                            cityName = weather.location.name,
                            temperature = weather.current.tempC,
                            weatherDescription = weather.current.condition.text,
                            highTemperature = weather.forecast.forecastday[0].day.maxTempC,
                            lowTemperature = weather.forecast.forecastday[0].day.minTempC,
                            cityId = 111,
                            coordinates = "${weather.location.lat},${weather.location.lon}",
                            isCurrentLocation = true,
                        )
                    )
                }

                myLogger.debug("windRotation = ${weather.current.windDegree}, ${weather.current.windDir}")
                myLogger.debug("pressure = ${weather.current.pressureMb}, ${weather.current.pressureIn}")
                myLogger.debug("uv = ${weather.current.uv}")

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
                _weatherScreenState.value = _weatherScreenState.value.copy(
                    error = null,
                    isLoading = false,
                    weatherDto = weather,
                    weatherItemList = weatherItemList
                )
                val imageQuery = when (weather.current.condition.text) {
                    "Солнечно" -> "sunny"
                    "Ясно" -> "clear sky"
                    "Переменная облачность" -> "cloudy"
                    "Местами грозы" -> "thunderstorm"
                    "Небольшой дождь со снегом" -> "rain and snow"
                    "Пасмурно" -> "overcast"
                    "Дымка" -> "mist"
                    else -> weather.current.condition.text
                }

                myLogger.debug("imageQuery=$imageQuery")

                weatherRepoImpl.getImageList(imageQuery)
                    .onSuccess { imageList ->
                        myLogger.debug("imageList=${imageList.results.size}")

                        val photoList = imageList.results
                        if (photoList.isEmpty()) {
                            _weatherScreenState.value = _weatherScreenState.value.copy(
                                image = ""
                            )
                        } else {
                            val image = photoList.random().urls.small
                            _weatherScreenState.value = _weatherScreenState.value.copy(
                                image = image
                            )
                        }
                    }
                    .onError { _ ->
                        _weatherScreenState.value = _weatherScreenState.value.copy(
                            error = null,
                            image = ""
                        )
                    }
            }
            .onError { networkError ->
                val error = networkError.toUiText()
                _weatherScreenState.value = _weatherScreenState.value.copy(
                    isLoading = false,
                    error = error
                )
            }
    }

    private fun refreshPosition() {
        myLogger.debug("refreshPosition")
        viewModelScope.launch(Dispatchers.IO) {
            _weatherScreenState.value = _weatherScreenState.value.copy(
                isLoading = true
            )
            locationService.getLocation().collectLatest { position ->
                myLogger.debug("refreshPosition collectLatest position")
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