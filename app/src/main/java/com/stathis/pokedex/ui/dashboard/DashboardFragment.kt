package com.stathis.pokedex.ui.dashboard

import androidx.fragment.app.viewModels
import com.stathis.core.base.BaseFragment
import com.stathis.pokedex.R
import com.stathis.pokedex.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>(R.layout.fragment_dashboard) {

    private val viewModel: DashboardViewModel by viewModels()

    override fun init() {

    }

    override fun startOps() {
        viewModel.fetchData()
    }

    override fun stopOps() {

    }
}