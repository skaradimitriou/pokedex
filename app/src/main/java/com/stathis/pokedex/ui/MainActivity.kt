package com.stathis.pokedex.ui

import androidx.activity.addCallback
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.stathis.core.base.BaseActivity
import com.stathis.pokedex.R
import com.stathis.pokedex.databinding.ActivityMainBinding
import com.stathis.pokedex.navigator.NavigatorImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var navController: NavController
    private lateinit var navigator: NavigatorImpl

    override fun init() {
        navController = findNavController(R.id.navHostFragment)
        navigator = NavigatorImpl(this, navController)

        navController.addOnDestinationChangedListener { _, _, _ ->
            val isNotAtHome = navController.currentDestination?.id != R.id.dashboardFragment
            supportActionBar?.setDisplayHomeAsUpEnabled(isNotAtHome)
        }

        onBackPressedDispatcher.addCallback {
            navigator.goBack()
            viewModel.resetNavigation()
        }
    }

    override fun startOps() {
        lifecycleScope.launch {
            viewModel.navigatorState.flowWithLifecycle(lifecycle).collectLatest { navModel ->
                navModel?.action?.let {
                    navigator.navigateTo(it, navModel.bundle)
                    viewModel.resetNavigation()
                }
            }
        }
    }

    override fun stopOps() {
        viewModel.resetNavigation()
    }
}