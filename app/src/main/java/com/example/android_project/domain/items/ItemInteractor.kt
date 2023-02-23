package com.example.android_project.domain.items

import com.example.android_project.domain.ItemsRepository
import com.example.android_project.model.ItemsModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemInteractor @Inject constructor (private val itemRepository: ItemsRepository){

   suspend fun getData(){
       itemRepository.getData()
    }

    suspend fun showData() :List<ItemsModel> {
        return itemRepository.showData()
    }

    suspend fun deleteItemByDescription(description: String){
        itemRepository.deleteItemByDescription(description)
    }

    suspend fun findItem(searchText:String):ItemsModel {
        return itemRepository.findItemsByDescription(searchText)

    }
}