package org.example.weathercrossplatform.presentation.search_weather

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.weathercrossplatform.data.database.SavedWeatherItem
import org.example.weathercrossplatform.data.utils.onError
import org.example.weathercrossplatform.data.utils.onSuccess
import org.example.weathercrossplatform.domain.actions.SearchScreenActions
import org.example.weathercrossplatform.domain.logger.MyLogger
import org.example.weathercrossplatform.domain.models.SearchScreenViewState
import org.example.weathercrossplatform.domain.repo.DataBaseRepo
import org.example.weathercrossplatform.domain.repo.SettingsStorage
import org.example.weathercrossplatform.domain.repo.WeatherRepo
import kotlin.time.Duration.Companion.seconds

class SearchViewModel(
    private val dataBaseRepo: DataBaseRepo,
    private val weatherRepo: WeatherRepo,
    private val myLogger: MyLogger,
    private val settingsStorage: SettingsStorage,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var hasLoadedInitialData = false

    private val pageNum = savedStateHandle.get<Int>("pageNumber") ?: 0
    private val allCitiesInOriginalOrder = dataBaseRepo.getWeatherList()
    private val allCities = dataBaseRepo.getWeatherList()
        .map { list ->
            if (list.size <= 1) {
                list
            } else {
                listOf(list.first()) + list.drop(1).reversed()
            }
        }
    private val _searchScreenState = MutableStateFlow(SearchScreenViewState())

    @OptIn(FlowPreview::class)
    private val searchFlow = _searchScreenState
        .map {
            it.searchQuery
        }
        .distinctUntilChanged()
        .debounce(1.seconds)
        .onEach {
            if (it.length > 2) {
                searchCities(it)
            }
        }
    val searchScreenState = _searchScreenState    //.asStateFlow()
        .onStart {
            if (!hasLoadedInitialData) {
                searchFlow.launchIn(viewModelScope)
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = SearchScreenViewState()
        )

    init {
        viewModelScope.launch {
            settingsStorage.observeSettingsInfo().collect { settingsInfo ->
                settingsInfo?.let { info ->
                    _searchScreenState.update {
                        it.copy(
                            isTempC = info.isTempC
                        )
                    }
                }
            }
        }

        viewModelScope.launch {
            val savedCities = dataBaseRepo.getWeatherList().firstOrNull()
            savedCities?.let { list ->
                val isTempC = searchScreenState.value.isTempC
                list.forEach { savedWeatherItem ->
                    async {
                        weatherRepo.getCurrentWeather(savedWeatherItem.coordinates)
                            .onSuccess { newInfo ->
                                myLogger.debug("SearchViewModel_newInfo = $${savedWeatherItem.coordinates}, ${savedWeatherItem.cityId}, ${savedWeatherItem.temperature}, ${savedWeatherItem.highTemperature}")
                                myLogger.debug("SearchViewModel_newInfo = $${newInfo.location.name}, ${newInfo.current.tempC}, ${newInfo.forecast.forecastday[0].day.maxTempC}")
                                val item = SavedWeatherItem(
                                    cityId = savedWeatherItem.cityId,
                                    cityName = savedWeatherItem.cityName,
                                    temperature = if (isTempC) newInfo.current.tempC else newInfo.current.tempF,
                                    weatherDescription = newInfo.current.condition.text,
                                    highTemperature = if (isTempC) newInfo.forecast.forecastday[0].day.maxTempC else newInfo.forecast.forecastday[0].day.maxTempF,
                                    lowTemperature = if (isTempC) newInfo.forecast.forecastday[0].day.minTempC else newInfo.forecast.forecastday[0].day.minTempF,
                                    coordinates = savedWeatherItem.coordinates,
                                    isCurrentLocation = savedWeatherItem.isCurrentLocation,
                                )
                                dataBaseRepo.saveWeather(item)
                            }
                            .onError {

                            }
                    }
                }
            }
        }
        viewModelScope.launch {
            myLogger.debug("SearchViewModel_pageNum = $pageNum")
            _searchScreenState.update {
                it.copy(
                    pageNumber = pageNum
                )
            }
        }
        viewModelScope.launch {
            allCitiesInOriginalOrder.collect { allCitiesInOriginalOrderList ->
                _searchScreenState.update {
                    it.copy(
                        allCitiesInOriginalOrder = allCitiesInOriginalOrderList
                    )
                }
            }
        }
        viewModelScope.launch {
            allCities.collect { allCitiesList ->
                _searchScreenState.update {
                    it.copy(
                        allCities = allCitiesList
                    )
                }
            }
        }
    }

    fun onAction(action: SearchScreenActions) {
        when (action) {
            is SearchScreenActions.SearchCities -> searchCities(action.city)
            is SearchScreenActions.SetExpanded -> setExpanded(action.expanded)
            is SearchScreenActions.SetSearchQuery -> setSearchQuery(action.query)
            is SearchScreenActions.SetTempList -> setTempList(action.item)
            is SearchScreenActions.DeleteTempCityList -> deleteTempCityList(action.tempList)
        }
    }

    private fun deleteTempCityList(tempCityList: List<SavedWeatherItem>) {
        viewModelScope.launch {
            tempCityList.forEach {
                dataBaseRepo.deleteWeather(it)
                setTempList(it)
            }
        }
    }

    private fun setTempList(
        savedWeatherItem: SavedWeatherItem?
    ) {
        viewModelScope.launch {
            if (savedWeatherItem != null) {
                val currentList = _searchScreenState.value.tempListToDelete
                val newCurrentList = if (currentList.contains(savedWeatherItem)) {
                    currentList - savedWeatherItem
                } else {
                    currentList + savedWeatherItem
                }
                _searchScreenState.update {
                    it.copy(tempListToDelete = newCurrentList)
                }
                myLogger.debug("tempList: ${currentList.size}")

            } else {
                _searchScreenState.update {
                    val emptyList = emptyList<SavedWeatherItem>()
                    it.copy(tempListToDelete = emptyList)
                }
            }
        }
    }

    private fun setSearchQuery(query: String) {
        viewModelScope.launch {
            _searchScreenState.update {
                it.copy(searchQuery = query)
            }
//            if (query.length > 2) {
//                searchCities(query)
//            }
        }
    }

    private fun searchCities(query: String) {
        myLogger.debug("searchCities: $query")
        viewModelScope.launch {
            _searchScreenState.update {
                it.copy(loading = true)
            }
            weatherRepo.searchPlaces(query)
                .onSuccess { locationList ->
                    _searchScreenState.update {
                        it.copy(loading = false, cityList = locationList)
                    }
                }
                .onError { error ->
                    _searchScreenState.update {
                        it.copy(loading = false, error = error.name)

                    }
                }
        }
    }

    private fun setExpanded(expanded: Boolean) {
        viewModelScope.launch {
            _searchScreenState.update {
                it.copy(expanded = expanded)
            }
        }
    }
}