package org.example.weathercrossplatform.data.locationservice

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import org.example.weathercrossplatform.domain.models.Coordinates
import platform.CoreLocation.CLLocation
import platform.CoreLocation.CLLocationManager
import platform.CoreLocation.CLLocationManagerDelegateProtocol
import platform.CoreLocation.kCLLocationAccuracyBest
import platform.Foundation.NSError
import platform.darwin.NSObject

actual class LocationService : NSObject(), CLLocationManagerDelegateProtocol {
    private val locationManager = CLLocationManager()

    init {
        locationManager.delegate = this
        locationManager.desiredAccuracy = kCLLocationAccuracyBest
    }

    @OptIn(ExperimentalForeignApi::class)
    actual suspend fun getLocation(): Flow<Coordinates> = callbackFlow {
        locationManager.requestWhenInUseAuthorization()

        val delegate = object : NSObject(), CLLocationManagerDelegateProtocol {
            override fun locationManager(manager: CLLocationManager, didUpdateLocations: List<*>) {
                val location = didUpdateLocations.lastOrNull() as? CLLocation
                location?.coordinate?.useContents {
                    trySend(Coordinates(this.latitude, this.longitude))
                }
            }

            override fun locationManager(manager: CLLocationManager, didFailWithError: NSError) {
                close(Exception("Failed to get location: ${didFailWithError.localizedDescription}"))
            }
        }
        locationManager.delegate = delegate
        locationManager.requestLocation()
        awaitClose { locationManager.delegate = null }
    }
}