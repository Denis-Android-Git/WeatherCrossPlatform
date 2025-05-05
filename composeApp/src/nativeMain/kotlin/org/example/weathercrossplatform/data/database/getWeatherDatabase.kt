package org.example.weathercrossplatform.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): RoomDatabase.Builder<WeatherDataBase> {
    val dbFile = NSHomeDirectory() + "/weather.db"
    return Room.databaseBuilder<WeatherDataBase>(
        name = dbFile,
    )
}