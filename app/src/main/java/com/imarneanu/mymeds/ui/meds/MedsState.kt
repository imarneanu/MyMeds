package com.imarneanu.mymeds.ui.meds

import com.imarneanu.mymeds.domain.model.Medicine

data class MedsState(
    val meds: List<Medicine> = emptyList(),
    val name: String = "",
    val quantity: String = "",
    val isAddingMedicine: Boolean = false,
)
