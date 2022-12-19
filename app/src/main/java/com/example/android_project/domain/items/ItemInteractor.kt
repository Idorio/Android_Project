package com.example.android_project.domain.items

import com.example.android_project.domain.ItemsRepository
import com.example.android_project.model.ItemsModel
import javax.inject.Inject

class ItemInteractor @Inject constructor (private val itemRepository: ItemsRepository){

    fun getData(): List<ItemsModel>{
        return itemRepository.getData()
    }
}