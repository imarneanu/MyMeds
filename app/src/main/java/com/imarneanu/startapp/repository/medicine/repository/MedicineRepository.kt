package com.imarneanu.startapp.repository.medicine.repository

import com.imarneanu.startapp.repository.medicine.database.DbMedicine
import kotlinx.coroutines.flow.Flow

interface MedicineRepository {

    suspend fun insertMedicine(dbMedicine: DbMedicine)

    suspend fun deleteMedicine(dbMedicine: DbMedicine)

    fun meds(): Flow<List<DbMedicine>>
}
