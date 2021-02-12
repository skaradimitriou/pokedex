package com.stathis.pokedex.listeners

import com.stathis.pokedex.model.PokemonResults

interface CategoriesListener {

    fun onClassClick(pokemon : PokemonResults)
}