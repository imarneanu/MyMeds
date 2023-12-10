package com.imarneanu.mymeds.ui.meds

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imarneanu.mymeds.domain.model.Medicine
import com.imarneanu.mymeds.domain.usecase.DeleteMedicine
import com.imarneanu.mymeds.domain.usecase.InsertMedicine
import com.imarneanu.mymeds.domain.usecase.QueryMedicine
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MedsViewModel(
    queryMeds: QueryMedicine,
    private val insertMedicine: InsertMedicine,
    private val deleteMedicine: DeleteMedicine,
) : ViewModel() {

    private val _meds =
        queryMeds().stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(MedsState())

    val state = combine(_state, _meds) { state, meds ->
        state.copy(
            meds = meds
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), MedsState())

    fun onEvent(event: MedsEvent) {
        when (event) {
            is MedsEvent.DeleteMedicine -> viewModelScope.launch { deleteMedicine(event.medicine) }
            MedsEvent.HideDialog -> _state.update { it.copy(showMedicineDialog = false) }
            MedsEvent.SaveMedicine -> {
                val id = state.value.medicineId
                val name = state.value.name
                val quantity = state.value.quantity
                val expirationDate = state.value.expirationDate

                if (name.isBlank()) return

                val medicine = Medicine(
                    id = id ?: 0,
                    name = name,
                    quantity = quantity ?: "1",
                    expirationDate = expirationDate,
                )

                viewModelScope.launch { insertMedicine(medicine) }
                _state.update {
                    it.copy(
                        showMedicineDialog = false,
                        name = "",
                        quantity = "",
                        expirationDate = 0,
                    )
                }
            }

            is MedsEvent.SetName -> _state.update { it.copy(name = event.name) }
            is MedsEvent.SetQuantity -> _state.update { it.copy(quantity = event.quantity) }
            is MedsEvent.SetExpirationDate -> _state.update {
                it.copy(
                    expirationDate = MedsUIMapper.toMilliseconds(
                        event.expirationDate
                    )
                )
            }

            is MedsEvent.ShowMedicineDialog -> _state.update {
                it.copy(
                    showMedicineDialog = true,
                    medicineId = event.medicine?.id,
                    name = event.medicine?.name ?: "",
                    quantity = event.medicine?.quantity,
                    expirationDate = event.medicine?.expirationDate ?: 0,
                )
            }
        }
    }
}
