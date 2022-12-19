package com.example.android_project.presentation.view

import com.example.android_project.R
import com.example.android_project.domain.items.ItemInteractor

class ItemsPresenter(private val itemsView : ItemsView,private val itemsInteractor: ItemInteractor) {

    fun getData(){
        val list = itemsInteractor.getData()


        itemsView.dateReceived(list)

    }

    fun imageViewClicked(){
        itemsView.imageViewClicked(R.string.hello_blank_fragment)

    }

    fun elementSelected(name: String, date: String, imageView: Int){
        itemsView.goToDetails(name, date , imageView)
    }

}