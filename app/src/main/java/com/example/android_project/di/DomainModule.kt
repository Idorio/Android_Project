package com.example.android_project.di

import com.example.android_project.domain.ItemInteractor
import com.example.android_project.domain.ItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideItemInteractor(
        itemsRepository: ItemsRepository
    ): ItemInteractor {
        return ItemInteractor(itemsRepository)
    }
}