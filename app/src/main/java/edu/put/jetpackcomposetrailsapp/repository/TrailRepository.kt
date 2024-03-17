package edu.put.jetpackcomposetrailsapp.repository

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.put.jetpackcomposetrailsapp.database.TrailDao
import edu.put.jetpackcomposetrailsapp.database.entity.TrailEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class TrailRepository @Inject constructor(
    private val trailDao: TrailDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) {
    suspend fun getTrails(): Flow<List<TrailEntity>> = withContext(ioDispatcher) {
        trailDao.getAllTrails()
    }

    suspend fun getTrail(id: Int): Flow<TrailEntity> = withContext(ioDispatcher) {
        trailDao.getTrailById(id)
    }

    suspend fun insertAll(trails: List<TrailEntity>) {
        trailDao.insertAll(*trails.toTypedArray())
    }

    suspend fun initializeDatabaseIfNeeded() {
        if (trailDao.countTrails() == 0) {
            initializeDatabaseFromJson()
        }
    }

    private suspend fun initializeDatabaseFromJson() {
        val jsonData = jsonData

        val gson = Gson()
        val listTrailType = object : TypeToken<List<TrailEntity>>() {}.type
        val trails: List<TrailEntity> = gson.fromJson(jsonData, listTrailType)
        Log.d("Database", trails[0].toString())
        trailDao.insertAll(*trails.toTypedArray())
    }
}