package com.example.android_project.presentation.view

import com.example.android_project.domain.auth.AuthRepository

import javax.inject.Inject

class DetailsPresenter @Inject constructor(
    private val authRepository: AuthRepository
)
{
    private lateinit var detailView: DatailsView

    fun setView(detailsFragment: DetailsFragment){
        detailView = detailsFragment
    }

    fun getArguments()
}