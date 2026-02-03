package org.example.weathercrossplatform.data.database

import androidx.room.RoomDatabase

expect class DbFactory {
    fun create(): RoomDatabase.Builder<WeatherDataBase>
}