package com.example.labb_3_android.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EnlistViewModel : ViewModel() {
    private val _helldiverId = MutableLiveData<String>()
    val helldiverId: LiveData<String> = _helldiverId

    fun setHelldiverId(id: String?) {
        _helldiverId.value = id
    }
}