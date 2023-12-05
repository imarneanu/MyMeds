package com.imarneanu.mymeds.ui.meds

import com.imarneanu.mymeds.domain.model.Medicine

sealed interface MedsEvent{
    object SaveMedicine: MedsEvent
    data class SetName(val name: String): MedsEvent
    data class SetQuantity(val quantity: String): MedsEvent
    object ShowDialog: MedsEvent
    object HideDialog: MedsEvent
    data class DeleteMedicine(val medicine: Medicine): MedsEvent
}
