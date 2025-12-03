package org.example.weathercrossplatform.data.repo_impl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json
import org.example.weathercrossplatform.data.mappers.toDomain
import org.example.weathercrossplatform.data.mappers.toSerializable
import org.example.weathercrossplatform.data.network.dto.SettingsInfoSerializable
import org.example.weathercrossplatform.domain.models.SettingsInfo
import org.example.weathercrossplatform.domain.repo.SettingsStorage

class DataStoreSettingsStorage(
    private val dataStore: DataStore<Preferences>,
) : SettingsStorage {
    private val json = Json {
        ignoreUnknownKeys = true
    }
    private val key = stringPreferencesKey("KEY_INFO")
    override fun observeSettingsInfo(): Flow<SettingsInfo?> {
        return dataStore.data.map { prefs ->
            prefs[key]?.let {
                val infoSerializable: SettingsInfoSerializable = json.decodeFromString(it)
                infoSerializable.toDomain()
            }
        }
    }

    override suspend fun set(info: SettingsInfo?) {
        if (info == null) {
            dataStore.edit {
                it.remove(key)
            }
            return
        }
        val serialized = json.encodeToString(info.toSerializable())
        dataStore.edit {
            it[key] = serialized
        }
    }
}