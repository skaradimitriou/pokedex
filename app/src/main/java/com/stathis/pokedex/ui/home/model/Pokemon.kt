package com.stathis.pokedex.ui.home.model

import com.stathis.pokedex.abstraction.LocalModel

class Pokemon(

    val name: String,
    val height: String,
    val weight: String,
    val sprites : Sprites,

) : LocalModel