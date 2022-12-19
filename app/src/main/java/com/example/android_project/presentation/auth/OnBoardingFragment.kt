package com.example.android_project.presentation.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.android_project.databinding.FragmentOnBoardingBinding
import com.example.android_project.presentation.view.ItemsFragment
import com.example.android_project.presentation.view.Navigation.setFragment


class OnBoardingFragment : Fragment() {

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!

    private val viewModel: OnBoardingViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.btnFinish.setOnClickListener {
            setFragment(parentFragmentManager, ItemsFragment())
            viewModel.onBoardingBack()
        }
    }
}
