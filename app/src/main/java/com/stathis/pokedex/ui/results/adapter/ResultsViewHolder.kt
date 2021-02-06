package com.stathis.pokedex.ui.results.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.stathis.pokedex.abstraction.LocalModel
import com.stathis.pokedex.listeners.ResultsListener
import com.stathis.pokedex.model.Pokemon
import kotlinx.android.synthetic.main.holder_category_item_row.view.holder_category_name
import kotlinx.android.synthetic.main.holder_results_item_row.view.*

class ResultsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun present(localModel: LocalModel,callback : ResultsListener) {

        when (localModel) {
            is Pokemon -> {
                itemView.holder_category_name.text = localModel.name.capitalize()

                itemView.holder_results_pokemon_img.load(localModel.sprites.other?.official_artwork?.front_default)

                itemView.holder_category_pokemon_hp.text = "HP: ${localModel.stats[0].base_stat.toString()}"
                itemView.holder_category_pokemon_attack.text = "Attack: ${localModel.stats[1].base_stat.toString()}"
                itemView.holder_category_pokemon_defence.text = "Defence: ${localModel.stats[2].base_stat.toString()}"

                itemView.setOnClickListener {
                    callback.onPokemonResultsClick(localModel)
                }
            }
        }
    }
}