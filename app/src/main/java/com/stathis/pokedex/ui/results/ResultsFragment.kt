package com.stathis.pokedex.ui.results

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.AbstractFragment
import com.stathis.pokedex.listeners.ResultsListener
import com.stathis.pokedex.model.Pokemon
import com.stathis.pokedex.model.PokemonClassType
import com.stathis.pokedex.ui.home.HomeFragmentDirections
import kotlinx.android.synthetic.main.fragment_results.*


class ResultsFragment : AbstractFragment(R.layout.fragment_results), ResultsListener {

    private lateinit var viewModel: ResultsViewModel
    private lateinit var pokemonType: String

    override fun initLayout(view: View) {
        viewModel = ViewModelProviders.of(this).get(ResultsViewModel::class.java)
    }

    override fun running() {
        pokemonType = arguments?.getString("pokemonClass") ?: ""

        viewModel.getPokemonTypes(pokemonType)
        viewModel.initCallbacks(this)

        results_recycler.adapter = viewModel.adapter
    }

    override fun stop() {}

    override fun onPokemonResultsClick(pokemon: Pokemon) {
        val actionDetails = ResultsFragmentDirections.actionResultsFragmentToNavTwo2(pokemon.name)
        Navigation.findNavController(view!!).navigate(actionDetails)
    }


}