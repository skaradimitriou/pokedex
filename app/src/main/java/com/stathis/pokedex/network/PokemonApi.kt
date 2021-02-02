package com.stathis.pokedex.network

import com.stathis.pokedex.models.PokemonResultsMain
import com.stathis.pokedex.model.Pokemon
import com.stathis.pokedex.model.PokemonClass
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
}