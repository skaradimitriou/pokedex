package com.stathis.pokedex.ui.categories

import android.util.Log
import androidx.lifecycle.ViewModel
import com.stathis.pokedex.abstraction.LocalModel
import com.stathis.pokedex.dinjection.DaggerApiComponent
import com.stathis.pokedex.listeners.CategoriesListener
import com.stathis.pokedex.model.EmptyModel
import com.stathis.pokedex.model.PokemonResults
import com.stathis.pokedex.model.PokemonResultsMain
import com.stathis.pokedex.network.PokemonService
import com.stathis.pokedex.ui.categories.holders.CategoriesAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CategoriesViewModel : ViewModel(), CategoriesListener {

    @Inject
    lateinit var pokemonService: PokemonService
    private val disposable by lazy { CompositeDisposable() }

    val adapter = CategoriesAdapter(this)
    lateinit var callback: CategoriesListener
    private lateinit var emptyModelList: MutableList<LocalModel>

    init {
        DaggerApiComponent.create().inject(this)

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