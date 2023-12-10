package com.imarneanu.mymeds.ui.meds

import com.imarneanu.mymeds.domain.model.Medicine
import java.time.LocalDate

sealed interface MedsEvent{
    object SaveMedicine: MedsEvent
    data class SetName(val name: String): MedsEvent
    data class SetQuantity(val quantity: String?): MedsEvent
    data class SetExpirationDate(val expirationDate: LocalDate): MedsEvent
    data class ShowMedicineDialog(val medicine: Medicine? = null): MedsEvent
    object HideDialog: MedsEvent
    data class DeleteMedicine(val medicine: Medicine): MedsEvent
}
