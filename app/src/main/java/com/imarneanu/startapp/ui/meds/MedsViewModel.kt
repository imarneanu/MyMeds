package com.imarneanu.startapp.ui.meds

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imarneanu.startapp.domain.model.Medicine
import com.imarneanu.startapp.domain.usecase.InsertMedicine
import com.imarneanu.startapp.domain.usecase.QueryMedicine
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MedsViewModel(
    queryMeds: QueryMedicine,
    private val insertMedicine: InsertMedicine,
    private val deleteMedicine: InsertMedicine,
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
            MedsEvent.HideDialog -> _state.update { it.copy(isAddingMedicine = false) }
            MedsEvent.SaveMedicine -> {
                val name = state.value.name
                val quantity = state.value.quantity

                if (name.isBlank()) return

                val medicine = Medicine(
                    name = name,
                    quantity = quantity,
                )

                viewModelScope.launch { insertMedicine(medicine) }
                _state.update {
                    it.copy(
                        isAddingMedicine = false,
                        name = "",
                        quantity = "",
                    )
                }
            }
            is MedsEvent.SetName -> _state.update { it.copy(name = event.name) }
            is MedsEvent.SetQuantity -> _state.update { it.copy(quantity = event.quantity) }
            MedsEvent.ShowDialog -> _state.update { it.copy(isAddingMedicine = true) }
        }
    }
}
