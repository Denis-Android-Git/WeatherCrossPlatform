package org.example.weathercrossplatform.`data`.database

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.EntityUpsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class WeatherDao_Impl(
  __db: RoomDatabase,
) : WeatherDao {
  private val __db: RoomDatabase

  private val __deleteAdapterOfSavedWeatherItem: EntityDeleteOrUpdateAdapter<SavedWeatherItem>

  private val __upsertAdapterOfSavedWeatherItem: EntityUpsertAdapter<SavedWeatherItem>
  init {
    this.__db = __db
    this.__deleteAdapterOfSavedWeatherItem = object :
        EntityDeleteOrUpdateAdapter<SavedWeatherItem>() {
      protected override fun createQuery(): String = "DELETE FROM `SavedWeatherItem` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: SavedWeatherItem) {
        statement.bindLong(1, entity.id.toLong())
      }
    }
    this.__upsertAdapterOfSavedWeatherItem = EntityUpsertAdapter<SavedWeatherItem>(object :
        EntityInsertAdapter<SavedWeatherItem>() {
      protected override fun createQuery(): String =
          "INSERT INTO `SavedWeatherItem` (`id`,`cityName`) VALUES (nullif(?, 0),?)"

      protected override fun bind(statement: SQLiteStatement, entity: SavedWeatherItem) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindText(2, entity.cityName)
      }
    }, object : EntityDeleteOrUpdateAdapter<SavedWeatherItem>() {
      protected override fun createQuery(): String =
          "UPDATE `SavedWeatherItem` SET `id` = ?,`cityName` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: SavedWeatherItem) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindText(2, entity.cityName)
        statement.bindLong(3, entity.id.toLong())
      }
    })
  }

  public override suspend fun deleteWeather(weather: SavedWeatherItem): Unit =
      performSuspending(__db, false, true) { _connection ->
    __deleteAdapterOfSavedWeatherItem.handle(_connection, weather)
  }

  public override suspend fun upsertWeather(weather: SavedWeatherItem): Unit =
      performSuspending(__db, false, true) { _connection ->
    __upsertAdapterOfSavedWeatherItem.upsert(_connection, weather)
  }

  public override fun getWeather(): Flow<List<SavedWeatherItem>> {
    val _sql: String = "SELECT * FROM savedweatheritem"
    return createFlow(__db, false, arrayOf("savedweatheritem")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfCityName: Int = getColumnIndexOrThrow(_stmt, "cityName")
        val _result: MutableList<SavedWeatherItem> = mutableListOf()
        while (_stmt.step()) {
          val _item: SavedWeatherItem
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpCityName: String
          _tmpCityName = _stmt.getText(_columnIndexOfCityName)
          _item = SavedWeatherItem(_tmpId,_tmpCityName)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
