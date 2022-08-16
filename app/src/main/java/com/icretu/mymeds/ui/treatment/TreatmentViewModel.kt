package com.icretu.mymeds.ui.treatment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TreatmentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is treatment Fragment"
    }
    val text: LiveData<String> = _text
}
