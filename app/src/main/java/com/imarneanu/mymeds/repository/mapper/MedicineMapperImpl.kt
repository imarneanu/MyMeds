package com.imarneanu.mymeds.repository.mapper

import com.imarneanu.mymeds.domain.model.Medicine
import com.imarneanu.mymeds.repository.medicine.database.DbMedicine
import com.imarneanu.mymeds.ui.meds.MedsUIMapper

class MedicineMapperImpl : MedicineMapper {

    override fun toMeds(dbMedicines: List<DbMedicine>): List<Medicine> =
        dbMedicines.map(::toMedicine)

    override fun toDbMedicine(medicine: Medicine): DbMedicine = with(medicine) {
        DbMedicine(
            id = id,
            name = name,
            quantity = quantity,
            expirationDate = expirationDate,
        )
    }

    private fun toMedicine(dbMedicine: DbMedicine) = with(dbMedicine) {
        Medicine(
            id = id,
            name = name,
            quantity = quantity,
            expirationDate = expirationDate ?: 0,
            isExpired = expirationDate?.let { 0 < expirationDate && expirationDate < MedsUIMapper.now } ?: false,
        )
    }
}
