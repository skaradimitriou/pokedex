package com.stathis.pokedex.ui.categories.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.stathis.pokedex.abstraction.LocalModel
import com.stathis.pokedex.model.PokemonClassType
import kotlinx.android.synthetic.main.holder_category_item_row.view.*

class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun present(localModel: LocalModel){

        when(localModel){
            is PokemonClassType -> {
                itemView.holder_category_name.text = localModel.name.name
            }
        }
    }
}