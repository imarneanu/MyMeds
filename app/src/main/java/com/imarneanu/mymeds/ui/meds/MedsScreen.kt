package com.imarneanu.mymeds.ui.meds

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedsScreen(
    state: MedsState,
    onEvent: (MedsEvent) -> Unit,
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { onEvent(MedsEvent.ShowMedicineDialog()) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add medicine")
            }
        }
    ) { _ ->
        if (state.showMedicineDialog) {
            ShowMedicationDialog(state = state, onEvent = onEvent)
            return@Scaffold
        }

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(state.meds) { medicine ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "${medicine.name} - ${medicine.quantity}. ${
                                medicine.expirationDate.let { MedsUIMapper.toFormatDate(it) }
                            }",
                            color = if (medicine.isExpired) Color.Red else Color.Black,
                            fontSize = 20.sp
                        )
                    }
                    IconButton(onClick = { onEvent(MedsEvent.ShowMedicineDialog(medicine)) }) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            tint = if (medicine.isExpired) Color.Red else Color.Black,
                            contentDescription = "Edit medicine",
                        )
                    }
                    IconButton(onClick = { onEvent(MedsEvent.DeleteMedicine(medicine)) }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            tint = if (medicine.isExpired) Color.Red else Color.Black,
                            contentDescription = "Delete medicine",
                        )
                    }
                }
            }
        }
    }
}
