package com.stathis.core.ext

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.stathis.core.R
import com.stathis.domain.models.Pokemon

@BindingAdapter("loadSvgImage")
fun ImageView.loadSvgImage(imageUrl: String) {
    val imageLoader = ImageLoader.Builder(context)
        .components { add(SvgDecoder.Factory()) }
        .build()

    val request = ImageRequest.Builder(context)
        .crossfade(true)
        .crossfade(1000)
        .placeholder(R.drawable.pokeball)
        .data(imageUrl)
        .target(this)
        .build()

    imageLoader.enqueue(request)
}

@BindingAdapter("showPokemonAbilities")
fun TextView.showPokemonAbilities(pokemon: Pokemon) {
    text = pokemon.abilities.joinToString { it.name.capitalize() }
}