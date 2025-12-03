package org.example.weathercrossplatform.data.mappers

import org.example.weathercrossplatform.data.network.dto.SettingsInfoSerializable
import org.example.weathercrossplatform.domain.models.SettingsInfo

fun SettingsInfo.toSerializable(): SettingsInfoSerializable {
    return SettingsInfoSerializable(
        isTempC = isTempC,
        isWindKph = isWindKph,
        isPressureMb = isPressureMb
    )
}

fun SettingsInfoSerializable.toDomain(): SettingsInfo {
    return SettingsInfo(
        isTempC = isTempC,
        isWindKph = isWindKph,
        isPressureMb = isPressureMb
    )
}