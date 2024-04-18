package com.stathis.core.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.stathis.domain.models.LocalModel

abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: LocalModel) {
        present(data)
    }

    abstract fun present(data: LocalModel)
}