package com.example.android_project.domain

import com.example.android_project.data.data_base.ItemsEntity
import com.example.android_project.model.ItemsModel

interface ItemsRepository {

     suspend fun getData()

     suspend fun showData() : List<ItemsModel>

     suspend fun deleteItemByDescription(description: String)

     suspend fun findItemsByDescription(searchText: String) :ItemsModel

}