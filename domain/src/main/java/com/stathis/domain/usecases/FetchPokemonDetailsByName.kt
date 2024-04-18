package com.stathis.domain.usecases

import com.stathis.domain.models.Pokemon
import com.stathis.domain.repositories.PokemonRepository
import javax.inject.Inject

class FetchPokemonDetailsByName @Inject constructor(
    private val repo: PokemonRepository
) : BaseUseCase<Pokemon> {

    override suspend fun invoke(vararg args: Any?): Pokemon {
        val pokemonName = args.getOrNull(0) as? String ?: ""
        return repo.fetchPokemonDetailsByName(pokemonName)
    }
}