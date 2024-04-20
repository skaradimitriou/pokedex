package com.stathis.pokedex.ui.dashboard

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.stathis.core.base.BaseFragment
import com.stathis.pokedex.R
import com.stathis.pokedex.databinding.FragmentDashboardBinding
import com.stathis.pokedex.ui.dashboard.adapter.DashboardAdapter
import com.stathis.pokedex.ui.dashboard.adapter.DashboardCallback
import com.stathis.pokedex.ui.dashboard.uimodel.DashboardItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>(R.layout.fragment_dashboard),
    DashboardCallback {

    private val viewModel: DashboardViewModel by viewModels()
    private val adapter = DashboardAdapter(this)

    override fun init() {
        viewModel.showDashboardItems()
        binding.dashboardRecycler.adapter = adapter
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
}