package com.grayhatdevelopers.thecoronamap.ui.fragments.login

sealed class LoginActions {
    object LoginWithPhoneNumber: LoginActions()
    object LoginWithFacebook: LoginActions()
    object LoginWithGoogle: LoginActions()
    object Proceed : LoginActions()
}