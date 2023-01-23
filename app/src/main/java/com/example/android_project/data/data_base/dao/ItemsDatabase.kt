package com.example.android_project.data.data_base.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android_project.data.data_base.ItemsEntity


@Database(entities = [ItemsEntity::class], version = 1, exportSchema = false)
abstract class ItemsDatabase : RoomDatabase() {

    abstract fun getItemsDAO(): ItemsDAO

    companion object{
        private const val DATABASE_NAME = "items_database"
        private var DB_INSTANCE:ItemsDatabase? = null

        fun getItemsDatabaseInstance(context: Context):ItemsDatabase{
            return DB_INSTANCE ?: Room
                .databaseBuilder(
                    context.applicationContext,
                    ItemsDatabase::class.java,
                    DATABASE_NAME
                )
                .build()
                .also { DB_INSTANCE = it }
        }
    }

}