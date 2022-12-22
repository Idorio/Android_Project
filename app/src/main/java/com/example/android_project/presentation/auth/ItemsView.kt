package com.example.android_project.presentation.auth



import com.example.android_project.presentation.view.Navigation

interface ItemsView {

    fun itemsReceived()

    fun imageViewClicked(msg: Int)

    fun itemsClicked(navigationData:Navigation){

    }
}