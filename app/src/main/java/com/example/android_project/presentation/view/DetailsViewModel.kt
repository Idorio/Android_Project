package com.example.android_project.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_project.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor( private val authInteractor: AuthInteractor): ViewModel() {

       private val _nav = MutableLiveData<Unit?>()
        val nav: LiveData<Unit?> = _nav


        suspend fun userLoggerOut(){
            authInteractor.userLoggerOut()
            _nav.value = Unit
        }


    }
