package com.example.android_project.presentation.auth

import com.example.android_project.domain.auth.AuthInteractor
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val autrInteractor: AuthInteractor
) {

    private lateinit var loginView: LoginView

    fun setView(loginFragment: LoginFragment){
        loginView = loginFragment
    }

    fun userLogin(userName:String, userPassword:String){
        autrInteractor.userLoggedIn(userName,userPassword)
        loginView.userLoggedIn()
    }
}