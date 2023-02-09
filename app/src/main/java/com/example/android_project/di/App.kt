package com.example.android_project.di

import android.app.Application
import com.example.android_project.di.component.AppComponent
import com.example.android_project.di.component.DaggerAppComponent


class App : Application(){

    lateinit var appComponent: AppComponent
    fun provideAppComponent() : AppComponent{
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        return appComponent
    }



}


