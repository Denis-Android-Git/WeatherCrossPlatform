package org.example.weathercrossplatform.domain.repo

import kotlinx.coroutines.flow.Flow
import org.example.weathercrossplatform.domain.models.SettingsInfo

interface SettingsStorage {
    fun observeSettingsInfo(): Flow<SettingsInfo?>
    suspend fun set(info: SettingsInfo?)
}