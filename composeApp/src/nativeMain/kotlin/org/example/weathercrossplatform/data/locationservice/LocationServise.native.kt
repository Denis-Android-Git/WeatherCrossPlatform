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

actual class LocationService {

    private val locationManager = CLLocationManager()
    private var delegateWrapper: LocationDelegateWrapper? = null

    init {
        locationManager.desiredAccuracy = kCLLocationAccuracyBest
    }

    @OptIn(ExperimentalForeignApi::class)
    actual suspend fun getLocation(): Flow<Coordinates> = callbackFlow {
        println("Requesting location...")
        val delegate = LocationDelegateWrapper { coordinates, error ->
            if (coordinates != null) {
                trySend(coordinates)
            }
            if (error != null) {
                close(error)
            }
        }

        delegateWrapper = delegate
        locationManager.delegate = delegateWrapper
        locationManager.requestLocation()

        awaitClose {
            println("Closing location flow")
            locationManager.delegate = null
            delegateWrapper = null
        }
    }

    private class LocationDelegateWrapper(
        private val onLocationReceived: (Coordinates?, Throwable?) -> Unit
    ) : NSObject(), CLLocationManagerDelegateProtocol {

        @OptIn(ExperimentalForeignApi::class)
        override fun locationManager(manager: CLLocationManager, didUpdateLocations: List<*>) {
            val location = didUpdateLocations.lastOrNull() as? CLLocation
            println("Location updated: $location")
            location?.coordinate?.useContents {
                val coords = Coordinates(this.latitude, this.longitude)
                println("Latitude: ${coords.latitude}, Longitude: ${coords.longitude}")
                onLocationReceived(coords, null)
            }
        }

        override fun locationManager(manager: CLLocationManager, didFailWithError: NSError) {
            println("Location failed with error: ${didFailWithError.localizedDescription}")
            onLocationReceived(
                null,
                Exception("Location error: ${didFailWithError.localizedDescription}")
            )
        }
    }
}