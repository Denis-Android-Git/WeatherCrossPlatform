package org.example.weathercrossplatform.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

@Database(
    entities = [SavedWeatherItem::class, SearchedWeatherItem::class],
    version = 14
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class WeatherDataBase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
    abstract fun searchedDao(): SearchedDao

    companion object {
        const val DB_NAME = "weather.db"
    }
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<WeatherDataBase> {
    override fun initialize(): WeatherDataBase
}