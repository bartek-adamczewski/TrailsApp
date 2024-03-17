package edu.put.jetpackcomposetrailsapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import edu.put.jetpackcomposetrailsapp.database.entity.TrailEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TrailDao {
    @Query("SELECT * FROM TrailEntity")
    fun getAllTrails(): Flow<List<TrailEntity>>

    @Query("SELECT * FROM TrailEntity WHERE id = :id")
    fun getTrailById(id: Int): Flow<TrailEntity>

    @Insert
    suspend fun insertAll(vararg trails: TrailEntity)

    @Query("SELECT COUNT(*) FROM TrailEntity")
    suspend fun countTrails(): Int

}