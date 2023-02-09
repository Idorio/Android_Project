package com.example.android_project.di.component

import com.example.android_project.di.AppModule
import com.example.android_project.di.DataModule
import com.example.android_project.di.DatabaseModule
import com.example.android_project.di.DomainModule
import com.example.android_project.di.factoty.ScreenScope
import com.example.android_project.presentation.auth.LoginFragment
import com.example.android_project.presentation.auth.OnBoardingFragment
import com.example.android_project.presentation.view.DetailsFragment
import com.example.android_project.presentation.view.HomeFragment
import com.example.android_project.presentation.view.ItemsFragment
import com.example.android_project.presentation.view.MainActivity.MainActivity
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        DatabaseModule::class,
        DataModule::class,
        DomainModule::class,
        ViewModelModule::class
    ]
)


@ScreenScope
interface AppComponent {


    fun inject(activity: MainActivity)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: DetailsFragment)
    fun inject(fragment: HomeFragment)
    fun inject(fragment: ItemsFragment)
    fun inject(fragment: OnBoardingFragment)

}