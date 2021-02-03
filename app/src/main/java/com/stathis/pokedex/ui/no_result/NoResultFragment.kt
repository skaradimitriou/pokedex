package com.stathis.pokedex.ui.no_result

import android.view.View
import androidx.navigation.fragment.NavHostFragment
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.AbstractFragment
import kotlinx.android.synthetic.main.fragment_no_result.*

class NoResultFragment : AbstractFragment(R.layout.fragment_no_result) {

    override fun initLayout(view: View) {
        no_pokemon_btn.setOnClickListener {
            NavHostFragment.findNavController(this).navigateUp()
        }
    }

    override fun running() {}

    override fun stop() {}
}