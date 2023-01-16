package com.example.android_project.presentation.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_project.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authInteractor: AuthInteractor):ViewModel() {

    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun loginUser(userName: String, userPassword: String) {

        val coroutineExceptionHandler = CoroutineExceptionHandler{_, exception ->
            Log.w("exception called", exception.toString())
        }
        viewModelScope.launch(
            CoroutineName(
                "with exception")+Dispatchers.Main + coroutineExceptionHandler+Dispatchers.Main) {
            try {
                launch { loginUser(userName, userPassword)
                    _nav.postValue(Unit) }

            }catch (e : Exception){
                Log.w("exception", "LoginUser FAILED")
            }


        }
    }

    fun userNavigated(){
        _nav.value= null
    }
}




