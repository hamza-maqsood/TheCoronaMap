package com.grayhatdevelopers.thecoronamap.ui.fragments.navigationdrawer

sealed class NavigationDrawerActions {
    object OpenSafetyTips: NavigationDrawerActions()
    object OpenSettings: NavigationDrawerActions()
    object OpenAbout: NavigationDrawerActions()
    object OpenContact: NavigationDrawerActions()
    object SignOutUser: NavigationDrawerActions()
}