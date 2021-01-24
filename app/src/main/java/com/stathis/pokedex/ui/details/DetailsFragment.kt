package com.stathis.pokedex.ui.details

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.AbstractFragment
import kotlinx.android.synthetic.main.fragment_details.*

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
        viewModel.pokemon.observe(viewLifecycleOwner,Observer {pokemon ->
            details_pokemon_name.text = pokemon.name
        })
    }
}