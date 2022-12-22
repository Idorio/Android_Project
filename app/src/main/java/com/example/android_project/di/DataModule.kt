package com.example.android_project.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.android_project.data.ItemRepositoryImpl
import com.example.android_project.data.SheredPref.SharedPreferencesHelper
import com.example.android_project.data.auth.AuthRepositoryImpl
import com.example.android_project.domain.ItemsRepository
import com.example.android_project.domain.auth.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
   abstract fun bindAuthRepositpory(authRepositoryImpl: AuthRepositoryImpl
    ):AuthRepository

   companion object{
       private val SHARED_PRESS_KEY = "USER_KEY"

       @Provides
       fun provideSharedPreferencesHelper(@ApplicationContext context: Context):SharedPreferencesHelper{
           return SharedPreferencesHelper(
               context.getSharedPreferences(
                   SHARED_PRESS_KEY,MODE_PRIVATE
               )
           )
       }
   }

}
