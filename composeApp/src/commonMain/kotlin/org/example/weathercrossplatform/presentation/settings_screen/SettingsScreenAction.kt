package org.example.weathercrossplatform.presentation.settings_screen

sealed interface SettingsScreenAction {
    data class SetTempUnit(val value: Boolean) : SettingsScreenAction
    data class SetWindSpeedUnit(val value: Boolean) : SettingsScreenAction
    data class SetPressureUnit(val value: Boolean) : SettingsScreenAction
    data class SetDropDownTempExpanded(val value: Boolean) : SettingsScreenAction
    data class SetDropDownWindExpanded(val value: Boolean) : SettingsScreenAction
    data class SetDropDownPressureExpanded(val value: Boolean) : SettingsScreenAction
}