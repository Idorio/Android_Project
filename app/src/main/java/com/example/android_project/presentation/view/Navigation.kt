package com.example.android_project.presentation.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.android_project.R

object Navigation {
    fun setFragment(parentFragmentManager: FragmentManager, fragment: Fragment){
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, fragment)
            .addToBackStack("")
            .commit()
    }
}