package com.stathis.pokedex.model

import com.google.gson.annotations.SerializedName
import com.stathis.pokedex.abstraction.LocalModel

class PokemonClass(

    val name : String,

    @SerializedName("pokemon")
    val pokemons : List<PokemonClassType>

) : LocalModel