package com.example.android_project.data

import com.example.android_project.R
import com.example.android_project.domain.ItemsRepository
import com.example.android_project.model.ItemsModel
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor():ItemsRepository {

   override fun getData(): List<ItemsModel>{
      val listItems = mutableListOf<ItemsModel>(
         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
         ItemsModel(R.drawable.apple, "Android", "12.25.45"),

         )
      return listItems
   }


}