package org.example.weathercrossplatform.`data`.database

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.EntityUpsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import kotlin.Double
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
          "INSERT INTO `SavedWeatherItem` (`id`,`cityName`,`latitude`,`longitude`,`temperature`,`weatherDescription`,`highTemperature`,`lowTemperature`) VALUES (?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: SavedWeatherItem) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindText(2, entity.cityName)
        val _tmpLatitude: Double? = entity.latitude
        if (_tmpLatitude == null) {
          statement.bindNull(3)
        } else {
          statement.bindDouble(3, _tmpLatitude)
        }
        val _tmpLongitude: Double? = entity.longitude
        if (_tmpLongitude == null) {
          statement.bindNull(4)
        } else {
          statement.bindDouble(4, _tmpLongitude)
        }
        statement.bindDouble(5, entity.temperature)
        statement.bindText(6, entity.weatherDescription)
        statement.bindDouble(7, entity.highTemperature)
        statement.bindDouble(8, entity.lowTemperature)
      }
    }, object : EntityDeleteOrUpdateAdapter<SavedWeatherItem>() {
      protected override fun createQuery(): String =
          "UPDATE `SavedWeatherItem` SET `id` = ?,`cityName` = ?,`latitude` = ?,`longitude` = ?,`temperature` = ?,`weatherDescription` = ?,`highTemperature` = ?,`lowTemperature` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: SavedWeatherItem) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindText(2, entity.cityName)
        val _tmpLatitude: Double? = entity.latitude
        if (_tmpLatitude == null) {
          statement.bindNull(3)
        } else {
          statement.bindDouble(3, _tmpLatitude)
        }
        val _tmpLongitude: Double? = entity.longitude
        if (_tmpLongitude == null) {
          statement.bindNull(4)
        } else {
          statement.bindDouble(4, _tmpLongitude)
        }
        statement.bindDouble(5, entity.temperature)
        statement.bindText(6, entity.weatherDescription)
        statement.bindDouble(7, entity.highTemperature)
        statement.bindDouble(8, entity.lowTemperature)
        statement.bindLong(9, entity.id.toLong())
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

  public override fun getWeatherList(): Flow<List<SavedWeatherItem>> {
    val _sql: String = "SELECT * FROM savedweatheritem"
    return createFlow(__db, false, arrayOf("savedweatheritem")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfCityName: Int = getColumnIndexOrThrow(_stmt, "cityName")
        val _columnIndexOfLatitude: Int = getColumnIndexOrThrow(_stmt, "latitude")
        val _columnIndexOfLongitude: Int = getColumnIndexOrThrow(_stmt, "longitude")
        val _columnIndexOfTemperature: Int = getColumnIndexOrThrow(_stmt, "temperature")
        val _columnIndexOfWeatherDescription: Int = getColumnIndexOrThrow(_stmt,
            "weatherDescription")
        val _columnIndexOfHighTemperature: Int = getColumnIndexOrThrow(_stmt, "highTemperature")
        val _columnIndexOfLowTemperature: Int = getColumnIndexOrThrow(_stmt, "lowTemperature")
        val _result: MutableList<SavedWeatherItem> = mutableListOf()
        while (_stmt.step()) {
          val _item: SavedWeatherItem
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpCityName: String
          _tmpCityName = _stmt.getText(_columnIndexOfCityName)
          val _tmpLatitude: Double?
          if (_stmt.isNull(_columnIndexOfLatitude)) {
            _tmpLatitude = null
          } else {
            _tmpLatitude = _stmt.getDouble(_columnIndexOfLatitude)
          }
          val _tmpLongitude: Double?
          if (_stmt.isNull(_columnIndexOfLongitude)) {
            _tmpLongitude = null
          } else {
            _tmpLongitude = _stmt.getDouble(_columnIndexOfLongitude)
          }
          val _tmpTemperature: Double
          _tmpTemperature = _stmt.getDouble(_columnIndexOfTemperature)
          val _tmpWeatherDescription: String
          _tmpWeatherDescription = _stmt.getText(_columnIndexOfWeatherDescription)
          val _tmpHighTemperature: Double
          _tmpHighTemperature = _stmt.getDouble(_columnIndexOfHighTemperature)
          val _tmpLowTemperature: Double
          _tmpLowTemperature = _stmt.getDouble(_columnIndexOfLowTemperature)
          _item =
              SavedWeatherItem(_tmpId,_tmpCityName,_tmpLatitude,_tmpLongitude,_tmpTemperature,_tmpWeatherDescription,_tmpHighTemperature,_tmpLowTemperature)
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
