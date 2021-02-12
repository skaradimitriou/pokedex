package com.stathis.pokedex.model

import com.google.gson.annotations.SerializedName
import com.stathis.pokedex.abstraction.LocalModel
import com.stathis.pokedex.model.PokemonResults

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