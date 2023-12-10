package com.imarneanu.mymeds.repository.medicine.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Medicine",
)
data class DbMedicine(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val quantity: String,
    val expirationDate: Long? = 0,
)
