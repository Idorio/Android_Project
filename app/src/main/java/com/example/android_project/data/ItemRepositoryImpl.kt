package com.example.android_project.data

import com.example.android_project.R
import com.example.android_project.domain.ItemsRepository
import com.example.android_project.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
   private val apiService: ApiService

):ItemsRepository {

   override suspend fun getData(): List<ItemsModel>{
      return withContext(Dispatchers.IO){
         val responce = apiService.getData()
         responce.body()?.sampleList.let {
            it?.map {
               ItemsModel(it.discription, it.imageUrl)
            }
      }?: kotlin.run {
         emptyList()
         }


      }

//      val listItems = mutableListOf<ItemsModel>(
//         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
//         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
//         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
//         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
//         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
//         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
//         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
//         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
//         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
//         ItemsModel(R.drawable.apple, "Android", "12.25.45"),
//
//         )
//      return listItems
   }


}