package com.imarneanu.startapp.ui.meds

import com.imarneanu.startapp.domain.model.Medicine

sealed interface MedsEvent{
    object SaveMedicine: MedsEvent
    data class SetName(val name: String): MedsEvent
    data class SetQuantity(val quantity: String): MedsEvent
    object ShowDialog: MedsEvent
    object HideDialog: MedsEvent
    data class DeleteMedicine(val medicine: Medicine): MedsEvent
}
