package com.example.android_project.domain.lister


interface ItemListener {

    fun onClick()
    fun onElementSelected(description: String, image: String)

    suspend fun onDeleteClicked(description: String)

    fun onFavClicked(description: String)

}