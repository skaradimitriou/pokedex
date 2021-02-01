package com.stathis.pokedex.ui.categories

import android.util.Log
import androidx.lifecycle.ViewModel
import com.stathis.pokedex.model.PokemonClass
import com.stathis.pokedex.models.PokemonResultsMain
import com.stathis.pokedex.network.PokemonService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CategoriesViewModel : ViewModel() {

    private val pokemonService = PokemonService()
    private val disposable = CompositeDisposable()

    init {
        getPokemonTypes()
    }

    fun getPokemonTypes() {
        disposable.add(
            pokemonService.getPokemonClasses("fire")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<PokemonClass>() {
                    override fun onSuccess(response: PokemonClass) {
                        Log.d("", response.toString())
                    }

                    override fun onError(e: Throwable) {
                        Log.d("", e.toString())
                    }
                })
        )
    }
}