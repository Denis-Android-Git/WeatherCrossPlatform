package org.example.weathercrossplatform.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<WeatherDataBase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("weather.db")
    return Room.databaseBuilder<WeatherDataBase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}