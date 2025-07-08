package org.example.weathercrossplatform.`data`.database

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.EntityUpsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import kotlin.Boolean
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
      protected override fun createQuery(): String =
          "DELETE FROM `SavedWeatherItem` WHERE `cityName` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: SavedWeatherItem) {
        statement.bindText(1, entity.cityName)
      }
    }
    this.__upsertAdapterOfSavedWeatherItem = EntityUpsertAdapter<SavedWeatherItem>(object :
        EntityInsertAdapter<SavedWeatherItem>() {
      protected override fun createQuery(): String =
          "INSERT INTO `SavedWeatherItem` (`cityName`,`cityId`,`temperature`,`weatherDescription`,`highTemperature`,`lowTemperature`,`coordinates`,`isCurrentLocation`) VALUES (?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: SavedWeatherItem) {
        statement.bindText(1, entity.cityName)
        val _tmpCityId: Int? = entity.cityId
        if (_tmpCityId == null) {
          statement.bindNull(2)
        } else {
          statement.bindLong(2, _tmpCityId.toLong())
        }
        statement.bindDouble(3, entity.temperature)
        statement.bindText(4, entity.weatherDescription)
        statement.bindDouble(5, entity.highTemperature)
        statement.bindDouble(6, entity.lowTemperature)
        statement.bindText(7, entity.coordinates)
        val _tmp: Int = if (entity.isCurrentLocation) 1 else 0
        statement.bindLong(8, _tmp.toLong())
      }
    }, object : EntityDeleteOrUpdateAdapter<SavedWeatherItem>() {
      protected override fun createQuery(): String =
          "UPDATE `SavedWeatherItem` SET `cityName` = ?,`cityId` = ?,`temperature` = ?,`weatherDescription` = ?,`highTemperature` = ?,`lowTemperature` = ?,`coordinates` = ?,`isCurrentLocation` = ? WHERE `cityName` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: SavedWeatherItem) {
        statement.bindText(1, entity.cityName)
        val _tmpCityId: Int? = entity.cityId
        if (_tmpCityId == null) {
          statement.bindNull(2)
        } else {
          statement.bindLong(2, _tmpCityId.toLong())
        }
        statement.bindDouble(3, entity.temperature)
        statement.bindText(4, entity.weatherDescription)
        statement.bindDouble(5, entity.highTemperature)
        statement.bindDouble(6, entity.lowTemperature)
        statement.bindText(7, entity.coordinates)
        val _tmp: Int = if (entity.isCurrentLocation) 1 else 0
        statement.bindLong(8, _tmp.toLong())
        statement.bindText(9, entity.cityName)
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
    val _sql: String = "SELECT * FROM savedweatheritem ORDER BY isCurrentLocation DESC"
    return createFlow(__db, false, arrayOf("savedweatheritem")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfCityName: Int = getColumnIndexOrThrow(_stmt, "cityName")
        val _columnIndexOfCityId: Int = getColumnIndexOrThrow(_stmt, "cityId")
        val _columnIndexOfTemperature: Int = getColumnIndexOrThrow(_stmt, "temperature")
        val _columnIndexOfWeatherDescription: Int = getColumnIndexOrThrow(_stmt,
            "weatherDescription")
        val _columnIndexOfHighTemperature: Int = getColumnIndexOrThrow(_stmt, "highTemperature")
        val _columnIndexOfLowTemperature: Int = getColumnIndexOrThrow(_stmt, "lowTemperature")
        val _columnIndexOfCoordinates: Int = getColumnIndexOrThrow(_stmt, "coordinates")
        val _columnIndexOfIsCurrentLocation: Int = getColumnIndexOrThrow(_stmt, "isCurrentLocation")
        val _result: MutableList<SavedWeatherItem> = mutableListOf()
        while (_stmt.step()) {
          val _item: SavedWeatherItem
          val _tmpCityName: String
          _tmpCityName = _stmt.getText(_columnIndexOfCityName)
          val _tmpCityId: Int?
          if (_stmt.isNull(_columnIndexOfCityId)) {
            _tmpCityId = null
          } else {
            _tmpCityId = _stmt.getLong(_columnIndexOfCityId).toInt()
          }
          val _tmpTemperature: Double
          _tmpTemperature = _stmt.getDouble(_columnIndexOfTemperature)
          val _tmpWeatherDescription: String
          _tmpWeatherDescription = _stmt.getText(_columnIndexOfWeatherDescription)
          val _tmpHighTemperature: Double
          _tmpHighTemperature = _stmt.getDouble(_columnIndexOfHighTemperature)
          val _tmpLowTemperature: Double
          _tmpLowTemperature = _stmt.getDouble(_columnIndexOfLowTemperature)
          val _tmpCoordinates: String
          _tmpCoordinates = _stmt.getText(_columnIndexOfCoordinates)
          val _tmpIsCurrentLocation: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsCurrentLocation).toInt()
          _tmpIsCurrentLocation = _tmp != 0
          _item =
              SavedWeatherItem(_tmpCityName,_tmpCityId,_tmpTemperature,_tmpWeatherDescription,_tmpHighTemperature,_tmpLowTemperature,_tmpCoordinates,_tmpIsCurrentLocation)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun clearCurrentLocation() {
    val _sql: String =
        "UPDATE savedweatheritem SET isCurrentLocation = 0 WHERE isCurrentLocation = 1"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
