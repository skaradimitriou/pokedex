package com.stathis.data.mappers

import com.stathis.core.util.toNotNull
import com.stathis.data.datasource.remote.dto.PokemonResponseDto
import com.stathis.domain.models.Ability
import com.stathis.domain.models.Pokemon

object PokemonResponseMapper : BaseMapper<PokemonResponseDto?, Pokemon> {

    override fun toDomainModel(dto: PokemonResponseDto?) = Pokemon(
        id = dto?.id.toNotNull(),
        name = dto?.name.toNotNull().replaceFirstChar(Char::titlecase),
        height = dto?.height.toNotNull(),
        weight = dto?.weight.toNotNull(),
        imageUrl = dto?.sprites?.other?.dream_world?.front_default.toNotNull(),
        abilities = dto?.abilities?.map { Ability(it.ability?.name.toString()) } ?: listOf()
    )
}