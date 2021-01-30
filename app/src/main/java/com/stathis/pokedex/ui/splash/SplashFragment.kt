package com.stathis.pokedex.ui.splash

import android.os.Handler
import android.view.View
import androidx.navigation.Navigation
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.AbstractFragment

class SplashFragment : AbstractFragment(R.layout.fragment_splash) {

    override fun initLayout(view: View) {
        Handler().postDelayed({
            val actionDetails = SplashFragmentDirections.actionSplashFragmentToNavHome()
            Navigation.findNavController(view).navigate(actionDetails)
        }, 3000)
    }

    override fun running() {}

    override fun stop() {}
}