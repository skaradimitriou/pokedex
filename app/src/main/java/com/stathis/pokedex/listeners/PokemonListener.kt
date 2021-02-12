package com.stathis.pokedex.listeners

import com.stathis.pokedex.model.Pokemon

interface PokemonListener {

    fun pokemonClicked(pokemon : Pokemon)
}