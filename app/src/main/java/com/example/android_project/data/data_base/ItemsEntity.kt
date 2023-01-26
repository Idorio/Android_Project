package com.example.android_project.data.data_base

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("ItemsEntity")
data class ItemsEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id:Int,
    @ColumnInfo("description")
    val discription:String,
    @ColumnInfo("imageUrl")
    val imageUrl:String
)
