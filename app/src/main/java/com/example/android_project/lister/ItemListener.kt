package com.example.android_project.lister

import android.widget.ImageView
import android.widget.Toast

interface ItemListener {

    fun onClick()
    fun onElementSelected(name: String, date: String,imageView: Int)
}