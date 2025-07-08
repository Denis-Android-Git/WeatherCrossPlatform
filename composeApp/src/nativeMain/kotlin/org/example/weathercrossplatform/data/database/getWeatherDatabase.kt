package org.example.weathercrossplatform.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory
import platform.Foundation.*


//fun getDatabaseBuilder(): RoomDatabase.Builder<WeatherDataBase> {
//    val dbFile = NSHomeDirectory() + "/weather.db"
//    return Room.databaseBuilder<WeatherDataBase>(
//        name = dbFile,
//    )
//}

fun getDatabaseBuilder(): RoomDatabase.Builder<WeatherDataBase> {
    val paths = NSSearchPathForDirectoriesInDomains(
        directory = NSDocumentDirectory,
        domainMask = NSUserDomainMask,
        expandTilde = true
    )
    val documentsDirectory = paths.firstOrNull() as? String
        ?: throw IllegalStateException("Unable to find documents directory")

    val dbFile = "$documentsDirectory/weather.db"

    return Room.databaseBuilder<WeatherDataBase>(
        name = dbFile
    )
}

