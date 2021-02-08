package com.stathis.pokedex.tools

import com.stathis.pokedex.R
import com.stathis.pokedex.model.ColorModel

class ColorRepo {

    fun getColors(): List<ColorModel> {
        return listOf(
            ColorModel("fire", R.color.fire_class),
            ColorModel("poison", R.color.poison_class),
            ColorModel("ground", R.color.ground_class),
            ColorModel("water", R.color.water_class),
            ColorModel("psychic", R.color.default_class),
            ColorModel("electric", R.color.electric_class),
            ColorModel("rock", R.color.rock_class),
            ColorModel("grass", R.color.grass_class),
            ColorModel("bug", R.color.default_class)
        )
    }
}