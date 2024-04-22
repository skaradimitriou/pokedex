package com.stathis.data.datasource.remote.dto

data class SpritesDto(
    val other: OtherSpritesDto? = null
)

data class OtherSpritesDto(
    val dream_world: DreamWorldSpritesDto? = null
)

data class DreamWorldSpritesDto(
    val front_default: String? = null
)
