package com.stathis.pokedex.ui

import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.AbstractActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AbstractActivity(R.layout.activity_main) {

    override fun init() {
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val navController = findNavController(R.id.fragment)

        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener{ _, destination, _ ->
            when(destination.id){
                R.id.nav_two -> bottom_navigation.visibility = View.GONE
                R.id.splashFragment -> bottom_navigation.visibility = View.GONE
                else -> bottom_navigation.visibility = View.GONE
            }
        }
    }

    override fun running() {}

    override fun stopped() {}

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.fragment)
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }
}