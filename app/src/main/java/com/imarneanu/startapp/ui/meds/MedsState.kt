package com.imarneanu.startapp.ui.meds

import com.imarneanu.startapp.domain.model.Medicine

data class MedsState(
    val meds: List<Medicine> = emptyList(),
    val name: String = "",
    val quantity: String = "",
    val isAddingMedicine: Boolean = false,
)
