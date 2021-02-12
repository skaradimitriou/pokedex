package com.stathis.pokedex.ui.home.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.stathis.pokedex.abstraction.LocalModel
import com.stathis.pokedex.listeners.PokemonListener
import com.stathis.pokedex.model.Pokemon
import com.stathis.pokedex.model.PokemonResults
import com.stathis.pokedex.tools.ColorRepo
import kotlinx.android.synthetic.main.holder_pokemon_item_row.view.*

class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun present(localModel: LocalModel, callback: PokemonListener) {
        when (localModel) {
            is PokemonResults -> {
                itemView.home_screen_pokemon_name.text = localModel.name
            }

            is Pokemon -> {
                itemView.home_screen_pokemon_img.load(localModel.sprites.other?.official_artwork?.front_default)

                itemView.home_screen_pokemon_name.text = localModel.name.capitalize()
                itemView.home_screen_pokemon_type.text =
                    "Type: ${localModel.types[0].type.name.capitalize()}"
                itemView.home_screen_pokemon_hp.text = localModel.stats[0].base_stat.toString()
                itemView.home_screen_pokemon_attack.text = localModel.stats[1].base_stat.toString()
                itemView.home_screen_pokemon_defence.text = localModel.stats[2].base_stat.toString()

                itemView.setOnClickListener {
                    callback.pokemonClicked(localModel)
                }

                val colorRepo = ColorRepo().getColors()
                colorRepo.forEach {
                    if (localModel.types.first().type.name == it.pokemonClass) {
                        itemView.bg_card.backgroundTintList =
                            ContextCompat.getColorStateList(itemView.context, it.color)
                    }
                }
            }
        }
    }
}
