package com.imarneanu.startapp.ui.meds

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMedicationDialog(
    state: MedsState,
    onEvent: (MedsEvent) -> Unit,
) {
    AlertDialog(
        onDismissRequest = { onEvent(MedsEvent.HideDialog) },
        confirmButton = {
            Button(onClick = { onEvent(MedsEvent.SaveMedicine) }) {
                Text(text = "Save")
            }
        },
        dismissButton = {
            Button(onClick = { onEvent(MedsEvent.HideDialog) }) {
                Text(text = "Cancel")
            }
        },
        title = { Text("Add medication") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                TextField(value = state.name, onValueChange = {
                    onEvent(MedsEvent.SetName(it))
                },
                    placeholder = {
                        Text(text = "Name")
                    })
                TextField(value = state.quantity.toString(), onValueChange = {
                    onEvent(MedsEvent.SetQuantity(it))
                },
                    placeholder = {
                        Text(text = "Quantity")
                    })
            }
        }
    )
}
