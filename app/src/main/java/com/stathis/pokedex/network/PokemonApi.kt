package com.stathis.pokedex.network

import com.stathis.pokedex.models.PokemonResultsMain
import com.stathis.pokedex.ui.home.model.Pokemon
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon?offset=0 &limit=10")
    fun getPokemons() : Single<PokemonResultsMain>

    @GET("pokemon/{pokemonName}")
    fun getPokemon(@Path("pokemonName") pokemonName : String) : Single<Pokemon>
}