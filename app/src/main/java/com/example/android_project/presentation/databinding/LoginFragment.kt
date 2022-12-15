package com.example.android_project.presentation.databinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.android_project.R
import com.example.android_project.databinding.FragmentLoginBinding
import com.example.android_project.presentation.view.ItemsView
import com.example.android_project.presentation.view.Navigation.setFragment
import com.example.android_project.presentation.view.OnBoardingFragment


class LoginFragment : Fragment() {

    private var _binding:FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel

    }
    inner class ViewHandler{
        fun goToTheOnBoarding(){
            setFragment(parentFragmentManager,OnBoardingFragment())
        }
    }

}
