package com.stathis.pokedex.ui.home.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.stathis.pokedex.abstraction.LocalModel
import com.stathis.pokedex.listeners.PokemonListener
import com.stathis.pokedex.models.PokemonResults
import kotlinx.android.synthetic.main.holder_pokemon_item_row.view.*

class PokemonViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    fun present(localModel : LocalModel,callback : PokemonListener){
        when(localModel){
            is PokemonResults -> {
                itemView.home_screen_pokemon_name.text = localModel.name

                itemView.setOnClickListener {
                    callback.pokemonClicked(localModel)
                }
            }
        }
    }
}
