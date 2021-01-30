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
        searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                searchView.setQuery("", false)
                Log.d("HELLO", query)
                goToPokemonPage(query.toString().toLowerCase())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        viewModel.performApiCall()
        home_screen_recycler.adapter = viewModel.adapter
    }

    override fun stop() {}

    override fun pokemonClicked(pokemon: PokemonResults) {
        goToPokemonPage(pokemon.name)
    }

    private fun goToPokemonPage(pokemonName : String){
        val actionDetails = HomeFragmentDirections.actionNavHomeToNavTwo(pokemonName)
        Navigation.findNavController(view!!).navigate(actionDetails)
    }
}