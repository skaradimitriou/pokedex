package com.stathis.pokedex.listeners

import com.stathis.pokedex.model.Pokemon

interface ResultsListener {

    fun onPokemonResultsClick(pokemon: Pokemon)
}