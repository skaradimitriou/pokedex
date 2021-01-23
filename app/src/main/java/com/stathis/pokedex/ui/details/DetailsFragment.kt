package com.stathis.pokedex.ui.details

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.AbstractFragment
import com.stathis.pokedex.ui.home.HomeViewModel

class DetailsFragment : AbstractFragment(R.layout.fragment_details) {

    private lateinit var viewModel: DetailsViewModel
    private lateinit var pokemon: String

    override fun initLayout(view: View) {
        viewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)
    }

    override fun running() {
        pokemon = arguments?.getString("pokemon") ?: ""
        viewModel.performApiCall(pokemon)

        observeViewModel()
    }

    override fun stop() {}

    private fun observeViewModel() {
        //
    }
}