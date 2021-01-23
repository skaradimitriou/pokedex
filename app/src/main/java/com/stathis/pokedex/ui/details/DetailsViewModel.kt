package com.stathis.pokedex.ui.details

import android.util.Log
import androidx.lifecycle.ViewModel
import com.stathis.pokedex.models.PokemonResultsMain
import com.stathis.pokedex.network.PokemonService
import com.stathis.pokedex.ui.home.model.Pokemon
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class DetailsViewModel : ViewModel() {

    private val pokemonService = PokemonService()
    private val disposable = CompositeDisposable()


    fun performApiCall(pokemonName : String) {
        disposable.add(
            pokemonService.getPokemon(pokemonName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Pokemon>() {

                    override fun onSuccess(response: Pokemon) {
                        Log.d("", response.toString())
                    }

                    override fun onError(e: Throwable) {
                        Log.d("", e.toString())
                    }
                })
        )
    }
}