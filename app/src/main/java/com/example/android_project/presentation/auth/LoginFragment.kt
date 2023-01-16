package com.example.android_project.presentation.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android_project.R
import com.example.android_project.databinding.FragmentLoginBinding
import com.example.android_project.utils.NavHelper.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding:FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            viewModel.loginUser(
                binding.etUserName.text.toString(),
                binding.etUserPassword.text.toString()
            )
        }
        viewModel.nav.observe(viewLifecycleOwner) {
            if (it!= null) {
                navigate(R.id.action_loginFragment_to_homeFragment)
                viewModel.userNavigated()
            }
        }
        viewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }


    }

}
