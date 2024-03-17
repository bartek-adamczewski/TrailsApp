package edu.put.jetpackcomposetrailsapp.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TrailEntity(
    @PrimaryKey(autoGenerate = false) val id: Int = 0,
    val name: String = "",
    val location: String = "",
    val shortDescription: String = "",
    val longDescription: String = "",
    val walkTime: Int = 0,
    val imageId: Int = 0
)
