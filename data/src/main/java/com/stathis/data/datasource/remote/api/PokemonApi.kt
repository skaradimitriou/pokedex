package com.stathis.data.datasource.remote.api

import com.stathis.data.datasource.remote.dto.PokemonResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("pokemon/{name}")
    suspend fun getPokemonDetailsByName(
        @Path("name") pokemonName: String
    ): Response<PokemonResponseDto?>

    @GET("pokemon/{id}")
    suspend fun getPokemonDetailsById(
        @Path("id") pokemonId: Int
    ): Response<PokemonResponseDto?>
}