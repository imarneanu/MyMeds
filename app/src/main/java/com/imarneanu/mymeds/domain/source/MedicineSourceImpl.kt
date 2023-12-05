package com.imarneanu.mymeds.domain.source

import com.imarneanu.mymeds.domain.model.Medicine
import com.imarneanu.mymeds.repository.medicine.repository.MedicineRepository
import com.imarneanu.mymeds.repository.mapper.MedicineMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MedicineSourceImpl(
    private val medicineRepository: MedicineRepository,
    private val medicineMapper: MedicineMapper,
) : MedicineSource {

    private val meds = medicineRepository.meds().map(medicineMapper::toMeds)

    override suspend fun insertMedicine(medicine: Medicine) =
        medicineRepository.insertMedicine(medicineMapper.toDbMedicine(medicine))

    override suspend fun deleteMedicine(medicine: Medicine) =
        medicineRepository.deleteMedicine(medicineMapper.toDbMedicine(medicine))

    override fun meds(): Flow<List<Medicine>> = meds
}
