package com.grayhatdevelopers.thecoronamap.ui.fragments.home

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.grayhatdevelopers.thecoronamap.ui.fragments.base.BaseViewModel
import com.grayhatdevelopers.thecoronamap.utils.SingleLiveEvent

class HomeViewModel : BaseViewModel() {

    @Bindable
    val showExpandedStatsView: MutableLiveData<Boolean> = MutableLiveData()
    @Bindable
    val showOptionsMenu: MutableLiveData<Boolean> = MutableLiveData()

    init {
        showExpandedStatsView.postValue(false)
        showOptionsMenu.postValue(false)
    }

    val homeActions: SingleLiveEvent<HomeActions> = SingleLiveEvent()

    fun openFullMap() {
        homeActions.postValue(HomeActions.OpenFulMap)
    }

    fun openReportFragment() {
        homeActions.postValue(HomeActions.OpenReportFragment)
    }

    fun showOrHideExpandedStats() {
        if (showExpandedStatsView.value!!) { // hide the view
            showExpandedStatsView.postValue(false)
            homeActions.postValue(HomeActions.ShowOrHideExpandedStats(show = false))
        } else { // make the view visible
            showExpandedStatsView.postValue(true)
            homeActions.postValue(HomeActions.ShowOrHideExpandedStats(show = true))
        }
    }

    fun showOrHideOptionsMenu() {
        if (showOptionsMenu.value!!) { // hide options menu
            showOptionsMenu.postValue(false)
        } else { // show it
            showOptionsMenu.postValue(true)
        }
    }
}