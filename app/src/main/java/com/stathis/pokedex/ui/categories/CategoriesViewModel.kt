package com.stathis.pokedex.ui.categories

import android.util.Log
import androidx.lifecycle.ViewModel
import com.stathis.pokedex.abstraction.LocalModel
import com.stathis.pokedex.listeners.CategoriesListener
import com.stathis.pokedex.model.EmptyModel
import com.stathis.pokedex.models.PokemonResults
import com.stathis.pokedex.models.PokemonResultsMain
import com.stathis.pokedex.network.PokemonService
import com.stathis.pokedex.ui.categories.holders.CategoriesAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CategoriesViewModel : ViewModel(), CategoriesListener {

    val adapter = CategoriesAdapter(this)
    lateinit var callback: CategoriesListener
    private val pokemonService = PokemonService()
    private val disposable = CompositeDisposable()
    private lateinit var emptyModelList: MutableList<LocalModel>

    init {
        startShimmer()
        getPokemonClasses()
    }

    private fun startShimmer() {
        emptyModelList = mutableListOf(
            EmptyModel(),
            EmptyModel(),
            EmptyModel(),
            EmptyModel(),
            EmptyModel(),
            EmptyModel(),
            EmptyModel(),
            EmptyModel(),
            EmptyModel(),
            EmptyModel()
        )
        adapter.submitList(emptyModelList)
    }

    fun initListener(callback: CategoriesListener) {
        this.callback = callback
    }

    fun getPokemonClasses() {
        disposable.add(
            pokemonService.getPokemonClassTypes()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<PokemonResultsMain>() {
                    override fun onSuccess(response: PokemonResultsMain) {
                        Log.d("", response.toString())
                        emptyModelList.clear()
                        adapter.submitList(response.results)
                        adapter.notifyDataSetChanged()
                    }

                    override fun onError(e: Throwable) {
                        Log.d("", e.toString())
                    }
                })
        )
    }

    override fun onClassClick(pokemon: PokemonResults) {
        callback.onClassClick(pokemon)
    }
}