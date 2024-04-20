package com.stathis.pokedex.ui.dashboard

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.stathis.core.base.BaseViewModel
import com.stathis.domain.usecases.FetchPokemonDetailsByName
import com.stathis.pokedex.di.IoDispatcher
import com.stathis.pokedex.ui.dashboard.uimodel.DashboardItem
import com.stathis.pokedex.ui.dashboard.uimodel.DashboardItemType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    app: Application,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val useCase: FetchPokemonDetailsByName
) : BaseViewModel(app) {

    val options: StateFlow<List<DashboardItem>> get() = _options

    private val _options = MutableStateFlow<List<DashboardItem>>(listOf())

    fun showDashboardItems() {
        viewModelScope.launch(dispatcher) {
            val options = listOf(
                DashboardItem(
                    title = "Explore Pokemon",
                    type = DashboardItemType.EXPLORE_POKEMON
                ), DashboardItem(
                    title = "Types",
                    type = DashboardItemType.TYPES
                ), DashboardItem(
                    title = "Locations",
                    type = DashboardItemType.LOCATIONS
                )
            )
            _options.emit(options)
        }
    }

    fun fetchData() {
//        viewModelScope.launch(dispatcher) {
//            val result = useCase.invoke("charizard")
//            Timber.d(result.toString())
//        }
    }
}