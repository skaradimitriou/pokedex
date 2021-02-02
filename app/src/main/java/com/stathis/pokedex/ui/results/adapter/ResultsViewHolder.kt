package com.stathis.pokedex.ui.results.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.stathis.pokedex.abstraction.LocalModel
import com.stathis.pokedex.model.PokemonClassType
import com.stathis.pokedex.models.PokemonResults
import kotlinx.android.synthetic.main.holder_category_item_row.view.*

class ResultsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun present(localModel: LocalModel) {

        when (localModel) {
            is PokemonClassType -> {
                itemView.holder_category_name.text = localModel.name.name
            }
        }
    }
}