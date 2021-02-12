package com.stathis.pokedex.ui.categories

import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.AbstractFragment
import com.stathis.pokedex.listeners.CategoriesListener
import com.stathis.pokedex.model.PokemonResults
import kotlinx.android.synthetic.main.fragment_categories.*


class CategoriesFragment : AbstractFragment(R.layout.fragment_categories), CategoriesListener {

    private lateinit var viewModel : CategoriesViewModel

    override fun initLayout(view: View) {
        viewModel = ViewModelProviders.of(this).get(CategoriesViewModel::class.java)
    }

    override fun running() {
        viewModel.initListener(this)

        categories_recycler.adapter = viewModel.adapter
    }

    override fun stop() {}

    override fun onClassClick(pokemon: PokemonResults){
        val actionDetails = CategoriesFragmentDirections.actionNavCategoriesToResultsFragment(pokemon.name)
        Navigation.findNavController(view!!).navigate(actionDetails)
    }
}