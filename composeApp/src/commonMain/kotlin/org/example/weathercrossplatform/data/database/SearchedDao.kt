package org.example.weathercrossplatform.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchedDao {
    @Upsert
    suspend fun upsertItem(item: SearchedWeatherItem)

    @Query("DELETE FROM searchedweatheritem WHERE cityId = :id")
    suspend fun deleteCityById(id: Int)

    @Query("SELECT * FROM searchedweatheritem ORDER BY timeStamp DESC")
    fun getAllItems(): Flow<List<SearchedWeatherItem>>
}