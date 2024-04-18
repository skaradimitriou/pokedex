package com.stathis.pokedex.ui.dashboard

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.stathis.core.base.BaseViewModel
import com.stathis.domain.usecases.FetchPokemonDetailsByName
import com.stathis.pokedex.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    app: Application,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val useCase: FetchPokemonDetailsByName
) : BaseViewModel(app) {

    fun fetchData() {
        viewModelScope.launch(dispatcher) {
            val result = useCase.invoke("charizard")
            Timber.d(result.toString())
        }
    }
}