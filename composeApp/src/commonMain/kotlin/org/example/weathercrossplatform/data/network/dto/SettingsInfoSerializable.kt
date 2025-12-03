package org.example.weathercrossplatform.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class SettingsInfoSerializable(
    val isTempC: Boolean,
    val isWindKph: Boolean,
    val isPressureMb: Boolean
)
