package org.example.weathercrossplatform.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(
    entities = [SavedWeatherItem::class],
    version = 3
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class WeatherDataBase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<WeatherDataBase> {
    override fun initialize(): WeatherDataBase
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<WeatherDataBase>
): WeatherDataBase {
    return builder
        //.addMigrations(MIGRATIONS)
        //.fallbackToDestructiveMigrationOnDowngrade()
        .setDriver(BundledSQLiteDriver())
        .fallbackToDestructiveMigration(
            dropAllTables = true
        )
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}