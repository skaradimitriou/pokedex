package com.stathis.core.base

import com.stathis.domain.models.UiModel

interface ItemCallback {
    fun onItemClick(model: UiModel)
}