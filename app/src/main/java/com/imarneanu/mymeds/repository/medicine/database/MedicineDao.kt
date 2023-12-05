package com.imarneanu.mymeds.repository.medicine.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicineDao {

    @Upsert
    suspend fun insertOrUpdate(dbMedicine: DbMedicine)

    @Transaction
    @Query("SELECT * FROM Medicine")
    fun getAll(): Flow<List<DbMedicine>>

    @Query("DELETE FROM Medicine WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("DELETE FROM Medicine")
    suspend fun deleteAll()
}
