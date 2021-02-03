package com.stathis.pokedex.ui.results

import android.util.Log
import androidx.lifecycle.ViewModel
import com.stathis.pokedex.listeners.ResultsListener
import com.stathis.pokedex.model.PokemonClass
import com.stathis.pokedex.model.PokemonClassType
import com.stathis.pokedex.network.PokemonService
import com.stathis.pokedex.ui.categories.holders.CategoriesAdapter
import com.stathis.pokedex.ui.results.adapter.ResultsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ResultsViewModel : ViewModel(), ResultsListener {

    val adapter = ResultsAdapter(this)
    lateinit var callback : ResultsListener
    private val pokemonService = PokemonService()
    private val disposable = CompositeDisposable()

    fun initCallbacks(callback : ResultsListener){
        this.callback = callback
    }

    fun getPokemonTypes(pokemonType : String) {
        disposable.add(
            pokemonService.getPokemonClasses(pokemonType)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<PokemonClass>() {
                    override fun onSuccess(response: PokemonClass) {
                        Log.d("", response.toString())
                        adapter.submitList(response.pokemons)
                    }

                    override fun onError(e: Throwable) {
                        Log.d("", e.toString())
                    }
                })
        )
    }

    override fun onPokemonResultsClick(pokemonName: PokemonClassType) {
        callback.onPokemonResultsClick(pokemonName)
    }
}