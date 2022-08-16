package com.icretu.mymeds.ui.affections

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AffectionsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is affections Fragment"
    }
    val text: LiveData<String> = _text
}
