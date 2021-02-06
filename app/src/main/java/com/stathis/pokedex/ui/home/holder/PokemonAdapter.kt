package com.stathis.pokedex.ui.home.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.LocalModel
import com.stathis.pokedex.listeners.PokemonListener
import com.stathis.pokedex.model.EmptyModel
import com.stathis.pokedex.model.Pokemon
import com.stathis.pokedex.tools.DiffUtilClass

class PokemonAdapter(val callback: PokemonListener) :
    ListAdapter<LocalModel, PokemonViewHolder>(DiffUtilClass()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.present(getItem(position), callback)
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Pokemon -> R.layout.holder_pokemon_item_row
            is EmptyModel -> R.layout.holder_shimmer_pokemon_item_row
            else -> R.layout.holder_empty_layout
        }
    }
}