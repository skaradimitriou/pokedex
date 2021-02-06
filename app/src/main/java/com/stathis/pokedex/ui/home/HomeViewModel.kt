package com.stathis.pokedex.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.stathis.pokedex.abstraction.LocalModel
import com.stathis.pokedex.abstraction.SingleLiveEvent
import com.stathis.pokedex.listeners.PokemonListener
import com.stathis.pokedex.model.EmptyModel
import com.stathis.pokedex.model.Pokemon
import com.stathis.pokedex.models.PokemonResults
import com.stathis.pokedex.models.PokemonResultsMain
import com.stathis.pokedex.network.PokemonService
import com.stathis.pokedex.ui.home.holder.PokemonAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class HomeViewModel : ViewModel(), PokemonListener {

    var adapter = PokemonAdapter(this)
    private lateinit var callback: PokemonListener
    private val pokemonService = PokemonService()
    private val disposable = CompositeDisposable()
    val pokemonExists = SingleLiveEvent<Boolean>()
    val pokemonList = mutableListOf<LocalModel>()

    init {
        startShimmer()
        performApiCall()
    }

    private fun startShimmer() {
        adapter.submitList(listOf(EmptyModel(),EmptyModel(),EmptyModel()))
    }

    fun setCallback(callback: PokemonListener) {
        this.callback = callback
    }

    fun performApiCall() {
        disposable.add(
            pokemonService.getPokemons()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<PokemonResultsMain>() {
                    override fun onSuccess(response: PokemonResultsMain) {
                        Log.d("", response.toString())

                        response.results.forEach {
                            getEachPokemonData(it.name)
                        }
                    }

                    override fun onError(e: Throwable) {
                        Log.d("", e.toString())
                    }
                })
        )
    }

    private fun getEachPokemonData(pokemonName: String) {
        disposable.add(
            pokemonService.getPokemon(pokemonName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Pokemon>() {
                    override fun onSuccess(response: Pokemon) {
                        Log.d("", response.toString())
                        pokemonList.add(response)
                        adapter.submitList(pokemonList)
                        adapter.notifyDataSetChanged()
                    }

                    override fun onError(e: Throwable) {
                        Log.d("", e.toString())
                    }
                })
        )
    }

    fun checkIfPokemonExist(pokemonName: String) {
        disposable.add(
            pokemonService.getPokemon(pokemonName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Pokemon>() {
                    override fun onSuccess(response: Pokemon) {
                        Log.d("", response.toString())
                        pokemonExists.value = true
                    }

                    override fun onError(e: Throwable) {
                        Log.d("", e.toString())
                        pokemonExists.value = false
                    }
                })
        )
    }

    override fun pokemonClicked(pokemon: Pokemon) {
        callback.pokemonClicked(pokemon)
    }
}