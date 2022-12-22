package com.example.android_project.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_project.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(), DatailsView {

    private var Binding: FragmentDetailsBinding? = null
    private val binding get() = Binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Binding= FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        val bundle = arguments
        bundle?.let {
            val name = bundle.getString("name")
            val date = bundle.getString("date")
            val image = bundle.getInt("imageView")



           binding.detailsDate.text = date
            binding.detailsName.text = name
            binding.detailsImage.setBackgroundResource(image)


        }
    }
}