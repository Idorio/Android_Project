package com.example.android_project.presentation.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.android_project.R
import com.example.android_project.databinding.FragmentLoginBinding
import com.example.android_project.presentation.view.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment(), LoginView {

    private var _binding:FragmentLoginBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var loginPresenter: LoginPresenter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginPresenter.setView(this)

        binding.btnLogin.setOnClickListener {
            loginPresenter.userLogin(
                binding.etUserName.text.toString(),
                binding.etUserPassword.text.toString()
            )

        }


    }

    override fun userLoggedIn() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.activity_container , HomeFragment())
            .commit()
    }

}
