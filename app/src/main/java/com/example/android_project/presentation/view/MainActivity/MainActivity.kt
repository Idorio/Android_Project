package com.example.android_project.presentation.view.MainActivity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.android_project.R
import com.example.android_project.databinding.ActivityMainBinding
import com.example.android_project.presentation.view.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() , NavController.OnDestinationChangedListener{

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainActivityViewModel by viewModels()

   private lateinit var navController: NavController

    private lateinit var navHostFragment: NavHostFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(false)


        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView
        )as NavHostFragment



        viewModel.checkUserExists()

        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener(this)

        binding.bottomNavigation.setupWithNavController(navController)

        val btnav = AppBarConfiguration(
            setOf(R.id.homeFragment, R.id.itemsFragment)
        )

        setupActionBarWithNavController(navController,btnav)

        viewModel.userExists.observe(this){

            val navGraph = navHostFragment.navController.navInflater.inflate(
                R.navigation.auth_graph
            )

            val random = (1 .. 5).random()
            if (random==1){
                navGraph.startDestination = R.id.loginFragment
            }else{
                navGraph.startDestination = R.id.homeFragment
            }




//            navController.setGraph(it)

            navGraph.startDestination = R.id.homeFragment

        }


        viewModel.visibility.observe(this){
            binding.bottomNavigation.visibility = it
        }


    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        viewModel.destinationChanged(destination)
    }

    override fun onDestroy() {
        super.onDestroy()
        navController.removeOnDestinationChangedListener(this)
    }
}
