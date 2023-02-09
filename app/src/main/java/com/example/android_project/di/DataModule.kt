package com.example.android_project.di

import android.content.Context
import com.example.android_project.data.ApiService
import com.example.android_project.data.ItemRepositoryImpl
import com.example.android_project.data.SheredPref.SharedPreferencesHelper
import com.example.android_project.data.auth.AuthRepositoryImpl
import com.example.android_project.domain.ItemsRepository
import com.example.android_project.domain.auth.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module

abstract class DataModule {
    @Binds
    abstract fun bindItemsRepository(
        itemsRepositoryImpl: ItemRepositoryImpl
    ): ItemsRepository

    @Binds
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository


    companion object{
        private val SHARED_PRESS_KEY = "USER_KEY"
        private const val BASE_URL = "https://api.jsonserve.com/"


       @Provides
       fun provideSharedPreferencesHelper(context: Context):SharedPreferencesHelper{
           return SharedPreferencesHelper(
               context.getSharedPreferences(SHARED_PRESS_KEY,
                   Context.MODE_PRIVATE)
           )
       }
        @Provides
        fun provideApiService(retrofit: Retrofit): ApiService{
            return retrofit.create(ApiService::class.java)
        }


        @Provides
        fun provideRetrofitInstance(): Retrofit{
            return  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }



   }
}
