package com.example.android_project.mvp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.android_project.R
import com.example.android_project.data.auth.AuthRepositoryImpl
import com.example.android_project.databinding.ActivityMainBinding
import com.example.android_project.domain.auth.AuthInteractor
import com.example.android_project.presentation.auth.LoginFragment
import com.example.android_project.presentation.view.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {

    private var binding: ActivityMainBinding? = null

    @Inject
    lateinit var mainPresenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding!!.root)

        mainPresenter.setView(this)

        mainPresenter.checkUserExists()



    }

    override fun userExistsResult(userExists: Boolean) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(
            R.id.activity_container,
            when(userExists){
                true -> HomeFragment()
                false -> LoginFragment()
            }
        )
        fragmentTransaction.commit()
    }
}


