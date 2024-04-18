package com.stathis.data.mappers

import com.stathis.core.util.toNotNull
import com.stathis.data.datasource.remote.dto.PokemonResponseDto
import com.stathis.domain.models.Pokemon

object PokemonResponseMapper : BaseMapper<PokemonResponseDto?, Pokemon> {

    override fun toDomainModel(dto: PokemonResponseDto?) = Pokemon(
        id = dto?.id.toNotNull(),
        name = dto?.name.toNotNull(),
        height = dto?.height.toNotNull(),
        weight = dto?.weight.toNotNull()
    )
}