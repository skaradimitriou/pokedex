package com.stathis.pokedex.ui.categories.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.stathis.pokedex.abstraction.LocalModel
import com.stathis.pokedex.listeners.CategoriesListener
import com.stathis.pokedex.model.PokemonClassType
import com.stathis.pokedex.models.PokemonResults
import kotlinx.android.synthetic.main.holder_category_item_row.view.*

class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun present(localModel: LocalModel, callback : CategoriesListener){

        when(localModel){

            is PokemonResults -> {
                itemView.holder_category_name.text = localModel.name

                itemView.setOnClickListener {
                    callback.onClassClick(localModel)
                }
            }
        }
    }
}