package com.stathis.pokedex.dinjection

import com.stathis.pokedex.network.PokemonApi
import com.stathis.pokedex.network.PokemonService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    private val BASE_URL = "https://pokeapi.co/api/v2/"

    @Provides
    fun providePokemonApi() : PokemonApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PokemonApi::class.java)
    }

    @Provides
    fun providePokemonService(): PokemonService {
        return PokemonService()
    }
}
