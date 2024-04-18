package com.stathis.data.repository

import com.stathis.core.util.getAndMapResponse
import com.stathis.data.datasource.remote.api.PokemonApi
import com.stathis.data.mappers.PokemonResponseMapper
import com.stathis.domain.repositories.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi
) : PokemonRepository {

    override suspend fun fetchPokemonDetailsByName(pokemonName: String) = getAndMapResponse(
        call = { api.getPokemonDetailsByName(pokemonName) },
        mapper = { PokemonResponseMapper.toDomainModel(it) }
    )
}