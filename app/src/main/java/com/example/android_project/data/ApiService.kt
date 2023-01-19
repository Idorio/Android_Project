package com.example.android_project.data


import com.example.android_project.data.model.ItemsResponce
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/nkuYRM")
    suspend fun getData(): Response<ItemsResponce>

}