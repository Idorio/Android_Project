package com.example.android_project.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_project.R
import com.example.android_project.databinding.FragmentFavouriteBinding
import com.example.android_project.databinding.FragmentHomeBinding


class FavouriteFragment : Fragment() {

    private var _binding: FragmentFavouriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         _binding= FragmentFavouriteBinding.inflate(inflater,container,false)
        return binding.root

    }
}