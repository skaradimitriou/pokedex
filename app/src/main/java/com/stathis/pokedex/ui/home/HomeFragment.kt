package com.stathis.pokedex.ui.home

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.AbstractFragment
import com.stathis.pokedex.listeners.PokemonListener
import com.stathis.pokedex.model.Pokemon
import com.stathis.pokedex.models.PokemonResults
import kotlinx.android.synthetic.main.fragment_home.*
import kotlin.math.abs


class HomeFragment : AbstractFragment(R.layout.fragment_home), PokemonListener {

    private lateinit var viewModel: HomeViewModel
    private lateinit var pokemonName: String

    override fun initLayout(view: View) {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.setCallback(this)
    }

    override fun running() {
        searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                hideKeyboard(requireView())
                searchView.clearFocus()
                searchView.setQuery("", false)
                Log.d("HELLO", query)
                pokemonName = query.toString().toLowerCase()
                viewModel.checkIfPokemonExist(query.toString().toLowerCase())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        setupViewPager2()
        observeViewModel()
    }

    override fun stop() {}

    private fun setupViewPager2() {
        home_screen_viewpager.adapter = viewModel.adapter
        home_screen_viewpager.offscreenPageLimit = 3
        home_screen_viewpager.clipToPadding = false
        home_screen_viewpager.clipChildren = false
        home_screen_viewpager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }

        home_screen_viewpager.setPageTransformer(compositePageTransformer)
    }

    private fun observeViewModel() {
        viewModel.pokemonExists.observe(viewLifecycleOwner, Observer {
            when (it) {
                true -> {
                    goToPokemonPage(pokemonName)
                }

                false -> {
                    val actionDetails = HomeFragmentDirections.actionNavHomeToNoResultFragment()
                    Navigation.findNavController(view!!).navigate(actionDetails)
                }
            }
        })
    }

    fun hideKeyboard(view: View) {
        val inputMethodManager = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun pokemonClicked(pokemon: Pokemon) {
        goToPokemonPage(pokemon.name)
    }

    private fun goToPokemonPage(pokemonName: String) {
        val actionDetails = HomeFragmentDirections.actionNavHomeToNavTwo(pokemonName)
        Navigation.findNavController(view!!).navigate(actionDetails)
    }
}