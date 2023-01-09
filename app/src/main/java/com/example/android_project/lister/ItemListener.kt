package com.example.android_project.lister



interface ItemListener {

    fun onClick()
    fun onElementSelected(name: String, date: String,imageView: Int)
}