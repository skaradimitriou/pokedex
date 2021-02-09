package com.stathis.pokedex.tools

import androidx.core.content.ContextCompat
import com.stathis.pokedex.R
import com.stathis.pokedex.model.ColorModel
import kotlinx.android.synthetic.main.holder_category_item_row.view.*

class ColorRepo {

    fun getColors(): List<ColorModel> {
        return listOf(
            ColorModel("fire", R.color.fire_class, R.drawable.ic_fire),
            ColorModel("poison", R.color.poison_class, R.drawable.ic_poison_class_icon),
            ColorModel("ground", R.color.ground_class, R.drawable.ic_ground),
            ColorModel("water", R.color.water_class, R.drawable.ic_water_class_icon),
            ColorModel("psychic", R.color.default_class, R.drawable.ic_psychic),
            ColorModel("electric", R.color.electric_class, R.drawable.ic_electric_class_icon),
            ColorModel("rock", R.color.rock_class, R.drawable.ic_rock),
            ColorModel("grass", R.color.grass_class, R.drawable.ic_grass),
            ColorModel("bug", R.color.default_class, R.drawable.ic_bug),
            ColorModel("shadow", R.color.poison_class, R.drawable.ic_shadow_class_icon),
            ColorModel("dark", R.color.poison_class, R.drawable.ic_shadow_class_icon),
            ColorModel("ice", R.color.ice_class, R.drawable.ic_ice_class_type),
            ColorModel("dragon", R.color.dragon_class, R.drawable.ic_dragon_class_type),
            ColorModel("flying", R.color.dragon_class, R.drawable.ic_dragon_class_type),
            ColorModel("fighting", R.color.fighting_class, R.drawable.pokeball),
            ColorModel("steel", R.color.steel_class, R.drawable.ic_steel_class_icon),
            ColorModel("fairy", R.color.grass_class, R.drawable.ic_fairy),
            ColorModel("ghost", R.color.default_class, R.drawable.ic_ghost),
            ColorModel("normal", R.color.default_class, R.drawable.pokeball),
            ColorModel("unknown", R.color.default_class, R.drawable.pokeball)
        )
    }
}