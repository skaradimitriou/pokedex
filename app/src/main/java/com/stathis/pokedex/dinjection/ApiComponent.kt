package com.stathis.pokedex.dinjection

import com.stathis.pokedex.network.PokemonService
import com.stathis.pokedex.ui.categories.CategoriesViewModel
import com.stathis.pokedex.ui.details.DetailsViewModel
import com.stathis.pokedex.ui.home.HomeViewModel
import com.stathis.pokedex.ui.results.ResultsViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service : PokemonService)

    fun inject (viewModel : HomeViewModel)

    fun inject (viewModel : CategoriesViewModel)

    fun inject (viewModel : DetailsViewModel)

    fun inject (viewModel : ResultsViewModel)
}