package com.stathis.domain.models

data class Pokemon(
    val id: String,
    val name: String,
    val height: String,
    val weight: String
) : UiModel {
    override fun equalsContent(obj: UiModel) = false
}