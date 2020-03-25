package com.grayhatdevelopers.thecoronamap.adapters.countrystats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.grayhatdevelopers.thecoronamap.R
import com.grayhatdevelopers.thecoronamap.adapters.DataBoundListAdapter
import com.grayhatdevelopers.thecoronamap.databinding.ItemCountryStatsBinding
import com.grayhatdevelopers.thecoronamap.models.CountryStat

class CountryStatsAdapter : DataBoundListAdapter<CountryStat>(
    diffCallback = object : DiffUtil.ItemCallback<CountryStat>() {
        override fun areItemsTheSame(oldItem: CountryStat, newItem: CountryStat): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CountryStat, newItem: CountryStat): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_country_stats,
            parent,
            false
        )
    }

    override fun bind(binding: ViewDataBinding, item: CountryStat, position: Int) {
        when (binding) {
            is ItemCountryStatsBinding -> {
                binding.data = item
            }
        }
    }
}