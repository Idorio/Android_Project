package com.example.android_project.presentation.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_project.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authInteractor: AuthInteractor):ViewModel() {

    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun loginUser(userName: String, userPassword: String) {
        try {
            authInteractor.userLoggedIn(userName, userPassword)
            _nav.value = Unit
        }catch (e:Exception){
            _error.value = "This user already exist"
        }

    }
    fun userLoggerIn(){
        _nav.value=null
    }
}


