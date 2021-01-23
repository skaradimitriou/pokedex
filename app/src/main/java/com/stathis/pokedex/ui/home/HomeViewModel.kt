package com.stathis.pokedex.ui.home

import androidx.lifecycle.ViewModel
import com.stathis.pokedex.ui.home.holder.PokemonAdapter
import com.stathis.pokedex.ui.home.model.Pokemon

class HomeViewModel : ViewModel() {

    var adapter = PokemonAdapter()

    init {
        createDummyList()
    }

    private fun createDummyList() {
        adapter.submitList(
            listOf(
                Pokemon("Pikachu", "1", "2"),
                Pokemon("Snorlax", "1", "2"),
                Pokemon("Charizard", "1", "2"),
                Pokemon("Mewtwo", "1", "2"),
                Pokemon("Ditto", "1", "2"),
                Pokemon("Squirtle", "1", "2"),
                Pokemon("Charmander", "1", "2"),
                Pokemon("Bulbasar", "1", "2")
            )
        )
    }
}