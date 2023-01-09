

package com.example.android_project.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.android_project.R
import com.example.android_project.databinding.FragmentHomeBinding
import com.example.android_project.presentation.auth.LoginViewModel
import com.example.android_project.presentation.auth.OnBoardingFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        lifecycleScope //однопоточная
            .launch {viewModel.showUserData()

        }

        CoroutineScope(Dispatchers.IO)//Многопоточная
            .launch {
            val getData = async {  }
            val navigate = async {  }

                binding.btnFinish.setOnClickListener{
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.activity_container, OnBoardingFragment())
                        .commit()
                }

                viewModel.userCreds.observe(viewLifecycleOwner){
                    binding.tvUserCreds.text = "${it.userName} \n${it.userPassword}"
                }

        }
    }

}