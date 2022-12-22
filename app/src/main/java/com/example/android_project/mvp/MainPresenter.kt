package com.example.android_project.mvp

import com.example.android_project.domain.auth.AuthInteractor
import javax.inject.Inject

class MainPresenter @Inject constructor(private val authInteractor : AuthInteractor) {
    private lateinit var mainView: MainView

    fun setView(mainActivity: MainActivity){
        mainView = mainActivity
    }

    fun checkUserExists() {

        val doesUserExists = authInteractor.doesUserExist()
        mainView.userExistsResult(doesUserExists)

    }
}
