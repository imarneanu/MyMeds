package com.imarneanu.mymeds.domain.source

import com.imarneanu.mymeds.domain.model.Medicine
import kotlinx.coroutines.flow.Flow

interface MedicineSource {

    suspend fun insertMedicine(medicine: Medicine)

    suspend fun deleteMedicine(medicine: Medicine)

    fun meds(): Flow<List<Medicine>>
}
