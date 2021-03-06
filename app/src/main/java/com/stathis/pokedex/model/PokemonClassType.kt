package com.stathis.pokedex.model

import com.google.gson.annotations.SerializedName
import com.stathis.pokedex.abstraction.LocalModel

class PokemonClassType (

    @SerializedName("pokemon")
    val name : PokemonResults,

    @SerializedName("slot")
    val slot : Int

) : LocalModel