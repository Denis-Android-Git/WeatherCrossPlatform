package org.example.weathercrossplatform.`data`.database

import androidx.room.RoomDatabaseConstructor

public actual object AppDatabaseConstructor : RoomDatabaseConstructor<WeatherDataBase> {
  actual override fun initialize(): WeatherDataBase =
      org.example.weathercrossplatform.`data`.database.WeatherDataBase_Impl()
}
