package com.grayhatdevelopers.thecoronamap.repo

import androidx.lifecycle.MutableLiveData
import com.grayhatdevelopers.thecoronamap.models.CountryStat


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

    val countryStats: MutableLiveData<List<CountryStat>> = MutableLiveData()

}