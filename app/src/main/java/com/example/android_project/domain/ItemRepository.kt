package com.example.android_project.domain

import com.example.android_project.model.ItemsModel

interface ItemsRepository {

     fun getData(): List<ItemsModel>

}