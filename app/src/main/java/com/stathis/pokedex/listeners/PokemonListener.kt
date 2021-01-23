package com.stathis.pokedex.listeners

import com.stathis.pokedex.models.PokemonResults

interface PokemonListener {

    fun pokemonClicked(pokemon : PokemonResults)
}