package com.stathis.pokedex.network

import com.stathis.pokedex.dinjection.DaggerApiComponent
import com.stathis.pokedex.model.*
import com.stathis.pokedex.model.PokemonResultsMain
import io.reactivex.Single
import javax.inject.Inject

class PokemonService {

    @Inject
    lateinit var api : PokemonApi

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getPokemons(): Single<PokemonResultsMain> {
        return api.getPokemons()
    }

    fun getPokemon(pokemonName: String): Single<Pokemon> {
        return api.getPokemon(pokemonName)
    }

    fun getPokemonClasses(type: String) : Single<PokemonClass> {
        return api.getPokemonTypes(type)
    }

    fun getPokemonClassTypes() : Single<PokemonResultsMain> {
        return api.getPokemonClassTypes()
    }

    fun getPokemonSpecies(id : String) : Single<PokemonSpeciesModel> {
        return api.getPokemonSpecies(id)
    }

    fun getPokemonEvolution(id : String) : Single<EvolutionModel> {
        return api.getPokemonEvolution(id)
    }
}