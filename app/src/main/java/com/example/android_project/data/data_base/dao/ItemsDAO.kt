package com.example.android_project.data.data_base.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android_project.data.data_base.ItemsEntity
@Dao
interface ItemsDAO {



    @Query("SELECT * From ItemsEntity ")
    fun getItemsEntity() : List<ItemsEntity>

    @Query("SELECT(SELECT COUNT(*) FROM ItemsEntity !=0)")
    fun doesItemsEntityExist():Boolean

    @Insert
    fun insertItemsEntity(itemsEntity: ItemsEntity)

    @Query("DELETE FORM ItemsEntity WHERE discription = :discription")
    fun deleteItemEntityByDescription(description: String)
}