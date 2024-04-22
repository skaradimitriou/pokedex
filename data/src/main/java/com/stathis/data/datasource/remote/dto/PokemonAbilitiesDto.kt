package com.stathis.data.datasource.remote.dto

data class PokemonAbilitiesDto(
    val ability: AbilityDto? = null
)

data class AbilityDto(
    val name: String
)
