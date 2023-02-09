package com.example.android_project.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_project.R
import com.example.android_project.domain.auth.AuthInteractor

import kotlinx.coroutines.launch
import javax.inject.Inject



class DetailsViewModel @Inject constructor( private val authInteractor: AuthInteractor): ViewModel() {

       private val _nav = MutableLiveData<Int>()
        val nav: LiveData<Int> = _nav


    fun logoutUser(){
        viewModelScope.launch {
            authInteractor.logoutUser()
            _nav.value =  R.navigation.auth_graph
        }
        }


    }
