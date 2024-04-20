package com.stathis.pokedex.ui.dashboard.uimodel

import com.stathis.domain.models.UiModel

data class DashboardItem(
    val title: String,
    val type: DashboardItemType
) : UiModel {
    override fun equalsContent(obj: UiModel) = when (obj) {
        is DashboardItem -> title == obj.title
        else -> false
    }
}

enum class DashboardItemType {
    EXPLORE_POKEMON,
    TYPES,
    LOCATIONS
}