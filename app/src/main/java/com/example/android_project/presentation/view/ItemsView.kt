package com.example.android_project.presentation.view

import com.example.android_project.model.ItemsModel

interface ItemsView {



    fun dateReceived(listItems: List<ItemsModel>)

    fun imageViewClicked(msg: Int)

    fun goToDetails(name: String, date: String, imageView: Int)
}