package com.example.android_project.presentation.auth

import com.example.android_project.domain.auth.AuthInteractor
import javax.inject.Inject


class OnBoardingPresenter @Inject constructor() {

    private lateinit var onBoardingView: OnBoardingView

    fun setView(onBoardingFragment: OnBoardingFragment){
        onBoardingView = onBoardingFragment

    }

    fun goToItemsFragment(){


    }
}