package com.stathis.pokedex.listeners

import com.stathis.pokedex.model.PokemonClassType

interface ResultsListener {

    fun onPokemonResultsClick(pokemonName : PokemonClassType)
}