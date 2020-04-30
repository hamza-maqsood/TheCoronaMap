package com.grayhatdevelopers.thecoronamap.ui.fragments.selectcountry

sealed class SelectCountryActions {
    object ShowCountryOptions: SelectCountryActions()
    object Continue: SelectCountryActions()
}
