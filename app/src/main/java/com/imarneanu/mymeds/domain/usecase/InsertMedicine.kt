package com.imarneanu.mymeds.domain.usecase

import com.imarneanu.mymeds.core.usecase.CommandUseCase1
import com.imarneanu.mymeds.domain.model.Medicine
import com.imarneanu.mymeds.domain.source.MedicineSource

@Suppress("parameter_name_changed_on_override")
class InsertMedicine(private val medicineSource: MedicineSource): CommandUseCase1<Medicine> {
    override suspend fun invoke(medicine: Medicine) = medicineSource.insertMedicine(medicine)
}
