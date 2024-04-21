package com.stathis.pokedex.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.stathis.core.base.BaseFragment
import com.stathis.core.ext.onQueryTextSubmit
import com.stathis.pokedex.R
import com.stathis.pokedex.databinding.FragmentDashboardBinding
import com.stathis.pokedex.navigator.NavAction
import com.stathis.pokedex.ui.MainViewModel
import com.stathis.pokedex.ui.dashboard.adapter.DashboardAdapter
import com.stathis.pokedex.ui.dashboard.adapter.DashboardCallback
import com.stathis.pokedex.ui.dashboard.uimodel.DashboardItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>(R.layout.fragment_dashboard),
    DashboardCallback {

    private val viewModel: DashboardViewModel by viewModels()
    private val sharedVM: MainViewModel by activityViewModels()
    private val adapter = DashboardAdapter(this)

    override fun init() {
        viewModel.showDashboardItems()
        binding.dashboardRecycler.adapter = adapter

        binding.dashboardSearchView.onQueryTextSubmit { query ->
            goToResultScreen(query)
        }
    }

    override fun startOps() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.options.collect {
                adapter.submitList(it)
            }
        }
    }

    override fun stopOps() {}

    override fun onDashboardItemTap(item: DashboardItem) {
        //handle clicks respectively
    }

    private fun goToResultScreen(query: String) {
        val data = Bundle().apply { putString("QUERY", query) }
        sharedVM.navigateToScreen(NavAction.SEARCH, data)
    }
}