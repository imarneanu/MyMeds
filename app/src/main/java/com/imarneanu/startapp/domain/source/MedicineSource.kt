package com.imarneanu.startapp.domain.source

import com.imarneanu.startapp.domain.model.Medicine
import kotlinx.coroutines.flow.Flow

interface MedicineSource {

    suspend fun insertMedicine(medicine: Medicine)

    suspend fun deleteMedicine(medicine: Medicine)

    fun meds(): Flow<List<Medicine>>
}
