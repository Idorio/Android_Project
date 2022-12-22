package com.example.android_project.presentation.view

import com.example.android_project.domain.items.ItemInteractor
import com.example.android_project.presentation.auth.ItemsView
import javax.inject.Inject


class ItemsPresenter @Inject constructor( private val itemInteractor: ItemInteractor) {
    private lateinit var itemsView: ItemsView
    fun setView(itemsFragment: ItemsFragment){
        itemsView = itemsView
    }

    fun getItems(){
        val items = itemInteractor.getData()
        itemsView.itemsReceived()
    }


    }

    fun imageViewClicked(){

    }

    fun itemClicked(name: String,date: String,itemsView: Int){



    }



data class NavigateWithBundle(
    val image: Int,
    val name: String,
    val date: String
)

