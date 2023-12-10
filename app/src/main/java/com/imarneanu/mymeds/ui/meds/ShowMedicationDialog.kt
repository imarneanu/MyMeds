package com.imarneanu.mymeds.ui.meds

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowMedicationDialog(
    state: MedsState,
    onEvent: (MedsEvent) -> Unit,
) {
    val dateDialogState = rememberMaterialDialogState()
    var pickedDate by remember {
        mutableStateOf(LocalDate.now())
    }
    AlertDialog(
        onDismissRequest = { onEvent(MedsEvent.HideDialog) },
        confirmButton = {
            Button(onClick = { onEvent(MedsEvent.SaveMedicine) }) {
                Text(state.medicineId?.let { "Update" } ?: "Save")
            }
        },
        dismissButton = {
            Button(onClick = { onEvent(MedsEvent.HideDialog) }) {
                Text(text = "Cancel")
            }
        },
        title = { Text(state.medicineId?.let { "Edit medication" } ?: "Add medication") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                TextField(value = state.name, onValueChange = {
                    onEvent(MedsEvent.SetName(it))
                },
                    placeholder = {
                        Text(text = "Name")
                    })
                TextField(
                    value = state.quantity ?: "",
                    onValueChange = {
                        if (it.isEmpty()) onEvent(MedsEvent.SetQuantity(null))
                        else onEvent(MedsEvent.SetQuantity(it))
                    },
                    placeholder = {
                        Text(text = "Quantity")
                    }
                )
                Row {
                    Button(onClick = { dateDialogState.show() }) {
                        Text(text = "Expiration date")
                    }
                    Text(text = state.expirationDate?.let { MedsUIMapper.toFormatDate(it) } ?: "")
                }
            }
        }
    )
    MaterialDialog(
        dialogState = dateDialogState,
        buttons = {
            positiveButton(text = "Ok") {
                onEvent(MedsEvent.SetExpirationDate(pickedDate))
            }
            negativeButton(text = "Cancel")
        }
    ) {
        datepicker(
            initialDate = LocalDate.now(),
            title = "Pick expiration date",
        ) {
            pickedDate = it
        }
    }
}
