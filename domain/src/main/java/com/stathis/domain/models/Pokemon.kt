package com.stathis.domain.models

data class Pokemon(
    val id: String,
    val name: String,
    val height: String,
    val weight: String,
    val imageUrl: String,
    val abilities: List<Ability>
) : UiModel {
    override fun equalsContent(obj: UiModel) = false
}

data class Ability(
    val name: String
)