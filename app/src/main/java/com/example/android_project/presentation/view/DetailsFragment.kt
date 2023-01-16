package com.example.android_project.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android_project.ItemsViewModel
import com.example.android_project.R
import com.example.android_project.databinding.FragmentDetailsBinding
import com.example.android_project.databinding.FragmentItemsBinding


class DetailsFragment : Fragment() {

    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding= FragmentDetailsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val bundle = arguments
        bundle?.let {
            val name = bundle.getString("name")
            val date = bundle.getString("date")
            val image = bundle.getInt("imageView")



            viewBinding.detailsDate.text = date
            viewBinding.detailsName.text = name
            viewBinding.detailsImage.setBackgroundResource(image)


        }

        viewBinding.btnLogout.setOnClickListener{
            viewModel.logoutUser()
        }

        viewModel.nav.observe(viewLifecycleOwner){
            if(it!=null){
                val navGraph = findNavController().navInflater.inflate(it)
                navGraph.startDestination = R.id.loginFragment
                findNavController().graph= navGraph
            }

        }

    }
}