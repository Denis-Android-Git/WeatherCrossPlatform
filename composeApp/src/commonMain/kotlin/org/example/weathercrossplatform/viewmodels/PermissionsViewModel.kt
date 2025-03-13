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

class PermissionsViewModel(
    private val permissionsController: PermissionsController
) : ViewModel() {

    private var _state = MutableStateFlow(PermissionState.NotDetermined)
    val state = _state.asStateFlow()

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