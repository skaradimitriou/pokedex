package com.stathis.pokedex.network

import com.stathis.pokedex.models.PokemonResultsMain
import com.stathis.pokedex.ui.home.model.Pokemon
import io.reactivex.Single
import retrofit2.http.GET

interface PokemonApi {

    @GET("pokemon?offset=0 &limit=100")
    fun getPokemon() : Single<PokemonResultsMain>
}