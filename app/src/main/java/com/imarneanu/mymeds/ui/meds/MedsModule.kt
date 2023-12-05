package com.imarneanu.mymeds.ui.meds

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val medsModule = module {
    viewModel {
        MedsViewModel(
            queryMeds = get(),
            insertMedicine = get(),
            deleteMedicine = get(),
        )
    }
}
