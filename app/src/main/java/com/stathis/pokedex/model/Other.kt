package com.stathis.pokedex.model

import com.google.gson.annotations.SerializedName
import com.stathis.pokedex.abstraction.LocalModel

class Other (

    val dream_world : PokemonImage?,

    @SerializedName("official-artwork")
    val official_artwork : PokemonImage

) : LocalModel