package com.imarneanu.mymeds.repository.medicine.di

import com.imarneanu.mymeds.domain.source.MedicineSource
import com.imarneanu.mymeds.domain.source.MedicineSourceImpl
import com.imarneanu.mymeds.domain.usecase.DeleteMedicine
import com.imarneanu.mymeds.domain.usecase.InsertMedicine
import com.imarneanu.mymeds.domain.usecase.QueryMedicine
import com.imarneanu.mymeds.repository.database.MyMedsDatabase
import com.imarneanu.mymeds.repository.medicine.repository.MedicineRepository
import com.imarneanu.mymeds.repository.medicine.repository.MedicineRepositoryImpl
import com.imarneanu.mymeds.repository.mapper.MedicineMapper
import com.imarneanu.mymeds.repository.mapper.MedicineMapperImpl
import org.koin.dsl.module

val medicineLibModule = module {
    single { get<MyMedsDatabase>().medicineDao() }

    single<MedicineMapper> { MedicineMapperImpl() }
    single<MedicineRepository> { MedicineRepositoryImpl(get()) }
    single<MedicineSource> { MedicineSourceImpl(get(), get()) }

    single { DeleteMedicine(get()) }
    single { InsertMedicine(get()) }
    single { QueryMedicine(get()) }
}
