package com.stathis.pokedex.models

import com.google.gson.annotations.SerializedName
import com.stathis.pokedex.abstraction.LocalModel

class PokemonResultsMain (

    @SerializedName("count")
    val count : String,

    @SerializedName("next")
    val next : String,

    @SerializedName("previous")
    val previous : String,

    @SerializedName("results")
    val results : List<PokemonResults>

) : LocalModel