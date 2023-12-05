package com.imarneanu.mymeds

import android.app.Application
import com.imarneanu.mymeds.repository.database.databaseModule
import com.imarneanu.mymeds.repository.medicine.di.medicineLibModule
import com.imarneanu.mymeds.ui.meds.medsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                databaseModule,
                medicineLibModule,
                medsModule,
            )
        }
    }
}
