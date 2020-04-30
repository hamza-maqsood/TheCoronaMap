package com.grayhatdevelopers.thecoronamap.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

fun getCurrentTime(): String {
    val sdf = SimpleDateFormat(AppConstants.DEFAULT_DATE_FORMAT, Locale.ENGLISH)
    val calender = Calendar.getInstance()
    calender.time = Date()
    calender.add(Calendar.DATE, -1)
    val yesterday = calender.time
    return sdf.format(yesterday)
}

fun Long.toFormattedString(): String = NumberFormat.getNumberInstance(Locale.getDefault()).format(this)

fun hasNetwork(context: Context): Boolean {
    var isConnected: Boolean = false // Initial Value
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    if (activeNetwork != null && activeNetwork.isConnected)
        isConnected = true
    return isConnected
}