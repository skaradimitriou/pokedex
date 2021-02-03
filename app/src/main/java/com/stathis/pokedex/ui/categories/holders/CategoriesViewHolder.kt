package com.stathis.pokedex.ui.categories.holders

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.LocalModel
import com.stathis.pokedex.listeners.CategoriesListener
import com.stathis.pokedex.models.PokemonResults
import kotlinx.android.synthetic.main.holder_category_item_row.view.*

class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun present(localModel: LocalModel, callback: CategoriesListener) {

        when (localModel) {

            is PokemonResults -> {
                itemView.holder_category_name.text = localModel.name.capitalize()

                itemView.setOnClickListener {
                    callback.onClassClick(localModel)
                }

                when (localModel.name) {
                    "rock" -> {
                        itemView.holder_category_bg.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.dark_red
                            )
                        )
                        itemView.holder_category_img.setImageResource(R.drawable.ic_rock)
                    }

                    "fire" -> {
                        itemView.holder_category_bg.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.dark_red
                            )
                        )
                        itemView.holder_category_img.setImageResource(R.drawable.ic_fire)
                    }

                    "poison" -> {
                        itemView.holder_category_bg.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.poison_class
                            )
                        )
                        itemView.holder_category_img.setImageResource(R.drawable.ic_poison_class_icon)
                    }

                    "shadow", "dark" -> {
                        itemView.holder_category_bg.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.poison_class
                            )
                        )
                        itemView.holder_category_img.setImageResource(R.drawable.ic_shadow_class_icon)
                    }

                    "ground" -> {
                        itemView.holder_category_bg.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.ground_class
                            )
                        )
                        itemView.holder_category_img.setImageResource(R.drawable.ic_ground)
                    }

                    "water" -> {
                        itemView.holder_category_bg.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.water_class
                            )
                        )
                        itemView.holder_category_img.setImageResource(R.drawable.ic_water_class_icon)
                    }

                    "psychic" -> {
                        itemView.holder_category_bg.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.psychic_class
                            )
                        )
                    }

                    "electric" -> {
                        itemView.holder_category_bg.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.electric_class
                            )
                        )
                        itemView.holder_category_img.setImageResource(R.drawable.ic_electric_class_icon)
                    }

                    "ice" -> {
                        itemView.holder_category_bg.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.ice_class
                            )
                        )
                        itemView.holder_category_img.setImageResource(R.drawable.ic_ice_class_type)
                    }

                    "dragon", "flying" -> {
                        itemView.holder_category_bg.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.dragon_class
                            )
                        )
                        itemView.holder_category_img.setImageResource(R.drawable.ic_dragon_class_type)
                    }

                    "fighting" -> {
                        itemView.holder_category_bg.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.fighting_class
                            )
                        )
                        itemView.holder_category_img.setImageResource(R.drawable.pokeball)
                    }

                    "steel" -> {
                        itemView.holder_category_bg.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.steel_class
                            )
                        )
                        itemView.holder_category_img.setImageResource(R.drawable.ic_steel_class_icon)
                    }

                    "grass", "bug", "fairy" -> {
                        itemView.holder_category_bg.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.grass_class
                            )
                        )
                        itemView.holder_category_img.setImageResource(R.drawable.pokeball)
                    }

                    else -> {
                        itemView.holder_category_bg.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.default_class
                            )
                        )
                        itemView.holder_category_img.setImageResource(R.drawable.pokeball)
                    }
                }
            }
        }
    }
}