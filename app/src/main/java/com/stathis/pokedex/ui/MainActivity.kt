package com.stathis.pokedex.ui

import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.AbstractActivity

class MainActivity : AbstractActivity(R.layout.activity_main) {

    override fun init() {
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val navController = findNavController(R.id.fragment)

        navView.setupWithNavController(navController)
    }

    override fun running() {}

    override fun stopped() {}
}