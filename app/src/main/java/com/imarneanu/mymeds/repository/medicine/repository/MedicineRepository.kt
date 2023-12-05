package com.imarneanu.mymeds.repository.medicine.repository

import com.imarneanu.mymeds.repository.medicine.database.DbMedicine
import kotlinx.coroutines.flow.Flow

interface MedicineRepository {

    suspend fun insertMedicine(dbMedicine: DbMedicine)

    suspend fun deleteMedicine(dbMedicine: DbMedicine)

    fun meds(): Flow<List<DbMedicine>>
}
