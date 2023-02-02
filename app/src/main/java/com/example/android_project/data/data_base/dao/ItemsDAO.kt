package com.example.android_project.data.data_base.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android_project.data.data_base.ItemsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemsDAO {



    @Query("SELECT * From ItemsEntity ")
    fun getItemsEntity() : Flow<List<ItemsEntity>>

    @Query("SELECT(SELECT COUNT(*) From ItemsEntity) != 0") //если БД пустая добавит элемент, если не пустая, то нет
    fun doesItemsEntityExist(): Flow<Boolean>

    @Insert
    fun insertItemsEntity(itemsEntity: ItemsEntity)

    @Query("DELETE FROM ItemsEntity WHERE description = :description")
    fun deleteItemEntityByDescription(description: String)

    @Query("SELECT * FROM ItemsEntity WHERE description = :searchText")
    fun findItemEntityByDescription(searchText: String): ItemsEntity
}