package com.stathis.pokedex.ui.categories.holders

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.stathis.pokedex.abstraction.LocalModel
import com.stathis.pokedex.listeners.CategoriesListener
import com.stathis.pokedex.model.PokemonResults
import com.stathis.pokedex.tools.ColorRepo
import kotlinx.android.synthetic.main.holder_category_item_row.view.*

class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun present(localModel: LocalModel, callback: CategoriesListener) {

        when (localModel) {
            is PokemonResults -> {
                itemView.holder_category_name.text = localModel.name.capitalize()

                itemView.setOnClickListener {
                    callback.onClassClick(localModel)
                }

                ColorRepo().getColors().forEach {
                    if (localModel.name == it.pokemonClass) {
                        itemView.holder_category_bg.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                it.color
                            )
                        )
                        itemView.holder_category_img.setImageResource(it.image)
                    }
                }
            }
        }
    }
}