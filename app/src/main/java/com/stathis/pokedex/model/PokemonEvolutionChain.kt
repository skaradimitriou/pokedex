package com.stathis.pokedex.model

import com.google.gson.annotations.SerializedName
import com.stathis.pokedex.abstraction.LocalModel

class PokemonEvolutionChain (

    @SerializedName("evolves_to")
    val evolution : List<EvolutionPokemon>,
    val species: PokemonSpecies

) : LocalModel