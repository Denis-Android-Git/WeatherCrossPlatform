package org.example.weathercrossplatform.data.lifecycleObserver

import kotlinx.coroutines.flow.Flow

expect class LifeCycleObserver {
    val isInForeGround: Flow<Boolean>
}