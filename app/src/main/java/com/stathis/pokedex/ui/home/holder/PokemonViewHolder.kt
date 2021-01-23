package com.stathis.pokedex.ui.home.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.stathis.pokedex.abstraction.LocalModel
import com.stathis.pokedex.ui.home.model.Pokemon
import kotlinx.android.synthetic.main.holder_pokemon_item_row.view.*

class PokemonViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    fun present(localModel : LocalModel){
        when(localModel){
            is Pokemon -> {
                itemView.home_screen_pokemon_name.text = localModel.name
            }
        }
    }
}
