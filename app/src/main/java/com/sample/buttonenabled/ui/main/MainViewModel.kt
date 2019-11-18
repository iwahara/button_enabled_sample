package com.sample.buttonenabled.ui.main

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val mailAddress = MutableLiveData<String>("")
    val password = MutableLiveData<String>("")
    val isSaveMailAddress = MutableLiveData<Boolean>(false)

    val isButtonLoginEnabled = MediatorLiveData<Boolean>()

    init {

        val observer = Observer<String> {
            val mail = this.mailAddress.value ?: ""
            val password = this.password.value ?: ""
            this.isButtonLoginEnabled.value = mail.isNotEmpty() && password.trim().length >= 6
        }
        isButtonLoginEnabled.addSource(mailAddress, observer)
        isButtonLoginEnabled.addSource(password, observer)
    }
}
