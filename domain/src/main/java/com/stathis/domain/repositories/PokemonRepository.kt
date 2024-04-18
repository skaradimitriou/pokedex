package com.stathis.domain.repositories

import com.stathis.domain.models.Pokemon

interface PokemonRepository {

    suspend fun fetchPokemonDetailsByName(pokemonName: String): Pokemon
}