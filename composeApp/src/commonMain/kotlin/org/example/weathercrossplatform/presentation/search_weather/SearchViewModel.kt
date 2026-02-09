package org.example.weathercrossplatform.presentation.search_weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.first
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
import org.example.weathercrossplatform.domain.models.SearchScreenViewState
import org.example.weathercrossplatform.domain.repo.DataBaseRepo
import org.example.weathercrossplatform.domain.repo.SettingsStorage
import org.example.weathercrossplatform.domain.repo.WeatherRepo
import kotlin.time.Duration.Companion.seconds

class SearchViewModel(
    private val dataBaseRepo: DataBaseRepo,
    private val weatherRepo: WeatherRepo,
    //private val myLogger: MyLogger = MyLoggerImpl,
    private val settingsStorage: SettingsStorage
) : ViewModel() {
    private var hasLoadedInitialData = false
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
    val searchScreenState = combine(
        _searchScreenState,
        allCities,
        allCitiesInOriginalOrder,
        searchFlow,
        settingsStorage.observeSettingsInfo()
    ) { currentState, allCities, allCitiesInOriginalOrder, _, settingsInfo ->
        currentState.copy(
            allCities = allCities,
            allCitiesInOriginalOrder = allCitiesInOriginalOrder,
            isTempC = settingsInfo?.isTempC ?: true,
            isLiquidGlassOn = settingsInfo?.isLiquidGlassOn ?: false
        )
    }
        .onStart {
            if (!hasLoadedInitialData) {
                updateSavedList()
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = SearchScreenViewState()
        )

    fun updateSavedList() {
        viewModelScope.launch {
            val allCities = allCities.first()
            val settings = settingsStorage.observeSettingsInfo().first()
            val isTempC = settings?.isTempC ?: true
            allCities.forEach { savedWeatherItem ->
                async {
                    weatherRepo.getCurrentWeather(savedWeatherItem.coordinates)
                        .onSuccess { newInfo ->
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
            dataBaseRepo.deleteWeatherList(tempCityList)
            setTempList(null)
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
        }
    }

    private fun searchCities(query: String) {
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