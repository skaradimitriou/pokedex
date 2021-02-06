package com.stathis.pokedex.model

import com.stathis.pokedex.abstraction.LocalModel

class EvolutionModel(

    val baby_trigger_item : String,
    val chain : PokemonEvolution

) : LocalModel