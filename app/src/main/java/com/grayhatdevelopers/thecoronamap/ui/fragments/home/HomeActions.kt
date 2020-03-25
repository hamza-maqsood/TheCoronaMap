package com.grayhatdevelopers.thecoronamap.ui.fragments.home

sealed class HomeActions {
    object OpenFulMap : HomeActions()
    object OpenReportFragment: HomeActions()
    data class ShowOrHideExpandedStats(val show: Boolean) : HomeActions()
}