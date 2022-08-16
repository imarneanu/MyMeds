package com.icretu.mymeds.ui.meds

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MedsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is meds Fragment"
    }
    val text: LiveData<String> = _text
}
