package com.stathis.core.base

import com.stathis.domain.models.LocalModel

interface ItemCallback {
    fun onItemClick(model: LocalModel)
}