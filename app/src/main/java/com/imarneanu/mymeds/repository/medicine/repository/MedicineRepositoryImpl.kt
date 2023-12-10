package com.imarneanu.mymeds.repository.medicine.repository

import com.imarneanu.mymeds.repository.medicine.database.DbMedicine
import com.imarneanu.mymeds.repository.medicine.database.MedicineDao
import kotlinx.coroutines.flow.Flow

class MedicineRepositoryImpl(private val medicineDao: MedicineDao) : MedicineRepository {

    override suspend fun insertMedicine(dbMedicine: DbMedicine) =
        medicineDao.insertOrUpdate(dbMedicine)

    override suspend fun deleteMedicine(dbMedicine: DbMedicine) = medicineDao.delete(dbMedicine.id)

    override fun meds(): Flow<List<DbMedicine>> = medicineDao.getAll()
}
