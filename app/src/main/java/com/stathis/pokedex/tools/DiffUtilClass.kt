package com.stathis.pokedex.tools

import androidx.recyclerview.widget.DiffUtil
import com.stathis.pokedex.abstraction.LocalModel

class DiffUtilClass<T : LocalModel> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.equals(newItem)
    }
}