package com.imarneanu.mymeds.domain.usecase

import com.imarneanu.mymeds.core.usecase.QueryUseCase
import com.imarneanu.mymeds.domain.model.Medicine
import com.imarneanu.mymeds.domain.source.MedicineSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QueryMedicine(private val medicineSource: MedicineSource) : QueryUseCase<List<Medicine>> {
    override fun invoke(): Flow<List<Medicine>> =
        medicineSource.meds()
            .map { meds ->
                meds.sortedWith(
                    compareBy(
                        { it.name.lowercase() },
                        Medicine::expirationDate
                    )
                )
            }
}
