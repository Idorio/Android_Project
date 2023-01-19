package com.example.android_project.domain

import com.example.android_project.model.ItemsModel

interface ItemsRepository {

     suspend fun getData(): List<ItemsModel>

}