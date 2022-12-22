package com.example.android_project.di

import com.example.android_project.domain.auth.AuthInteractor
import com.example.android_project.domain.items.ItemInteractor
import com.example.android_project.presentation.auth.OnBoardingPresenter
import com.example.android_project.presentation.view.ItemsPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {
    @Provides
    fun provideOnBoardingPresenter(): OnBoardingPresenter {
        return OnBoardingPresenter()
    }

    @Provides
    fun provideItemsPresenter(
        itemInteractor: ItemInteractor
    ): ItemsPresenter {
        return ItemsPresenter(itemInteractor)
    }
}