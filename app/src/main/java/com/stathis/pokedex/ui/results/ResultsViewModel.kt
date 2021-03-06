package com.stathis.pokedex.ui.results

import android.util.Log
import androidx.lifecycle.ViewModel
import com.stathis.pokedex.abstraction.LocalModel
import com.stathis.pokedex.dinjection.DaggerApiComponent
import com.stathis.pokedex.listeners.PokemonListener
import com.stathis.pokedex.listeners.ResultsListener
import com.stathis.pokedex.model.EmptyModel
import com.stathis.pokedex.model.Pokemon
import com.stathis.pokedex.model.PokemonClass
import com.stathis.pokedex.model.PokemonClassType
import com.stathis.pokedex.network.PokemonService
import com.stathis.pokedex.ui.categories.holders.CategoriesAdapter
import com.stathis.pokedex.ui.home.holder.PokemonAdapter
import com.stathis.pokedex.ui.results.adapter.ResultsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ResultsViewModel : ViewModel(), ResultsListener {

    @Inject
    lateinit var pokemonService: PokemonService
    private val disposable by lazy { CompositeDisposable() }

    val adapter = ResultsAdapter(this)
    lateinit var callback: ResultsListener
    val pokemonList = mutableListOf<LocalModel>()

    init {
        DaggerApiComponent.create().inject(this)

        startShimmer()
    }

    private fun startShimmer() {
        adapter.submitList(
            listOf(
                EmptyModel(),
                EmptyModel(),
                EmptyModel(),
                EmptyModel(),
                EmptyModel(),
                EmptyModel()
            )
        )
    }

    fun initCallbacks(callback: ResultsListener) {
        this.callback = callback
    }

    fun getPokemonTypes(pokemonType: String) {
        disposable.add(
            pokemonService.getPokemonClasses(pokemonType)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<PokemonClass>() {
                    override fun onSuccess(response: PokemonClass) {
                        Log.d("", response.toString())

                        response.pokemons.forEach {
                            getEachPokemonData(it.name.name)
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

    override fun onPokemonResultsClick(pokemon: Pokemon) {
        callback.onPokemonResultsClick(pokemon)
    }
}