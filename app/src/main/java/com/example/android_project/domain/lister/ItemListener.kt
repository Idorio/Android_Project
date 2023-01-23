package com.example.android_project.domain.lister

import android.content.ClipDescription


interface ItemListener {

    fun onClick()
    fun onElementSelected(name: String, date: String,imageView: Int)

    suspend fun onDeleteClicked(description: String)
}