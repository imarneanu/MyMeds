package com.imarneanu.mymeds.repository.mapper

import com.imarneanu.mymeds.domain.model.Medicine
import com.imarneanu.mymeds.repository.medicine.database.DbMedicine

interface MedicineMapper {

    fun toMeds(dbMedicines: List<DbMedicine>): List<Medicine>

    fun toDbMedicine(medicine: Medicine): DbMedicine
}
