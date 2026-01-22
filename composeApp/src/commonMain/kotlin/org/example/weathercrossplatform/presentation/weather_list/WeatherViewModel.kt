package org.example.weathercrossplatform.presentation.weather_list

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
import org.example.weathercrossplatform.domain.repo.SettingsStorage
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.clouds
import weathercrossplatform.composeapp.generated.resources.extreme
import weathercrossplatform.composeapp.generated.resources.feels_like
import weathercrossplatform.composeapp.generated.resources.high
import weathercrossplatform.composeapp.generated.resources.humidity
import weathercrossplatform.composeapp.generated.resources.low
import weathercrossplatform.composeapp.generated.resources.moderate
import weathercrossplatform.composeapp.generated.resources.pressure
import weathercrossplatform.composeapp.generated.resources.uv
import weathercrossplatform.composeapp.generated.resources.wind
import kotlin.time.Clock
import kotlin.time.DurationUnit
import kotlin.time.toDuration


private const val MAX_AIR_PRESSURE_MM = 825
private const val MIN_AIR_PRESSURE_MM = 700
private const val MAX_AIR_PRESSURE_INCH = 32
private const val MIN_AIR_PRESSURE_INCH = 28

class WeatherViewModel(
    private val locationService: LocationService,
    private val weatherRepoImpl: WeatherRepoImpl,
    private val dataBaseRepo: DataBaseRepo,
    private val myLogger: MyLogger,
    private val settingsStorage: SettingsStorage,
    pageNumberFromSearchScreen: Int?,
    cityIdFromSearchScreen: Int?
) : ViewModel() {

    private val coordinates = MutableStateFlow<Coordinates?>(null)
    private val _weatherScreenState = MutableStateFlow(WeatherMainScreenState())
    val weatherScreenState = _weatherScreenState.asStateFlow()
    private val allCities = dataBaseRepo.getWeatherList()

    init {
        myLogger.debug("WeatherViewModel_init")
        viewModelScope.launch {
            settingsStorage.observeSettingsInfo().collect { info ->
                info?.let { settingsInfo ->
                    _weatherScreenState.update {
                        it.copy(
                            isTempC = settingsInfo.isTempC,
                            isWindKph = settingsInfo.isWindKph,
                            isPressureMb = settingsInfo.isPressureMb,
                            isLiquidGlassOn = settingsInfo.isLiquidGlassOn
                        )
                    }
                }
            }
        }
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
                getWeatherByQuery(actions.query)
            }

            is MainScreenActions.UpdatePage -> updatePage(actions.page)
            is MainScreenActions.PullToRefresh -> pullToRefresh(actions.query, actions.isCurrentLocation)
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

    private fun pullToRefresh(query: String, isCurrentLocation: Boolean) {
        viewModelScope.launch {
            val now = Clock.System.now()
            val initialTime = weatherScreenState.value.initialTime
            val passedTime = now - initialTime

            myLogger.debug("time_check: now: $now, initialTime: $initialTime, passedTime: $passedTime")
            if (passedTime > 30.toDuration(DurationUnit.SECONDS) && isCurrentLocation) {
                coordinates.update {
                    null
                }
                refreshPosition()
                coordinates.collectLatest { coordinates ->
                    coordinates?.let {
                        myLogger.debug("time_check: if block")
                        val query = "${it.latitude},${it.longitude}"
                        myLogger.debug("fun_GetWeatherByQuery, pullToRefresh")
                        getWeatherByQuery(query, it.latitude, it.longitude)
                        _weatherScreenState.update { state ->
                            state.copy(
                                initialTime = Clock.System.now()
                            )
                        }
                    }
                }
            } else {
                myLogger.debug("time_check: else block")
                getWeatherByQuery(query)
                _weatherScreenState.update { state ->
                    state.copy(
                        initialTime = Clock.System.now()
                    )
                }
            }
        }
    }

    private fun addCity(city: SavedWeatherItem) {
        viewModelScope.launch {
            dataBaseRepo.saveWeather(city)
            _weatherScreenState.update { it.copy(isAddCity = false, cityId = null) }
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

    private fun getWeatherByQuery(
        query: String,
        latitude: Double? = null,
        longitude: Double? = null
    ) {
        viewModelScope.launch {
            myLogger.debug("fun_getWeatherByQuery")
            _weatherScreenState.value = _weatherScreenState.value.copy(isLoading = true)
            weatherRepoImpl.getCurrentWeather(query)
                .onSuccess { weather ->
                    myLogger.debug("location.id = ${weather.location.id}")
                    val isTempC = weatherScreenState.value.isTempC
                    val isWindKph = weatherScreenState.value.isWindKph
                    val isPressureMb = weatherScreenState.value.isPressureMb
                    myLogger.debug("check_settings isTempC = $isTempC, isWindKph = $isWindKph, isPressureMb = $isPressureMb")
                    if (latitude != null && longitude != null) {
                        val desc = weather.current.condition.text.let {
                            if (it.length > 100) it.take(100) else it //fix OutOfMemoryError
                        }
                        dataBaseRepo.clearCurrentLocation()
                        val highTemp = if (isTempC) weather.forecast.forecastday[0].day.maxTempC else weather.forecast.forecastday[0].day.maxTempF
                        val lowTemp = if (isTempC) weather.forecast.forecastday[0].day.minTempC else weather.forecast.forecastday[0].day.minTempF
                        myLogger.debug("check_settings highTemp = $highTemp, lowTemp = $lowTemp")
                        dataBaseRepo.saveWeather(
                            weather = SavedWeatherItem(
                                cityName = weather.location.name,
                                temperature = if (isTempC) weather.current.tempC else weather.current.tempF,
                                weatherDescription = desc,
                                highTemperature = highTemp,
                                lowTemperature = lowTemp,
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
                        windSpeed = if (isWindKph) weather.current.windKph else weather.current.windMph,
                        windRotation = weather.current.windDegree,
                        pressure = if (isPressureMb) weather.current.pressureMb * 0.75 else weather.current.pressureIn,
                        clouds = weather.current.cloud,
                        uvIndex = weather.current.uv.toInt(),
                        feelsLike = if (isTempC) weather.current.feelsLikeC else weather.current.feelsLikeF,
                        rotationFeelsLike = calculateRotationAngle(
                            if (isTempC) weather.current.tempC else weather.current.tempF,
                            if (isTempC) weather.current.feelsLikeC else weather.current.feelsLikeF,
                            isTempC
                        ),
                        isWindKmh = isWindKph,
                        isPressureMb = isPressureMb,
                        isTempC = isTempC
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
        pressure: Double,
        clouds: Int,
        uvIndex: Int,
        feelsLike: Double,
        rotationFeelsLike: Float,
        isTempC: Boolean,
        isWindKmh: Boolean,
        isPressureMb: Boolean
    ): List<WeatherItem> {
        return listOf(
            WeatherItem(
                title = Res.string.humidity,
                description = "$humidity %",
                progress = humidity * 0.01.toFloat(),
                rotation = 0f
            ),
            WeatherItem(
                title = Res.string.wind,
                description = if (isWindKmh) "$windSpeed km/h" else "$windSpeed mp/h",
                progress = (windSpeed * if (isWindKmh) 0.01 else 0.016).toFloat(),
                rotation = windRotation.toFloat()
            ),
            WeatherItem(
                title = Res.string.pressure,
                description = if (isPressureMb) "$pressure mmHg" else "$pressure inHg",
                progress = calcPressureProgress(pressure, isPressureMb),
                rotation = 0f
            ),
            WeatherItem(
                title = Res.string.clouds,
                description = "$clouds %",
                progress = clouds * 0.01.toFloat(),
                rotation = 0f
            ),
            WeatherItem(
                title = Res.string.uv,
                description = when (uvIndex) {
                    in 0..2 -> Res.string.low
                    in 3..5 -> Res.string.moderate
                    in 6..8 -> Res.string.high
                    in 8..11 -> Res.string.extreme
                    else -> Res.string.uv
                },
                rotation = 0f,
                uvIndex = uvIndex
            ),
            WeatherItem(
                title = Res.string.feels_like,
                description = if (isTempC) "$feelsLike °C" else "$feelsLike °F",
                rotation = rotationFeelsLike,
            )
        )
    }

    private fun calcPressureProgress(pressure: Double, isPressureMb: Boolean): Float {
        val minPressure = if (isPressureMb) MIN_AIR_PRESSURE_MM else MIN_AIR_PRESSURE_INCH
        val maxPressure = if (isPressureMb) MAX_AIR_PRESSURE_MM else MAX_AIR_PRESSURE_INCH
        return ((pressure - minPressure).toFloat() / (maxPressure - minPressure))
    }

    private fun calculateRotationAngle(temperature: Double, feelsLike: Double, isTempC: Boolean): Float {
        val diff = feelsLike - temperature
        return (diff * if (isTempC) 20 else 11).toFloat()
    }
}