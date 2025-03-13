package org.example.weathercrossplatform.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.icerock.moko.permissions.DeniedAlwaysException
import dev.icerock.moko.permissions.DeniedException
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.PermissionState
import dev.icerock.moko.permissions.PermissionsController
import dev.icerock.moko.permissions.RequestCanceledException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.weathercrossplatform.data.locationservice.LocationService
import org.example.weathercrossplatform.data.repo_impl.WeatherRepoImpl
import org.example.weathercrossplatform.data.utils.onError
import org.example.weathercrossplatform.data.utils.onSuccess
import org.example.weathercrossplatform.network.dto.CurrentWeatherDto

class PermissionsViewModel(
    private val permissionsController: PermissionsController,
    private val locationService: LocationService,
    private val weatherRepoImpl: WeatherRepoImpl
) : ViewModel() {
    private var _state = MutableStateFlow(PermissionState.NotDetermined)
    val state = _state.asStateFlow()

    private var _currentWeather = MutableStateFlow<CurrentWeatherDto?>(null)
    val currentWeather = _currentWeather.asStateFlow()

    private var _errorText = MutableStateFlow<String?>(null)
    val errorText = _errorText.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                permissionsController.getPermissionState(Permission.LOCATION)
            }
            checkPermissions()

        }
    }

    fun checkPermissions() {
        viewModelScope.launch {
            try {
                permissionsController.providePermission(Permission.LOCATION)
                _state.update {
                    PermissionState.Granted
                }
                locationService.getLocation().collect { coordinates ->
                    val query = "${coordinates.latitude},${coordinates.longitude}"
                    weatherRepoImpl.getCurrentWeather(query)
                        .onSuccess { weather ->
                            _currentWeather.update {
                                weather
                            }
                        }
                        .onError { networkError ->
                            _errorText.update {
                                networkError.name
                            }
                        }
                }
            } catch (e: DeniedAlwaysException) {
                _state.update {
                    PermissionState.DeniedAlways
                }
            } catch (e: DeniedException) {
                _state.update {
                    PermissionState.Denied
                }
            } catch (e: RequestCanceledException) {
                e.printStackTrace()
            }
        }
    }
}