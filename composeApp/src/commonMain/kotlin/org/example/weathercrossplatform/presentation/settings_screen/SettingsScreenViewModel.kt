package org.example.weathercrossplatform.presentation.settings_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingsScreenViewModel : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(SettingsScreenState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                /** Load initial data here **/
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = SettingsScreenState()
        )

    fun onAction(action: SettingsScreenAction) {
        when (action) {
            is SettingsScreenAction.SetDropDownTempExpanded -> setDropDownTempExpanded(action.value)
            is SettingsScreenAction.SetDropDownPressureExpanded -> setDropDownPressureExpanded(action.value)
            is SettingsScreenAction.SetDropDownWindExpanded -> setDropDownWindExpanded(action.value)
            SettingsScreenAction.SetPressureUnit -> {}
            SettingsScreenAction.SetTempUnit -> {}
            SettingsScreenAction.SetWindSpeedUnit -> {}
        }
    }

    private fun setDropDownPressureExpanded(value: Boolean) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isDropPressureExpanded = value
                )
            }
        }
    }

    private fun setDropDownWindExpanded(value: Boolean) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isDropWindExpanded = value
                )
            }
        }
    }

    private fun setDropDownTempExpanded(value: Boolean) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isDropTempExpanded = value
                )
            }
        }
    }

}