package com.example.android_project.di

import com.example.android_project.data.ItemRepositoryImpl
import com.example.android_project.domain.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
   abstract fun bindItemsRepositpory(
        itemsRepositoryImpl: ItemRepositoryImpl
    ):ItemsRepository
}