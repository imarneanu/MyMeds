package com.imarneanu.startapp.ui.meds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.imarneanu.startapp.ui.theme.StartAppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MedsActivity : ComponentActivity() {

    val model: MedsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StartAppTheme {
                MedsScreen(model.state.collectAsState().value, model::onEvent)
            }
        }
    }
}
