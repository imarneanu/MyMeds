package com.imarneanu.mymeds.domain.usecase

import com.imarneanu.mymeds.core.usecase.QueryUseCase
import com.imarneanu.mymeds.domain.model.Medicine
import com.imarneanu.mymeds.domain.source.MedicineSource
import kotlinx.coroutines.flow.Flow

class QueryMedicine(private val medicineSource: MedicineSource): QueryUseCase<List<Medicine>> {
    override fun invoke(): Flow<List<Medicine>> = medicineSource.meds()
}
