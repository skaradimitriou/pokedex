package com.stathis.pokedex.ui.categories.holders

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.LocalModel
import com.stathis.pokedex.listeners.CategoriesListener
import com.stathis.pokedex.model.PokemonClassType
import com.stathis.pokedex.models.PokemonResults
import kotlinx.android.synthetic.main.holder_category_item_row.view.*
import kotlinx.android.synthetic.main.holder_pokemon_item_row.view.*

class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun present(localModel: LocalModel, callback : CategoriesListener){

        when(localModel){

            is PokemonResults -> {
                itemView.holder_category_name.text = localModel.name.capitalize()

                itemView.setOnClickListener {
                    callback.onClassClick(localModel)
                }

                when(localModel.name){
                    "rock" -> {
                        itemView.holder_category_bg.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.dark_red))
                    }

                    "poison" -> {
                        itemView.holder_category_bg.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.poison_class))
                    }

                    "ground" -> {
                        itemView.holder_category_bg.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.ground_class))
                    }

                    "water" -> {
                        itemView.holder_category_bg.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.water_class))
                    }

                    "psychic" -> {
                        itemView.holder_category_bg.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.psychic_class))
                    }

                    "electric" -> {
                        itemView.holder_category_bg.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.electric_class))
                    }

                    "rock" -> {
                        itemView.holder_category_bg.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.rock_class))
                    }

                    "grass","bug","fairy" -> {
                        itemView.holder_category_bg.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.grass_class))
                    }

                    else -> {
                        itemView.holder_category_bg.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.psychic_class))
                    }
                }
            }
        }
    }
}