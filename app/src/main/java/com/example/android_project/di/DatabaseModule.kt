package com.example.android_project.di

import android.app.Application
import com.example.android_project.data.data_base.dao.ItemsDAO
import com.example.android_project.data.data_base.dao.ItemsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent



@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideItemsDatabase(context: Application): ItemsDatabase{
        return ItemsDatabase.getItemsDatabaseInstance(context)
    }
    @Provides
    fun provideItemsDAO(itemsDatabase: ItemsDatabase): ItemsDAO{
        return  itemsDatabase.getItemsDAO()

    }
}