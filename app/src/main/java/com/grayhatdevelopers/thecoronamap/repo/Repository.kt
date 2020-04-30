package com.grayhatdevelopers.thecoronamap.repo

import androidx.lifecycle.MutableLiveData
import com.grayhatdevelopers.thecoronamap.application.MainApplication
import com.grayhatdevelopers.thecoronamap.models.CountryStat
import com.grayhatdevelopers.thecoronamap.models.toCountryStat
import com.grayhatdevelopers.thecoronamap.utils.SharedPreferencesHelper


class Repository private constructor() {


    companion object {
        // @Volatile - Writes to this property are immediately visible to other threads
        @Volatile
        private var instance: Repository? = null

        // The only way to get hold of the Repository object
        fun getInstance() =
        // Already instantiated? - return the instance
            // Otherwise instantiate in a thread-safe manner
            instance
                ?: synchronized(this) {
                    // If it's still not instantiated, finally create an object
                    // also set the "instance" property to be the currently created one
                    instance
                        ?: Repository().also { instance = it }
                }
    }

    private val retrofitAPI = ApiClient.createService(RetrofitDAO::class.java)

    val sharedPreferencesHelper: SharedPreferencesHelper = SharedPreferencesHelper(MainApplication.context!!)

    val countryStats: MutableLiveData<List<CountryStat>> = MutableLiveData()

    private var isDataLoaded = false

    private suspend fun getCountriesData(date: String) = retrofitAPI.getAllCountriesData(date)

    private suspend fun getStatsForDay(date: String) = retrofitAPI.getStatsForTheDay(date)

    suspend fun getAllCountriesData(date: String) {
        if (!isDataLoaded) {
            val response = getCountriesData(date)
            if (response.isSuccessful) {
                response.body()?.let {
                    val data = mutableListOf<CountryStat>()
                    for (e in it) {
                        data.add(e.toCountryStat())
                    }
                    sharedPreferencesHelper.saveCountriesData(data)
                }
            }
        }
        getCountriesCachedData()
    }

    fun getCountriesCachedData() {
        // post the data from shared preferences
        countryStats.postValue(sharedPreferencesHelper.getCountriesData())
    }

    suspend fun getTodayStats(date: String) = getStatsForDay(date)

}