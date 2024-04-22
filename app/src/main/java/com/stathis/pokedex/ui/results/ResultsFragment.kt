package com.stathis.pokedex.ui.results

import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.stathis.core.base.BaseFragment
import com.stathis.core.ext.onQueryTextSubmit
import com.stathis.core.ext.setScreenTitle
import com.stathis.domain.models.Pokemon
import com.stathis.pokedex.R
import com.stathis.pokedex.databinding.FragmentResultsBinding
import com.stathis.pokedex.ui.results.adapter.ResultsAdapter
import com.stathis.pokedex.ui.results.adapter.ResultsCallback
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class ResultsFragment : BaseFragment<FragmentResultsBinding>(R.layout.fragment_results),
    ResultsCallback {

    private val viewModel: ResultsViewModel by viewModels()

    private val adapter = ResultsAdapter(this)

    override fun init() {
        val query = arguments?.getString("QUERY") ?: ""
        setScreenTitle(String.format(getString(com.stathis.core.R.string.results_title), query))

        viewModel.searchForPokemon(query)

        binding.resultsRecycler.adapter = adapter

        binding.resultsSearchView.apply {
            setQuery(query, false)
            onQueryTextSubmit {
                viewModel.searchForPokemon(it)
            }
        }
    }

    override fun startOps() {
        lifecycleScope.launch {
            viewModel.result.flowWithLifecycle(lifecycle).collect {
                adapter.submitList(it)
            }
        }
    }

    override fun stopOps() {}

    override fun onPokemonClick(model: Pokemon) {
        Timber.d(model.toString())
    }
}