package com.stathis.pokedex.ui.home

import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.AbstractFragment
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : AbstractFragment(R.layout.fragment_home) {

    private lateinit var viewModel: HomeViewModel

    override fun initLayout(view: View) {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun running() {
        viewModel.performApiCall()
        home_screen_recycler.adapter = viewModel.adapter
    }

    override fun stop() {}
}