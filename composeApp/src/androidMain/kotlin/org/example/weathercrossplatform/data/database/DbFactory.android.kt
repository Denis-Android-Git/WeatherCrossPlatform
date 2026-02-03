package org.example.weathercrossplatform.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

actual class DbFactory(
    private val ctx: Context
) {
    actual fun create(): RoomDatabase.Builder<WeatherDataBase> {
        val appContext = ctx.applicationContext
        val dbFile = appContext.getDatabasePath(WeatherDataBase.DB_NAME)
        return Room.databaseBuilder<WeatherDataBase>(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}