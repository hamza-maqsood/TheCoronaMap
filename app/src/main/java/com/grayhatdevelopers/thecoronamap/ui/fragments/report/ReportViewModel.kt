package com.grayhatdevelopers.thecoronamap.ui.fragments.report

import com.grayhatdevelopers.thecoronamap.ui.fragments.base.BaseViewModel
import com.grayhatdevelopers.thecoronamap.utils.SingleLiveEvent

class ReportViewModel : BaseViewModel() {

    val reportFragmentActions: SingleLiveEvent<ReportFragmentActions> = SingleLiveEvent()

    fun goBack() {
        reportFragmentActions.postValue(ReportFragmentActions.GoBack)
    }
}