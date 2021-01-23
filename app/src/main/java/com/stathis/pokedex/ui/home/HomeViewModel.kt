package com.stathis.pokedex.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.stathis.pokedex.listeners.PokemonListener
import com.stathis.pokedex.models.PokemonResults
import com.stathis.pokedex.models.PokemonResultsMain
import com.stathis.pokedex.network.PokemonService
import com.stathis.pokedex.ui.home.holder.PokemonAdapter
import com.stathis.pokedex.ui.home.model.Pokemon
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class HomeViewModel : ViewModel(), PokemonListener {

    var adapter = PokemonAdapter(this)
    private lateinit var callback: PokemonListener
    private val pokemonService = PokemonService()
    private val disposable = CompositeDisposable()

    init {
        performApiCall()
    }

    fun setCallback(callback: PokemonListener) {
        this.callback = callback
    }

    fun performApiCall() {
        disposable.add(
            pokemonService.getPokemon()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<PokemonResultsMain>() {

                    override fun onSuccess(response: PokemonResultsMain) {
                        Log.d("", response.toString())
                        adapter.submitList(response.results)
                    }

                    override fun onError(e: Throwable) {
                        Log.d("", e.toString())
                    }
                })
        )
    }

    override fun pokemonClicked(pokemon: PokemonResults) {
        callback.pokemonClicked(pokemon)
    }
}