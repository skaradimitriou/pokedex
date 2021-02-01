package com.stathis.pokedex.ui.categories

import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.AbstractFragment


class CategoriesFragment : AbstractFragment(R.layout.fragment_categories) {

    private lateinit var viewModel : CategoriesViewModel

    override fun initLayout(view: View) {
        viewModel = ViewModelProviders.of(this).get(CategoriesViewModel::class.java)
    }

    override fun running() {}

    override fun stop() {}
}