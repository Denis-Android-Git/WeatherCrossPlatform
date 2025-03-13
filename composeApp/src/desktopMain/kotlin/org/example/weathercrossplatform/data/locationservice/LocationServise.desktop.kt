package org.example.weathercrossplatform.data.locationservice

import kotlinx.coroutines.flow.Flow
import org.example.weathercrossplatform.domain.models.Coordinates

actual class LocationService {
    actual suspend fun getLocation(): Flow<Coordinates> {
        TODO("Not yet implemented")
    }
}