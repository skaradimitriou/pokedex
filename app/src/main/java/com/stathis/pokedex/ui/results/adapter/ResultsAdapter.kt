package com.stathis.pokedex.ui.results.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.LocalModel
import com.stathis.pokedex.listeners.ResultsListener
import com.stathis.pokedex.tools.DiffUtilClass
import com.stathis.pokedex.ui.categories.holders.CategoriesViewHolder

class ResultsAdapter(val callback : ResultsListener) : ListAdapter<LocalModel, ResultsViewHolder>(DiffUtilClass()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {
        return ResultsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.holder_results_item_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        holder.present(getItem(position),callback)
    }
}