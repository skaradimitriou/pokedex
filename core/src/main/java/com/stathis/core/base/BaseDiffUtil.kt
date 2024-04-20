package com.stathis.core.base

import androidx.recyclerview.widget.DiffUtil
import com.stathis.domain.models.UiModel

class BaseDiffUtil<T : UiModel> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.equalsContent(newItem)
    }
}