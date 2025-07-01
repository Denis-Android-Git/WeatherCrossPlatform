package org.example.weathercrossplatform.`data`.database

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.EntityUpsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import javax.`annotation`.processing.Generated
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

@Generated(value = ["androidx.room.RoomProcessor"])
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
          "INSERT INTO `SavedWeatherItem` (`cityName`,`id`,`cityId`,`temperature`,`weatherDescription`,`highTemperature`,`lowTemperature`,`coordinates`) VALUES (?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: SavedWeatherItem) {
        statement.bindText(1, entity.cityName)
        statement.bindLong(2, entity.id.toLong())
        val _tmpCityId: Int? = entity.cityId
        if (_tmpCityId == null) {
          statement.bindNull(3)
        } else {
          statement.bindLong(3, _tmpCityId.toLong())
        }
        statement.bindDouble(4, entity.temperature)
        statement.bindText(5, entity.weatherDescription)
        statement.bindDouble(6, entity.highTemperature)
        statement.bindDouble(7, entity.lowTemperature)
        statement.bindText(8, entity.coordinates)
      }
    }, object : EntityDeleteOrUpdateAdapter<SavedWeatherItem>() {
      protected override fun createQuery(): String =
          "UPDATE `SavedWeatherItem` SET `cityName` = ?,`id` = ?,`cityId` = ?,`temperature` = ?,`weatherDescription` = ?,`highTemperature` = ?,`lowTemperature` = ?,`coordinates` = ? WHERE `cityName` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: SavedWeatherItem) {
        statement.bindText(1, entity.cityName)
        statement.bindLong(2, entity.id.toLong())
        val _tmpCityId: Int? = entity.cityId
        if (_tmpCityId == null) {
          statement.bindNull(3)
        } else {
          statement.bindLong(3, _tmpCityId.toLong())
        }
        statement.bindDouble(4, entity.temperature)
        statement.bindText(5, entity.weatherDescription)
        statement.bindDouble(6, entity.highTemperature)
        statement.bindDouble(7, entity.lowTemperature)
        statement.bindText(8, entity.coordinates)
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
    val _sql: String = "SELECT * FROM savedweatheritem"
    return createFlow(__db, false, arrayOf("savedweatheritem")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfCityName: Int = getColumnIndexOrThrow(_stmt, "cityName")
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfCityId: Int = getColumnIndexOrThrow(_stmt, "cityId")
        val _columnIndexOfTemperature: Int = getColumnIndexOrThrow(_stmt, "temperature")
        val _columnIndexOfWeatherDescription: Int = getColumnIndexOrThrow(_stmt,
            "weatherDescription")
        val _columnIndexOfHighTemperature: Int = getColumnIndexOrThrow(_stmt, "highTemperature")
        val _columnIndexOfLowTemperature: Int = getColumnIndexOrThrow(_stmt, "lowTemperature")
        val _columnIndexOfCoordinates: Int = getColumnIndexOrThrow(_stmt, "coordinates")
        val _result: MutableList<SavedWeatherItem> = mutableListOf()
        while (_stmt.step()) {
          val _item: SavedWeatherItem
          val _tmpCityName: String
          _tmpCityName = _stmt.getText(_columnIndexOfCityName)
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
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
          _item =
              SavedWeatherItem(_tmpCityName,_tmpId,_tmpCityId,_tmpTemperature,_tmpWeatherDescription,_tmpHighTemperature,_tmpLowTemperature,_tmpCoordinates)
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
