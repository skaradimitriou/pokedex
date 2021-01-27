package com.stathis.pokedex.model

import com.stathis.pokedex.abstraction.LocalModel

class Pokemon(

    val id: String,
    val name: String,
    val height: String,
    val weight: String,
    val sprites: Sprites,
    val types: ArrayList<PokemonTypes>,
    val stats: ArrayList<PokemonStats>

) : LocalModel