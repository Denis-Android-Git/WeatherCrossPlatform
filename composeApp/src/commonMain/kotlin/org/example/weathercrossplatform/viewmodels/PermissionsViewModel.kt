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
import org.example.weathercrossplatform.domain.models.Coordinates

class PermissionsViewModel(
    private val permissionsController: PermissionsController,
    private val locationService: LocationService
) : ViewModel() {
    private var _state = MutableStateFlow(PermissionState.NotDetermined)
    val state = _state.asStateFlow()

    private var _coordinates = MutableStateFlow<Coordinates?>(null)
    val coordinates = _coordinates.asStateFlow()


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
                    _coordinates.update {
                        coordinates
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