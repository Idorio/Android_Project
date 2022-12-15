package com.example.android_project.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import com.example.android_project.R
import com.example.android_project.databinding.FragmentOnBoardingBinding
import com.example.android_project.presentation.view.Navigation.setFragment


class OnBoardingFragment : Fragment() {

    private var _binding:FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!

    private val viewModel : OnBoardingViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding= FragmentOnBoardingBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewBinding.btnFinish.setOnClickListener{
            setFragment(parentFragmentManager, ItemsFragment())
            viewModel.onBo
        }
    }
}
