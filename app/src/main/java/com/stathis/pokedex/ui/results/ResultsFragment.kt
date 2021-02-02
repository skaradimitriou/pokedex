package com.stathis.pokedex.ui.results

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.AbstractFragment
import kotlinx.android.synthetic.main.fragment_results.*


class ResultsFragment : AbstractFragment(R.layout.fragment_results) {

    private lateinit var viewModel : ResultsViewModel
    private lateinit var pokemonType : String

    override fun initLayout(view: View) {
        viewModel = ViewModelProviders.of(this).get(ResultsViewModel::class.java)
    }

    override fun running() {
        pokemonType = arguments?.getString("pokemonClass") ?: ""

        results_recycler.adapter = viewModel.adapter
    }

    override fun stop() {}
}