package com.grayhatdevelopers.thecoronamap.ui.fragments.home

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.grayhatdevelopers.thecoronamap.application.MainApplication
import com.grayhatdevelopers.thecoronamap.models.SummarizedStatData
import com.grayhatdevelopers.thecoronamap.models.toSummarizedData
import com.grayhatdevelopers.thecoronamap.ui.fragments.base.BaseViewModel
import com.grayhatdevelopers.thecoronamap.utils.SingleLiveEvent
import com.grayhatdevelopers.thecoronamap.utils.getCurrentTime
import com.grayhatdevelopers.thecoronamap.utils.hasNetwork
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

    @Bindable
    val showExpandedStatsView: MutableLiveData<Boolean> = MutableLiveData()
    @Bindable
    val showOptionsMenu: MutableLiveData<Boolean> = MutableLiveData()

    val summarizedStats: MutableLiveData<SummarizedStatData> = MutableLiveData()

    init {
        showExpandedStatsView.postValue(false)
        showOptionsMenu.postValue(false)
        summarizedStats.postValue(getCachedSummarizedData())
        if (hasNetwork(MainApplication.context!!))
            refreshSummarizedData()
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

    fun openSymptomsChecker() {
        homeActions.postValue(HomeActions.OpenSymptomsChecker)
    }

    fun showOrHideOptionsMenu() {
        if (showOptionsMenu.value!!) { // hide options menu
            showOptionsMenu.postValue(false)
        } else { // show it
            showOptionsMenu.postValue(true)
        }
    }

    private fun refreshSummarizedData() {
        viewModelScope.launch {
            Log.d(TAG, "date: ${getCurrentTime()}")
            val response = repo.getTodayStats(getCurrentTime())
            if (response.isSuccessful) {
                Log.d(TAG, "Refreshing data was successful: ${response.code()}")
                val data = response.body()!!
                summarizedStats.postValue(data.toSummarizedData())
                Log.d(TAG, "data: ${data.toSummarizedData()}")
                repo.sharedPreferencesHelper.saveSummarizedStatsData(data.toSummarizedData())
            } else Log.d(TAG, "Refreshing data failed: ${response.code()}")
        }
    }

    private fun getCachedSummarizedData(): SummarizedStatData = repo.sharedPreferencesHelper.getSummarizedStatsData()

    companion object {
        private const val TAG = "HomeViewModel"
    }
}