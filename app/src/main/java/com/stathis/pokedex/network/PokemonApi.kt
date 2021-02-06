package com.stathis.pokedex.network

import com.stathis.pokedex.model.*
import com.stathis.pokedex.models.PokemonResultsMain
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("pokemon?offset=0 &limit=10")
    fun getPokemons() : Single<PokemonResultsMain>

    @GET("pokemon/{pokemonName}")
    fun getPokemon(@Path("pokemonName") pokemonName : String) : Single<Pokemon>

    @GET("type")
    fun getPokemonClassTypes() : Single<PokemonResultsMain>

    @GET("type/{type}")
    fun getPokemonTypes(@Path("type") type : String) : Single<PokemonClass>

    @GET("pokemon-species/{id}")
    fun getPokemonSpecies(@Path("id") id : String) : Single<PokemonSpeciesModel>

    @GET("evolution-chain/{id}")
    fun getPokemonEvolution(@Path("id") id : String) : Single<EvolutionModel>
}