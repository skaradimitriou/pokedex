package com.stathis.pokedex.ui.results.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.stathis.core.base.BaseDiffUtil
import com.stathis.core.base.BaseViewHolder
import com.stathis.domain.models.Pokemon
import com.stathis.domain.models.UiModel
import com.stathis.pokedex.BR
import com.stathis.pokedex.databinding.HolderResultsPokemonItemBinding

class ResultsAdapter(
    private val callback: ResultsCallback
) : ListAdapter<UiModel, ResultsViewHolder>(BaseDiffUtil<UiModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = HolderResultsPokemonItemBinding.inflate(inflater, parent, false)
        return ResultsViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ResultsViewHolder(
    private val binding: ViewDataBinding,
    private val callback: ResultsCallback
) : BaseViewHolder(binding) {

    override fun present(data: UiModel) {
        when (data) {
            is Pokemon -> {
                binding.setVariable(BR.model, data)
                binding.setVariable(BR.callback, callback)
            }
        }
    }
}

fun interface ResultsCallback {
    fun onPokemonClick(model: Pokemon)
}