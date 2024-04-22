package com.stathis.data.datasource.remote.dto

data class PokemonResponseDto(
    val id: String? = null,
    val name: String? = null,
    val height: String? = null,
    val weight: String? = null,
    val sprites: SpritesDto? = null,
    val abilities: List<PokemonAbilitiesDto>? = null
)