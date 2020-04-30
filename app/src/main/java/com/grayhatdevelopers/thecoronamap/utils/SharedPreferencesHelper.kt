package com.grayhatdevelopers.thecoronamap.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.grayhatdevelopers.thecoronamap.models.CountryStat
import com.grayhatdevelopers.thecoronamap.models.SummarizedStatData


class SharedPreferencesHelper(context: Context) {

    private val sharedPreferences: SharedPreferences = SharedPreferences.getInstance(context)

    fun saveSummarizedStatsData(data: SummarizedStatData) {
        sharedPreferences.saveString(AppConstants.SAVED_SUMMARIZED_DATA, Gson().toJson(data))

    }

    fun getSummarizedStatsData(): SummarizedStatData {
        val json = sharedPreferences.getString(AppConstants.SAVED_SUMMARIZED_DATA, "")
        return Gson().fromJson(json, SummarizedStatData::class.java) ?: SummarizedStatData()
    }

    fun saveCountriesData(data: List<CountryStat>) {
        sharedPreferences.saveString(AppConstants.SAVED_COUNTRY_STATS, Gson().toJson(data))
    }

    fun getCountriesData(): List<CountryStat> {
        val json = sharedPreferences.getString(AppConstants.SAVED_COUNTRY_STATS, "")
        val token: TypeToken<List<CountryStat>> =
            object : TypeToken<List<CountryStat>>() {}
        return Gson().fromJson(json, token.type) ?: ArrayList()
    }
}