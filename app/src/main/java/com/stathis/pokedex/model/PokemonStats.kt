package com.stathis.pokedex.model

import com.stathis.pokedex.abstraction.LocalModel

class PokemonStats (

    val base_stat : Int,
    val effort : Int,
    val stat : PokemonStat

) : LocalModel
