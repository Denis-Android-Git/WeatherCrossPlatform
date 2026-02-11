package org.example.weathercrossplatform.presentation.settings_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.weathercrossplatform.data.constants.Constants.PRIVACY_POLICY_URL
import org.example.weathercrossplatform.data.sdk_checker.isLiquidGlassAvailable
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
            is SettingsScreenAction.SetDropDownPressureExpanded -> setDropDownPressureExpanded(
                action.value
            )

            is SettingsScreenAction.SetDropDownWindExpanded -> setDropDownWindExpanded(action.value)
            is SettingsScreenAction.SetPressureUnit -> setPressureUnit(action.value)
            is SettingsScreenAction.SetTempUnit -> setTempUnit(action.value)
            is SettingsScreenAction.SetWindSpeedUnit -> setWindSpeedUnit(action.value)
            SettingsScreenAction.OpenPrivacyPolicy -> openPrivacyPolicy()
            is SettingsScreenAction.SetLiquidGlass -> setLiquidGlass(action.value)
        }
    }

    private fun openPrivacyPolicy() {
        viewModelScope.launch {
            openUrl(PRIVACY_POLICY_URL)
        }
    }

    private fun observeSettings() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLiquidGlassAvailable = isLiquidGlassAvailable()
                )
            }
        }
        settingsStorage.observeSettingsInfo().onEach { info ->
            info?.let { settings ->
                _state.update {
                    it.copy(
                        isTempC = settings.isTempC,
                        isPressureMb = settings.isPressureMb,
                        isWindKph = settings.isWindKph,
                        isLiquidGlassOn = settings.isLiquidGlassOn
                    )
                }
            }
        }.launchIn(viewModelScope)
    }


    private fun setLiquidGlass(value: Boolean) {
        viewModelScope.launch {
            val settings = SettingsInfo(
                isTempC = state.value.isTempC,
                isWindKph = state.value.isWindKph,
                isPressureMb = state.value.isPressureMb,
                isLiquidGlassOn = value
            )
            settingsStorage.set(settings)
            _state.update {
                it.copy(
                    isLiquidGlassOn = value
                )
            }
        }
    }

    private fun setTempUnit(value: Boolean) {
        viewModelScope.launch {
            val settings = SettingsInfo(
                isTempC = value,
                isWindKph = state.value.isWindKph,
                isPressureMb = state.value.isPressureMb,
                isLiquidGlassOn = state.value.isLiquidGlassOn
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
                isPressureMb = state.value.isPressureMb,
                isLiquidGlassOn = state.value.isLiquidGlassOn
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
                isPressureMb = value,
                isLiquidGlassOn = state.value.isLiquidGlassOn
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