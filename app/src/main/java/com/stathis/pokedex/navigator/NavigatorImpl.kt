package com.stathis.pokedex.navigator

import android.app.Activity
import android.os.Bundle
import androidx.navigation.NavController
import com.stathis.pokedex.R
import javax.inject.Inject

class NavigatorImpl @Inject constructor(
    private val activity: Activity?,
    private val navController: NavController
) : Navigator {

    override fun navigateTo(screenKey: NavAction, args: Bundle?) = when (screenKey) {
        NavAction.HOME -> navController.navigate(R.id.dashboardFragment, args)
        NavAction.SEARCH -> navController.navigate(R.id.resultsFragment, args)
        else -> Unit
    }

    override fun goBack() {
        if (navController.graph.startDestinationId == navController.currentDestination?.id) {
            activity?.finish()
        } else {
            navController.navigateUp()
        }
    }
}