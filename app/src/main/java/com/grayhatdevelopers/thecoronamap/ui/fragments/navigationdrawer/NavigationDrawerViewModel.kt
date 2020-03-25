package com.grayhatdevelopers.thecoronamap.ui.fragments.navigationdrawer

import com.grayhatdevelopers.thecoronamap.ui.fragments.base.BaseViewModel
import com.grayhatdevelopers.thecoronamap.utils.SingleLiveEvent

class NavigationDrawerViewModel : BaseViewModel() {

    val navigationDrawerActions: SingleLiveEvent<NavigationDrawerActions> = SingleLiveEvent()

    fun openSafetyTips() {

    }

    fun openAbout() {

    }

    fun openContact() {

    }

    fun openSettings() {

    }

    fun signOutUser() {

    }
}