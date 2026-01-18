package org.example.weathercrossplatform.presentation.settings_screen

import org.jetbrains.compose.resources.StringResource
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.celc
import weathercrossplatform.composeapp.generated.resources.far
import weathercrossplatform.composeapp.generated.resources.inrt
import weathercrossplatform.composeapp.generated.resources.kmh
import weathercrossplatform.composeapp.generated.resources.mmrt
import weathercrossplatform.composeapp.generated.resources.mph

data class SettingsScreenState(
    val isTempC: Boolean = true,
    val isWindKph: Boolean = true,
    val isPressureMb: Boolean = true,
    val isDropTempExpanded: Boolean = false,
    val isDropWindExpanded: Boolean = false,
    val isDropPressureExpanded: Boolean = false,
    val temperatureList: List<StringResource> = listOf(Res.string.celc, Res.string.far),
    val windList: List<StringResource> = listOf(Res.string.kmh, Res.string.mph),
    val pressureList: List<StringResource> = listOf(Res.string.mmrt, Res.string.inrt),
    val isLiquidGlassAvailable: Boolean = false,
    val isLiquidGlassOn: Boolean = false
)