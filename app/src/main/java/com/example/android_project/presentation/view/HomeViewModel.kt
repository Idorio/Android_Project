package com.example.android_project.presentation.view;


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_project.domain.auth.AuthInteractor
import com.example.android_project.model.UserModel
import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
class HomeViewModel @Inject constructor(private val authInteractor: AuthInteractor
): ViewModel() {

    private val _userCreds = MutableLiveData<UserModel>()
    val userCreds: LiveData<UserModel> = _userCreds

    suspend fun showUserData() {
        _userCreds.value = authInteractor.getUserCreds()
    }
}
