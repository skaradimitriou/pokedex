package com.stathis.pokedex.ui.results

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.stathis.core.base.BaseViewModel
import com.stathis.domain.models.Pokemon
import com.stathis.domain.usecases.FetchPokemonDetailsByName
import com.stathis.pokedex.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(
    app: Application,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val useCase: FetchPokemonDetailsByName
) : BaseViewModel(app) {

    val result: Flow<List<Pokemon>>
        get() = _result.receiveAsFlow()

    private val _result = Channel<List<Pokemon>>()

    fun searchForPokemon(query: String) {
        viewModelScope.launch(dispatcher) {
            val pokemon = useCase.invoke(query)
            _result.send(listOf(pokemon))
        }
    }
}