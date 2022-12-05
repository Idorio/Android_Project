package com.example.android_project.domain

import com.example.android_project.model.ItemsModel

class ItemInteractor (private val itemRepository: ItemsRepository){

    fun getData(): List<ItemsModel>{
        return itemRepository.getData()
    }
}