package com.grayhatdevelopers.thecoronamap.application

import android.content.Context
import androidx.multidex.MultiDexApplication

class MainApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        var context: Context? = null
    }
}