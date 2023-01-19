package com.example.android_project.data.model

import com.google.gson.annotations.SerializedName

 data class ItemsResponce(
    @SerializedName("sample")
    val sampleList: List<Sample>
)

data class Sample(

    @SerializedName("discription")
    val discription: String,
    @SerializedName("image-url")
    val imageUrl: String



)
