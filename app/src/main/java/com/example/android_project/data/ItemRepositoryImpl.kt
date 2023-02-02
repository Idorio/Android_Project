package com.example.android_project.data

import android.util.Log
import com.example.android_project.data.data_base.ItemsEntity
import com.example.android_project.data.data_base.dao.ItemsDAO
import com.example.android_project.domain.ItemsRepository
import com.example.android_project.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
   private val apiService: ApiService,
   private val itemsDAO: ItemsDAO

):ItemsRepository {

   override suspend fun getData() {
      return withContext(Dispatchers.IO){
         itemsDAO.doesItemsEntityExist().collect(){
            if (!it){
               val responce = apiService.getData()

               Log.w("data", responce.body()?.sampleList.toString())
                responce.body()?.sampleList?.let {
                    it.map {
                        val list = ItemsEntity(Random().nextInt(),it.discription, it.imageUrl)
                        itemsDAO.insertItemsEntity(list)

                    }
                }
            }
         }
       }
   }
   override suspend fun showData(): Flow<List<ItemsModel>> {
      return withContext(Dispatchers.IO){
         val itemsEntity = itemsDAO.getItemsEntity()
         itemsEntity.map {itemsList->
            itemsList.map{item->
               ItemsModel(item.discription,item.imageUrl)
            }
         }
      }
   }

   override suspend fun deleteItemByDescription(description: String) {
      withContext(Dispatchers.IO){
         itemsDAO.deleteItemEntityByDescription(description)
      }
   }

   override suspend fun findItemsByDescription(searchText: String): ItemsModel {
     return withContext(Dispatchers.IO){
        val itemsEntity = itemsDAO.findItemEntityByDescription(searchText)

        ItemsModel(itemsEntity.discription, itemsEntity.imageUrl)
     }
   }
}


