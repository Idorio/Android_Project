package com.example.android_project.presentation.view.MainActivity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.android_project.R
import com.example.android_project.databinding.ActivityMainBinding
import com.example.android_project.di.App
import java.util.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() , NavController.OnDestinationChangedListener{

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MainActivityViewModel by viewModels {viewModelFactory}


    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)

        viewModel.checkUserExists()

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        viewModel.userExists.observe(this) {
            navController.graph = getNavGraph()
        }

        navController.addOnDestinationChangedListener(this) // добавление слушателя navigation bottom

        binding.bottomNavigation.setupWithNavController(navController)

        viewModel.visibility.observe(this) {
            binding.bottomNavigation.visibility = it
        }
    }

    private fun getNavGraph(): NavGraph {
        val navGraph =
            navHostFragment.navController.navInflater.inflate( //выбор экрана загрузки, в зависимости от условия
                R.navigation.auth_graph
            )

        val random = Random().nextInt(5-1)
        if (random == 1 || random == 2) {
            navGraph.startDestination = R.id.homeFragment
        } else {
            navGraph.startDestination = R.id.loginFragment
        }
        return navGraph
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
