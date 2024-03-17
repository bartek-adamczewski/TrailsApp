package edu.put.jetpackcomposetrailsapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.put.jetpackcomposetrailsapp.database.entity.TrailEntity

@Database(entities = [TrailEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun trailDao(): TrailDao
}