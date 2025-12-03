package org.example.weathercrossplatform.presentation.settings_screen

sealed interface SettingsScreenAction {
    data object SetTempUnit : SettingsScreenAction
    data object SetWindSpeedUnit : SettingsScreenAction
    data object SetPressureUnit : SettingsScreenAction
    data class SetDropDownTempExpanded(val value: Boolean) : SettingsScreenAction
    data class SetDropDownWindExpanded(val value: Boolean) : SettingsScreenAction
    data class SetDropDownPressureExpanded(val value: Boolean) : SettingsScreenAction
}