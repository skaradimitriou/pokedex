package com.stathis.pokedex.listeners

import com.stathis.pokedex.models.PokemonResults

interface CategoriesListener {

    fun onClassClick(pokemon : PokemonResults)
}