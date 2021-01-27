package com.stathis.pokedex.ui.details

import android.graphics.Color
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stathis.pokedex.network.PokemonService
import com.stathis.pokedex.model.Pokemon
import com.stathis.pokedex.model.PokemonStat
import com.stathis.pokedex.model.PokemonStats
import com.stathis.pokedex.model.PokemonTypes
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class DetailsViewModel : ViewModel() {

    private val pokemonService = PokemonService()
    private val disposable = CompositeDisposable()
    var pokemon = MutableLiveData<Pokemon>()
    var backgroundColor = MutableLiveData<Int>()
    val pokemonStats = MutableLiveData<ArrayList<PokemonStats>>()

    fun performApiCall(pokemonName: String) {
        disposable.add(
            pokemonService.getPokemon(pokemonName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Pokemon>() {
                    override fun onSuccess(response: Pokemon) {
                        Log.d("", response.toString())
                        pokemon.value = response
                        pokemonStats.value = response.stats
                        setBackgroundColor(response.types)
                    }

                    override fun onError(e: Throwable) {
                        Log.d("", e.toString())
                    }
                })
        )
    }

    fun setBackgroundColor(pokemonTypes: ArrayList<PokemonTypes>) {
        when (pokemonTypes.first().type.name) {
            "fire" -> {
                backgroundColor.value = Color.parseColor("#ec4646")
            }

            "poison" -> {
                backgroundColor.value = Color.parseColor("#184d47")
            }

            "ground" -> {
                backgroundColor.value = Color.parseColor("#663f3f")
            }

            "water" -> {
                backgroundColor.value = Color.parseColor("#19456b")
            }

            "psychic" -> {
                backgroundColor.value = Color.parseColor("#252525")
            }

            "electric" -> {
                backgroundColor.value = Color.parseColor("#f58634")
            }

            "rock" -> {
                backgroundColor.value = Color.parseColor("#374045")
            }

            else -> {
                backgroundColor.value = Color.parseColor("#222831")
            }
        }
    }
}