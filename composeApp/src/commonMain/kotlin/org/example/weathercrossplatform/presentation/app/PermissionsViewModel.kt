package org.example.weathercrossplatform.presentation.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.icerock.moko.permissions.DeniedAlwaysException
import dev.icerock.moko.permissions.DeniedException
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.PermissionState
import dev.icerock.moko.permissions.PermissionsController
import dev.icerock.moko.permissions.RequestCanceledException
import dev.icerock.moko.permissions.location.LOCATION
import kotlinx.coroutines.launch

class PermissionsViewModel(
    private val permissionsController: PermissionsController
) : ViewModel() {

    var state by mutableStateOf(PermissionState.NotDetermined)
        private set
    var isFirstLaunch by mutableStateOf(true)

    init {
        viewModelScope.launch {
            state = permissionsController.getPermissionState(Permission.LOCATION)
        }
    }

    fun checkPermissions() {
        viewModelScope.launch {
            try {
                permissionsController.providePermission(Permission.LOCATION)
                state = PermissionState.Granted
            } catch (_: DeniedAlwaysException) {
                state = PermissionState.DeniedAlways
            } catch (_: DeniedException) {
                state = PermissionState.Denied
            } catch (e: RequestCanceledException) {
                e.printStackTrace()
            }
        }
    }
}