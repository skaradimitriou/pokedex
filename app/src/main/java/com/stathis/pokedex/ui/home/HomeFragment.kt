package com.stathis.pokedex.ui.home

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.AbstractFragment
import com.stathis.pokedex.listeners.PokemonListener
import com.stathis.pokedex.models.PokemonResults
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : AbstractFragment(R.layout.fragment_home), PokemonListener {

    private lateinit var viewModel: HomeViewModel

    override fun initLayout(view: View) {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        viewModel.setCallback(this)
    }

    override fun running() {
        viewModel.performApiCall()
        home_screen_recycler.adapter = viewModel.adapter
    }

    override fun stop() {}

    override fun pokemonClicked(pokemon: PokemonResults) {
        Navigation.findNavController(view!!).navigate(R.id.action_nav_home_to_nav_two)
    }
}