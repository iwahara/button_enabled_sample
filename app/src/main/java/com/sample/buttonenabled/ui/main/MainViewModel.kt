package com.sample.buttonenabled.ui.main

import androidx.lifecycle.*

class MainViewModel : ViewModel() {

    val mailAddress = MutableLiveData<String>("")
    val password = MutableLiveData<String>("")
    val isSaveMailAddress = MutableLiveData<Boolean>(false)

    private val _isButtonLoginEnabled = MediatorLiveData<Boolean>()

    val isButtonLoginEnabled: LiveData<Boolean> = _isButtonLoginEnabled

    init {

        val observer = Observer<String> {
            val mail = this.mailAddress.value ?: ""
            val password = this.password.value ?: ""
            this._isButtonLoginEnabled.value = mail.isNotEmpty() && password.trim().length >= 6
        }
        _isButtonLoginEnabled.addSource(mailAddress, observer)
        _isButtonLoginEnabled.addSource(password, observer)
    }
}
