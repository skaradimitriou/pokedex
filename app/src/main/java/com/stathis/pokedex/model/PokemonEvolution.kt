package com.stathis.pokedex.model

import com.google.gson.annotations.SerializedName
import com.stathis.pokedex.abstraction.LocalModel

class PokemonEvolution (

    @SerializedName("evolves_to")
    val evolution : List<PokemonEvolutionChain>,
    val species : PokemonSpecies

) : LocalModel
