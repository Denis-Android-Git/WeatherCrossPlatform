package org.example.weathercrossplatform.presentation.weather_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.weathercrossplatform.data.constants.Constants.MAX_AIR_PRESSURE_INCH
import org.example.weathercrossplatform.data.constants.Constants.MAX_AIR_PRESSURE_MM
import org.example.weathercrossplatform.data.constants.Constants.MIN_AIR_PRESSURE_INCH
import org.example.weathercrossplatform.data.constants.Constants.MIN_AIR_PRESSURE_MM
import org.example.weathercrossplatform.data.database.SavedWeatherItem
import org.example.weathercrossplatform.data.lifecycleObserver.LifeCycleObserver
import org.example.weathercrossplatform.data.locationservice.LocationService
import org.example.weathercrossplatform.data.logger_impl.MyLoggerImpl
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
import org.example.weathercrossplatform.domain.repo.WeatherRepo
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

class WeatherViewModel(
    private val locationService: LocationService,
    private val weatherRepo: WeatherRepo,
    private val dataBaseRepo: DataBaseRepo,
    lifeCycleObserver: LifeCycleObserver,
    settingsStorage: SettingsStorage,
    pageNumberFromSearchScreen: Int?,
    orientation: String,
    private val myLogger: MyLogger = MyLoggerImpl
) : ViewModel() {
    private val coordinates = MutableStateFlow<Coordinates?>(null)
    private val _weatherScreenState = MutableStateFlow(WeatherMainScreenState())
    val weatherScreenState = combine(
        _weatherScreenState,
        settingsStorage.observeSettingsInfo(),
        dataBaseRepo.getWeatherList()
    ) { state, settings, savedCities ->

        state.copy(
            savedCities = savedCities,
            isTempC = settings?.isTempC ?: true,
            isWindKph = settings?.isWindKph ?: true,
            isPressureMb = settings?.isPressureMb ?: true,
            isLiquidGlassOn = settings?.isLiquidGlassOn ?: false
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = WeatherMainScreenState()
    )

    init {
        lifeCycleObserver.isInForeGround.onEach {
            val currentCoordinates = weatherScreenState.value.currentCoordinates
            val currentOrientation = weatherScreenState.value.currentOrientation
            if (it && currentCoordinates != null) {
                getWeatherByQuery(
                    query = currentCoordinates,
                    orientation = currentOrientation
                )
            }
        }.launchIn(viewModelScope)

        viewModelScope.launch {
            _weatherScreenState.update {
                it.copy(
                    pageNumberFromSearchScreen = pageNumberFromSearchScreen
                )
            }
        }
        viewModelScope.launch {
            pageNumberFromSearchScreen?.let { page ->
                val savedCities = dataBaseRepo.getWeatherList().first()
                if (page in savedCities.indices) {
                    getWeatherByQuery(savedCities[page].coordinates, orientation)
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
                getWeatherByQuery("id:$cityId", orientation)
            }
        }
    }

    fun onAction(actions: MainScreenActions) {
        when (actions) {
            is MainScreenActions.Init -> init(actions.orientation)
            MainScreenActions.RefreshPosition -> refreshPosition()
            is MainScreenActions.SetCityId -> setCityId(actions.cityId)
            is MainScreenActions.AddCity -> buildCityAndSaveInDb(actions.cityId)
            is MainScreenActions.GetWeatherByQuery -> {
                getWeatherByQuery(actions.query, actions.orientation)
            }

            is MainScreenActions.UpdatePage -> updatePage(actions.page)
            is MainScreenActions.PullToRefresh -> pullToRefresh(
                actions.query,
                actions.isCurrentLocation,
                actions.orientation
            )
        }
    }

    private fun generateRandomPicNumber() {
        viewModelScope.launch {
            val randomNumber = (0..<_weatherScreenState.value.appPhotoList.size).random()
            _weatherScreenState.update {
                it.copy(
                    randomPicNumber = randomNumber
                )
            }
        }
    }

    fun updatePage(page: Int) {
        viewModelScope.launch {
            _weatherScreenState.update {
                it.copy(
                    pageNumber = page
                )
            }
            generateRandomPicNumber()
        }
    }

    private fun pullToRefresh(query: String, isCurrentLocation: Boolean, orientation: String) {
        viewModelScope.launch {
            val now = Clock.System.now()
            val initialTime = weatherScreenState.value.initialTime
            val passedTime = now - initialTime
            if (passedTime > 10.toDuration(DurationUnit.MINUTES) && isCurrentLocation) {
                coordinates.update {
                    null
                }
                refreshPosition()
                coordinates.collectLatest { coordinates ->
                    coordinates?.let {
                        val query = "${it.latitude},${it.longitude}"
                        getWeatherByQuery(
                            query,
                            orientation = orientation,
                            it.latitude,
                            it.longitude
                        )
                        _weatherScreenState.update { state ->
                            state.copy(
                                initialTime = Clock.System.now()
                            )
                        }
                    }
                }
            } else {
                getWeatherByQuery(query, orientation)
            }
        }
    }

    private fun init(orientation: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (_weatherScreenState.value.cityId == null) {
                coordinates.collect { coordinates ->
                    coordinates?.let {
                        val query = "${it.latitude},${it.longitude}"
                        getWeatherByQuery(query, orientation, it.latitude, it.longitude)
                    }
                }
            } else {
                getWeatherByQuery("id:${_weatherScreenState.value.cityId}", orientation)
            }
        }
    }

    private fun setCityId(cityId: Int?) {
        viewModelScope.launch {
            _weatherScreenState.update { it.copy(cityId = cityId, isAddCity = true) }
        }
    }

    private fun buildCityAndSaveInDb(cityId: Int?) {
        viewModelScope.launch {
            _weatherScreenState.update { it.copy(isLoading = true) }
            val dto = weatherScreenState.value.weatherDto
            val item = SavedWeatherItem(
                cityName = dto?.location?.name
                    ?: "",
                temperature = dto?.current?.tempC
                    ?: 0.0,
                weatherDescription = dto?.current?.condition?.text
                    ?: "",
                highTemperature = dto?.forecast?.forecastday[0]?.day?.maxTempC
                    ?: 0.0,
                lowTemperature = dto?.forecast?.forecastday[0]?.day?.minTempC
                    ?: 0.0,
                cityId = cityId,
                coordinates = "${dto?.location?.lat},${dto?.location?.lon}",
                isCurrentLocation = false
            )
            dataBaseRepo.saveWeather(item)
            cityId?.let {
                dataBaseRepo.deleteSearchedItem(cityId)
            }
            _weatherScreenState.update {
                it.copy(
                    isAddCity = false,
                    cityId = null,
                    isLoading = false
                )
            }
        }
    }

    private fun getWeatherByQuery(
        query: String,
        orientation: String,
        latitude: Double? = null,
        longitude: Double? = null
    ) {
        myLogger.debug("check_isInForeGround getWeatherByQuery query = $query, orientation = $orientation")

        viewModelScope.launch {
            _weatherScreenState.update {
                it.copy(
                    currentOrientation = orientation
                )
            }
            if (!query.contains("id:")) {
                _weatherScreenState.update {
                    it.copy(
                        currentCoordinates = query
                    )
                }
            }
            _weatherScreenState.value = _weatherScreenState.value.copy(isLoading = true)
            weatherRepo.getCurrentWeather(query)
                .onSuccess { weather ->
                    val isTempC = weatherScreenState.value.isTempC
                    val isWindKph = weatherScreenState.value.isWindKph
                    val isPressureMb = weatherScreenState.value.isPressureMb
                    if (latitude != null && longitude != null) {
                        val desc = weather.current.condition.text.let {
                            if (it.length > 100) it.take(100) else it //fix OutOfMemoryError
                        }
                        dataBaseRepo.clearCurrentLocation()
                        val highTemp =
                            if (isTempC) weather.forecast.forecastday[0].day.maxTempC else weather.forecast.forecastday[0].day.maxTempF
                        val lowTemp =
                            if (isTempC) weather.forecast.forecastday[0].day.minTempC else weather.forecast.forecastday[0].day.minTempF
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

                    weatherRepo.getImageList(imageQuery, orientation)
                        .onSuccess { imageList ->
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
                rotation = 0f,
                id = 1
            ),
            WeatherItem(
                title = Res.string.wind,
                description = if (isWindKmh) "$windSpeed km/h" else "$windSpeed mp/h",
                progress = (windSpeed * if (isWindKmh) 0.01 else 0.016).toFloat(),
                rotation = windRotation.toFloat(),
                id = 2
            ),
            WeatherItem(
                title = Res.string.pressure,
                description = if (isPressureMb) "$pressure mmHg" else "$pressure inHg",
                progress = calcPressureProgress(pressure, isPressureMb),
                rotation = 0f,
                id = 3
            ),
            WeatherItem(
                title = Res.string.clouds,
                description = "$clouds %",
                progress = clouds * 0.01.toFloat(),
                rotation = 0f,
                id = 4
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
                uvIndex = uvIndex,
                id = 5
            ),
            WeatherItem(
                title = Res.string.feels_like,
                description = if (isTempC) "$feelsLike °C" else "$feelsLike °F",
                rotation = rotationFeelsLike,
                id = 6
            )
        )
    }

    private fun calcPressureProgress(pressure: Double, isPressureMb: Boolean): Float {
        val minPressure = if (isPressureMb) MIN_AIR_PRESSURE_MM else MIN_AIR_PRESSURE_INCH
        val maxPressure = if (isPressureMb) MAX_AIR_PRESSURE_MM else MAX_AIR_PRESSURE_INCH
        return ((pressure - minPressure).toFloat() / (maxPressure - minPressure))
    }

    private fun calculateRotationAngle(
        temperature: Double,
        feelsLike: Double,
        isTempC: Boolean
    ): Float {
        val diff = feelsLike - temperature
        return (diff * if (isTempC) 20 else 11).toFloat()
    }
}