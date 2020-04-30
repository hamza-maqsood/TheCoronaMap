package com.grayhatdevelopers.thecoronamap.repo

import com.grayhatdevelopers.thecoronamap.models.DateStat
import com.grayhatdevelopers.thecoronamap.models.SummarizedStat
import com.grayhatdevelopers.thecoronamap.utils.AppConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitDAO {

    @GET("${AppConstants.ROUTE_BY_DATE}/{date}")
    suspend fun getAllCountriesData(@Path(value = "date", encoded = true) date: String): Response<List<DateStat>>

    @GET("${AppConstants.ROUTE_GET_BY_COUNTRY}/{country_code}")
    suspend fun getByCountry(@Path(value = "country_code", encoded = true) country_code: Int): Response<List<DateStat>>

    @GET("${AppConstants.GET_STATS_FOR_THE_DAY}/{date}")
    suspend fun getStatsForTheDay(@Path(value = "date", encoded = true) date: String): Response<SummarizedStat>
}