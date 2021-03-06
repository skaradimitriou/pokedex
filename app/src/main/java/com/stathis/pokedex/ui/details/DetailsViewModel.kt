package com.stathis.pokedex.ui.details

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stathis.pokedex.dinjection.DaggerApiComponent
import com.stathis.pokedex.model.*
import com.stathis.pokedex.network.PokemonService
import com.stathis.pokedex.tools.ColorRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailsViewModel : ViewModel() {

    @Inject
    lateinit var pokemonService: PokemonService
    private val disposable by lazy { CompositeDisposable() }

    var pokemon = MutableLiveData<Pokemon>()
    var backgroundColor = MutableLiveData<Int>()
    val pokemonStats = MutableLiveData<ArrayList<PokemonStats>>()
    val pokemonNotFound = MutableLiveData<Boolean>()
    val firstEvolution = MutableLiveData<Pokemon>()
    val secondEvolution = MutableLiveData<Pokemon>()
    val thirdEvolutionExists = MutableLiveData<Boolean>()
    val thirdEvolution = MutableLiveData<Pokemon>()

    init{
        DaggerApiComponent.create().inject(this)
    }

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

                        val cleanID = response.species.url.takeLast(6)
                            .replace(Regex("[^0-9]"), "")

                        Log.d("cleanID", cleanID)
                        getPokemonSpecie(cleanID)
                    }

                    override fun onError(e: Throwable) {
                        Log.d("", e.toString())
                        pokemonNotFound.value = true
                    }
                })
        )
    }

    private fun getPokemonSpecie(id: String) {
        disposable.add(
            pokemonService.getPokemonSpecies(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<PokemonSpeciesModel>() {
                    override fun onSuccess(response: PokemonSpeciesModel) {
                        Log.d("", response.toString())

                        val cleanID = response.evolution_chain.url.takeLast(6)
                            .replace(Regex("[^0-9]"), "")

                        getPokemonEvolutionChain(cleanID)
                    }

                    override fun onError(e: Throwable) {
                        Log.d("", e.toString())
                    }
                })
        )
    }

    private fun getPokemonEvolutionChain(id: String) {
        disposable.add(
            pokemonService.getPokemonEvolution(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<EvolutionModel>() {
                    override fun onSuccess(response: EvolutionModel) {
                        Log.d("", response.toString())

                        if(!response.chain.species.name.isNullOrEmpty()){
                            getPokemonFirstEvolution(response.chain.species.name)
                        }

                        if(!response.chain.evolution[0].species.name.isNullOrEmpty()){
                            getPokemonSecondEvolution(response.chain.evolution[0].species.name)
                        }

                        if(!response.chain.evolution.isNullOrEmpty() && !response.chain.evolution[0].evolution.isNullOrEmpty()){
                            thirdEvolutionExists.value = true
                            getPokemonThirdEvolution(response.chain.evolution[0].evolution[0].species.name)
                        } else {
                            thirdEvolutionExists.value = false
                        }
                    }

                    override fun onError(e: Throwable) {
                        Log.d("", e.toString())
                    }
                })
        )
    }

    private fun getPokemonFirstEvolution(pokemonName: String) {
        disposable.add(
            pokemonService.getPokemon(pokemonName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Pokemon>() {
                    override fun onSuccess(response: Pokemon) {
                        Log.d("", response.toString())
                        firstEvolution.value = response
                    }

                    override fun onError(e: Throwable) {
                        Log.d("", e.toString())
                    }
                })
        )
    }

    private fun getPokemonSecondEvolution(pokemonName: String) {
        disposable.add(
            pokemonService.getPokemon(pokemonName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Pokemon>() {
                    override fun onSuccess(response: Pokemon) {
                        Log.d("", response.toString())
                        secondEvolution.value = response
                    }

                    override fun onError(e: Throwable) {
                        Log.d("", e.toString())
                    }
                })
        )
    }

    private fun getPokemonThirdEvolution(pokemonName: String) {
        disposable.add(
            pokemonService.getPokemon(pokemonName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Pokemon>() {
                    override fun onSuccess(response: Pokemon) {
                        Log.d("", response.toString())
                        thirdEvolution.value = response
                    }

                    override fun onError(e: Throwable) {
                        Log.d("", e.toString())
                    }
                })
        )
    }

    fun setBackgroundColor(pokemonTypes: ArrayList<PokemonTypes>) {
        ColorRepo().getColors().forEach {
            if(pokemonTypes.first().type.name == it.pokemonClass){
                backgroundColor.value = it.color
            }
        }
    }
}