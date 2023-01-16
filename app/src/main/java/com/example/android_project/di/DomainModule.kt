package com.example.android_project.di

import com.example.android_project.domain.items.ItemInteractor
import com.example.android_project.domain.ItemsRepository
import com.example.android_project.domain.auth.AuthInteractor
import com.example.android_project.domain.auth.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideItemInteractor(itemsRepository: ItemsRepository): ItemInteractor {
        return ItemInteractor(itemsRepository)
    }

    @Provides
    fun provideAuthInteractor(authRepository: AuthRepository): AuthInteractor {
        return AuthInteractor(authRepository)
    }
}

