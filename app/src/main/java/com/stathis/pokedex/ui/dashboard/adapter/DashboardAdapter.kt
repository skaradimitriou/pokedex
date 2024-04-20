package com.stathis.pokedex.ui.dashboard.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.stathis.core.base.BaseDiffUtil
import com.stathis.core.base.BaseViewHolder
import com.stathis.domain.models.UiModel
import com.stathis.pokedex.BR
import com.stathis.pokedex.databinding.HolderDashboardItemBinding
import com.stathis.pokedex.ui.dashboard.uimodel.DashboardItem

class DashboardAdapter(
    private val callback: DashboardCallback
) : ListAdapter<UiModel, DashboardViewHolder>(BaseDiffUtil<UiModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = HolderDashboardItemBinding.inflate(inflater, parent, false)
        return DashboardViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DashboardViewHolder(
    private val binding: ViewDataBinding,
    private val callback: DashboardCallback
) : BaseViewHolder(binding) {

    override fun present(data: UiModel) {
        binding.setVariable(BR.model, data)
        binding.setVariable(BR.callback, callback)
    }
}

fun interface DashboardCallback {
    fun onDashboardItemTap(item: DashboardItem)
}