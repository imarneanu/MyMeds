package com.imarneanu.mymeds.ui.meds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.imarneanu.mymeds.ui.theme.MyMedsTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MedsActivity : ComponentActivity() {

    val model: MedsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyMedsTheme {
                MedsScreen(model.state.collectAsState().value, model::onEvent)
            }
        }
    }
}
