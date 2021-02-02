package com.stathis.pokedex.ui.categories.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.LocalModel
import com.stathis.pokedex.listeners.CategoriesListener
import com.stathis.pokedex.tools.DiffUtilClass

class CategoriesAdapter(val callback : CategoriesListener) : ListAdapter<LocalModel, CategoriesViewHolder>(DiffUtilClass()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.holder_category_item_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.present(getItem(position),callback)
    }
}