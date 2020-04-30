package com.grayhatdevelopers.thecoronamap.ui.fragments.selectcountry

import com.grayhatdevelopers.thecoronamap.ui.fragments.base.BaseViewModel
import com.grayhatdevelopers.thecoronamap.utils.SingleLiveEvent

class SelectCountryViewModel : BaseViewModel() {

    val selectCountryActions : SingleLiveEvent<SelectCountryActions> = SingleLiveEvent()

    fun continueToLogin() {
        selectCountryActions.postValue(SelectCountryActions.Continue)
    }

}