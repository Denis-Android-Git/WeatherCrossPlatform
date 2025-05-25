package org.example.weathercrossplatform.`data`.database

import androidx.room.InvalidationTracker
import androidx.room.RoomOpenDelegate
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.MutableSet
import kotlin.collections.Set
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.mutableSetOf
import kotlin.reflect.KClass

@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class WeatherDataBase_Impl : WeatherDataBase() {
  private val _weatherDao: Lazy<WeatherDao> = lazy {
    WeatherDao_Impl(this)
  }

  protected override fun createOpenDelegate(): RoomOpenDelegate {
    val _openDelegate: RoomOpenDelegate = object : RoomOpenDelegate(4,
        "efe523ea65d91f1cc2b52b38485f8a53", "2145c522fc0581e14d2b8d1f9fd9e986") {
      public override fun createAllTables(connection: SQLiteConnection) {
        connection.execSQL("CREATE TABLE IF NOT EXISTS `SavedWeatherItem` (`id` INTEGER NOT NULL, `cityName` TEXT NOT NULL, `latitude` REAL, `longitude` REAL, `temperature` REAL NOT NULL, `weatherDescription` TEXT NOT NULL, `highTemperature` REAL NOT NULL, `lowTemperature` REAL NOT NULL, PRIMARY KEY(`id`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        connection.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'efe523ea65d91f1cc2b52b38485f8a53')")
      }

      public override fun dropAllTables(connection: SQLiteConnection) {
        connection.execSQL("DROP TABLE IF EXISTS `SavedWeatherItem`")
      }

      public override fun onCreate(connection: SQLiteConnection) {
      }

      public override fun onOpen(connection: SQLiteConnection) {
        internalInitInvalidationTracker(connection)
      }

      public override fun onPreMigrate(connection: SQLiteConnection) {
        dropFtsSyncTriggers(connection)
      }

      public override fun onPostMigrate(connection: SQLiteConnection) {
      }

      public override fun onValidateSchema(connection: SQLiteConnection):
          RoomOpenDelegate.ValidationResult {
        val _columnsSavedWeatherItem: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsSavedWeatherItem.put("id", TableInfo.Column("id", "INTEGER", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsSavedWeatherItem.put("cityName", TableInfo.Column("cityName", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsSavedWeatherItem.put("latitude", TableInfo.Column("latitude", "REAL", false, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsSavedWeatherItem.put("longitude", TableInfo.Column("longitude", "REAL", false, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsSavedWeatherItem.put("temperature", TableInfo.Column("temperature", "REAL", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsSavedWeatherItem.put("weatherDescription", TableInfo.Column("weatherDescription",
            "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsSavedWeatherItem.put("highTemperature", TableInfo.Column("highTemperature", "REAL",
            true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsSavedWeatherItem.put("lowTemperature", TableInfo.Column("lowTemperature", "REAL",
            true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysSavedWeatherItem: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesSavedWeatherItem: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoSavedWeatherItem: TableInfo = TableInfo("SavedWeatherItem",
            _columnsSavedWeatherItem, _foreignKeysSavedWeatherItem, _indicesSavedWeatherItem)
        val _existingSavedWeatherItem: TableInfo = read(connection, "SavedWeatherItem")
        if (!_infoSavedWeatherItem.equals(_existingSavedWeatherItem)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |SavedWeatherItem(org.example.weathercrossplatform.data.database.SavedWeatherItem).
              | Expected:
              |""".trimMargin() + _infoSavedWeatherItem + """
              |
              | Found:
              |""".trimMargin() + _existingSavedWeatherItem)
        }
        return RoomOpenDelegate.ValidationResult(true, null)
      }
    }
    return _openDelegate
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: MutableMap<String, String> = mutableMapOf()
    val _viewTables: MutableMap<String, Set<String>> = mutableMapOf()
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "SavedWeatherItem")
  }

  protected override fun getRequiredTypeConverterClasses(): Map<KClass<*>, List<KClass<*>>> {
    val _typeConvertersMap: MutableMap<KClass<*>, List<KClass<*>>> = mutableMapOf()
    _typeConvertersMap.put(WeatherDao::class, WeatherDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecClasses(): Set<KClass<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: MutableSet<KClass<out AutoMigrationSpec>> = mutableSetOf()
    return _autoMigrationSpecsSet
  }

  public override
      fun createAutoMigrations(autoMigrationSpecs: Map<KClass<out AutoMigrationSpec>, AutoMigrationSpec>):
      List<Migration> {
    val _autoMigrations: MutableList<Migration> = mutableListOf()
    return _autoMigrations
  }

  public override fun weatherDao(): WeatherDao = _weatherDao.value
}
