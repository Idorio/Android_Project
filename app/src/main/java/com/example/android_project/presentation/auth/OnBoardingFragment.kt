package com.example.android_project.presentation.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_project.R
import com.example.android_project.databinding.FragmentOnBoardingBinding
import com.example.android_project.presentation.view.ItemsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment(),OnBoardingView {
    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var onBoardingPresenter: OnBoardingPresenter





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onBoardingPresenter.setView(this)




        binding.btnFinish.setOnClickListener {
            onBoardingPresenter.goToItemsFragment()
        }



    }

    override fun goToItemsFragment() {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, ItemsFragment())
            .commit()
    }
}


