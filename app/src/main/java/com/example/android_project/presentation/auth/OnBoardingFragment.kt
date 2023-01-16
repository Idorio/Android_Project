package com.example.android_project.presentation.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import com.example.android_project.R
import com.example.android_project.databinding.FragmentOnBoardingBinding
import com.example.android_project.utils.NavHelper.navigateWithDeletedBackStack


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

            viewModel.onBtnClick()
        }

        viewModel.nav.observe(viewLifecycleOwner){
            if (it != null) {
                val navOption = NavOptions.Builder()
                navOption.setPopUpTo(R.id.onBoardingFragment, true)

                navigateWithDeletedBackStack(it.destinationId,it.removeFragmentId)


                viewModel.onBoardingBack()
            }
        }
    }
}
