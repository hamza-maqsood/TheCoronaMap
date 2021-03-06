package com.grayhatdevelopers.thecoronamap.ui.fragments.base

import android.os.Bundle
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.grayhatdevelopers.kontrol.ui.fragments.base.LaunchIntentCommand
import com.grayhatdevelopers.kontrol.ui.fragments.base.NavigationCommand
import com.grayhatdevelopers.thecoronamap.repo.Repository
import com.grayhatdevelopers.thecoronamap.utils.SingleLiveEvent

open class BaseViewModel() : ViewModel(), Observable {

    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }
    val repo = Repository.getInstance()

    val navigationCommand: SingleLiveEvent<NavigationCommand> =
        SingleLiveEvent()
    val launchIntentCommand: SingleLiveEvent<LaunchIntentCommand> =
        SingleLiveEvent()


    fun navigate(directions: NavDirections, bundle: Bundle?) {
        navigationCommand.postValue(NavigationCommand.To(directions, bundle))
    }

    fun navigate(directions: NavDirections) {
        navigationCommand.postValue(NavigationCommand.To(directions, null))
    }


    fun popBack() {
        navigationCommand.postValue(NavigationCommand.Back)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }
}