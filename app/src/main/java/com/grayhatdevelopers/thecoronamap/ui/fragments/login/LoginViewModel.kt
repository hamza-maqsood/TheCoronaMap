package com.grayhatdevelopers.thecoronamap.ui.fragments.login

import com.grayhatdevelopers.thecoronamap.ui.fragments.base.BaseViewModel
import com.grayhatdevelopers.thecoronamap.utils.SingleLiveEvent

class LoginViewModel : BaseViewModel() {

    val loginActions: SingleLiveEvent<LoginActions> = SingleLiveEvent()

    fun proceed() {
        loginActions.postValue(LoginActions.Proceed)
    }
}