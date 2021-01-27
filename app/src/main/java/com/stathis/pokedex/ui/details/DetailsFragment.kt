package com.stathis.pokedex.ui.details

import android.graphics.Color
import android.text.Html
import android.text.SpannedString
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.stathis.pokedex.R
import com.stathis.pokedex.abstraction.AbstractFragment
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : AbstractFragment(R.layout.fragment_details) {

    private lateinit var viewModel: DetailsViewModel
    private lateinit var pokemon: String


    override fun initLayout(view: View) {
        viewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)
    }

    override fun running() {
        pokemon = arguments?.getString("pokemon") ?: ""

        viewModel.performApiCall(pokemon)

        observeViewModel()
    }

    override fun stop() {}

    private fun observeViewModel() {
        viewModel.pokemon.observe(viewLifecycleOwner, Observer { pokemon ->
            details_pokemon_name.text = pokemon.name.capitalize()
            details_pokemon_id.text = "#${pokemon.id}"
            details_pokemon_type.text = pokemon.types[0].type.name.capitalize()
            Glide.with(this).load(pokemon.sprites.other?.official_artwork?.front_default)
                .into(details_pokemon_img)
        })

        viewModel.backgroundColor.observe(viewLifecycleOwner, Observer { color ->
            details_parent_layout.setBackgroundColor(color)
        })

        viewModel.pokemonStats.observe(viewLifecycleOwner,Observer{stats->
            details_pokemon_hp.text = Html.fromHtml("<b>HP</b> : ${stats[0].base_stat}")
            details_pokemon_attack.text = Html.fromHtml("<b>Attack</b> : ${stats[1].base_stat}")
            details_pokemon_defence.text = Html.fromHtml("<b>Defence</b> : ${stats[2].base_stat}")
            details_pokemon_special_attack.text = Html.fromHtml("<b>Special Attack</b> : ${stats[3].base_stat}")
            details_pokemon_special_defence.text = Html.fromHtml("<b>Special Defence</b> : ${stats[4].base_stat}")
            details_pokemon_special_speed.text = Html.fromHtml("<b>Speed</b> : ${stats[5].base_stat}")
        })
    }
}