package com.example.android_project.presentation.view


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_project.R
import com.example.android_project.domain.auth.AuthInteractor
import com.example.android_project.model.UserModel
import javax.inject.Inject;
import kotlinx.coroutines.launch


class HomeViewModel @Inject constructor(private val authInteractor: AuthInteractor
): ViewModel() {


    private val _userCreds = MutableLiveData<UserModel>()
        val userCreds: LiveData<UserModel> = _userCreds

        private val _nav = MutableLiveData<Int?>()
        val nav: LiveData<Int?> = _nav


        fun showUserData() {
            viewModelScope.launch {
                _userCreds.value = authInteractor.getUserCreds()
            }

        }

        fun toRecyclerView() {
            _nav.value = R.navigation.main_graph
        }
    }

