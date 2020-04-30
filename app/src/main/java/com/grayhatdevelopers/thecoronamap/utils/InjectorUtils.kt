package com.grayhatdevelopers.thecoronamap.utils

import com.grayhatdevelopers.kontrol.ui.fragments.base.BaseViewModelFactory
import com.grayhatdevelopers.thecoronamap.ui.fragments.base.BaseViewModel
import com.grayhatdevelopers.thecoronamap.ui.fragments.home.HomeViewModel
import com.grayhatdevelopers.thecoronamap.ui.fragments.login.LoginViewModel
import com.grayhatdevelopers.thecoronamap.ui.fragments.navigationdrawer.NavigationDrawerViewModel
import com.grayhatdevelopers.thecoronamap.ui.fragments.report.ReportViewModel
import com.grayhatdevelopers.thecoronamap.ui.fragments.selectcountry.SelectCountryViewModel

object InjectorUtils {

    fun provideBaseViewModel() = BaseViewModelFactory().create(BaseViewModel::class.java)
    fun provideHomeViewModel() = BaseViewModelFactory().create(HomeViewModel::class.java)
    fun provideReportViewModel() = BaseViewModelFactory().create(ReportViewModel::class.java)
    fun provideNavigationDrawerViewModel() = BaseViewModelFactory().create(NavigationDrawerViewModel::class.java)
    fun provideLoginViewModel() = BaseViewModelFactory().create(LoginViewModel::class.java)
    fun provideSelectLanguageViewModel() = BaseViewModelFactory().create(SelectCountryViewModel::class.java)
}