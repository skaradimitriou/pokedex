package com.stathis.pokedex.ui.search

import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.AbstractFragment


class SearchFragment : AbstractFragment(R.layout.fragment_search) {

    private lateinit var viewModel : SearchViewModel

    override fun initLayout(view: View) {
        viewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
    }

    override fun running() {}

    override fun stop() {}
}