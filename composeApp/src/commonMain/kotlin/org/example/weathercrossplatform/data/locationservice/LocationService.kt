package org.example.weathercrossplatform.data.locationservice

import kotlinx.coroutines.flow.Flow
import org.example.weathercrossplatform.domain.models.Coordinates

expect class LocationService {
    suspend fun getLocation(): Flow<Coordinates>
}