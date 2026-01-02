package org.example.weathercrossplatform.presentation.settings_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.weathercrossplatform.domain.models.SettingsInfo
import org.example.weathercrossplatform.domain.repo.SettingsStorage

class SettingsScreenViewModel(
    private val settingsStorage: SettingsStorage
) : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(SettingsScreenState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                observeSettings()
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
            is SettingsScreenAction.SetPressureUnit -> setPressureUnit(action.value)
            is SettingsScreenAction.SetTempUnit -> setTempUnit(action.value)
            is SettingsScreenAction.SetWindSpeedUnit -> setWindSpeedUnit(action.value)
            SettingsScreenAction.OpenPrivacyPolicy -> openPrivacyPolicy()
        }
    }

    private fun openPrivacyPolicy() {
        viewModelScope.launch {
            openUrl(PRIVACY_POLICY_URL)
        }
    }

    private fun observeSettings() {
        viewModelScope.launch {
            settingsStorage.observeSettingsInfo().collect { info ->
                info?.let { settings ->
                    _state.update {
                        it.copy(
                            isTempC = settings.isTempC,
                            isPressureMb = settings.isPressureMb,
                            isWindKph = settings.isWindKph
                        )
                    }
                }
            }
        }
    }

    private fun setTempUnit(value: Boolean) {
        viewModelScope.launch {
            val settings = SettingsInfo(
                isTempC = value,
                isWindKph = state.value.isWindKph,
                isPressureMb = state.value.isPressureMb
            )
            settingsStorage.set(settings)
            _state.update {
                it.copy(
                    isTempC = value,
                    isDropTempExpanded = false
                )
            }
        }
    }

    private fun setWindSpeedUnit(value: Boolean) {
        viewModelScope.launch {
            val settings = SettingsInfo(
                isTempC = state.value.isTempC,
                isWindKph = value,
                isPressureMb = state.value.isPressureMb
            )
            settingsStorage.set(settings)
            _state.update {
                it.copy(
                    isWindKph = value,
                    isDropWindExpanded = false
                )
            }
        }
    }

    private fun setPressureUnit(value: Boolean) {
        viewModelScope.launch {
            val settings = SettingsInfo(
                isTempC = state.value.isTempC,
                isWindKph = state.value.isWindKph,
                isPressureMb = value
            )
            settingsStorage.set(settings)
            _state.update {
                it.copy(
                    isPressureMb = value,
                    isDropPressureExpanded = false
                )
            }
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