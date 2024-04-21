package com.stathis.pokedex.ui

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stathis.pokedex.di.IoDispatcher
import com.stathis.pokedex.navigator.NavAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    val navigatorState: StateFlow<NavigationData?>
        get() = _navigatorState

    private val _navigatorState = MutableStateFlow<NavigationData?>(null)

    fun resetNavigation() = viewModelScope.launch(dispatcher) {
        _navigatorState.emit(null)
    }

    fun navigateToScreen(action: NavAction?, data: Bundle? = null) {
        viewModelScope.launch(dispatcher) {
            _navigatorState.emit(NavigationData(action, data))
        }
    }

    data class NavigationData(
        val action: NavAction? = null,
        val bundle: Bundle? = null
    )
}