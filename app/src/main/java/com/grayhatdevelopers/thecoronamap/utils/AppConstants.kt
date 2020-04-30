package com.grayhatdevelopers.thecoronamap.utils

object AppConstants {


    /**
     * MAPBOX token
     */
    const val MAP_BOX_TOKEN =
        "pk.eyJ1IjoiZ3JheWhhdGRldmVsb3BlcnMiLCJhIjoiY2s0YWNqNjVyMDJrMTNycDh2OTd5MTBpdiJ9.Lpq70iRl9mTIJA1q-cz7UQ"


    /**
     * end points
     */
    const val BASE_URL = "https://api.thecoronamap.com/"
    const val ROUTE_BY_DATE = "corona-stats"
    const val ROUTE_GET_BY_COUNTRY = "country-corona-stats"
    const val GET_STATS_FOR_THE_DAY = "total-stats"

    /**
     * app constants
     */
    const val DEFAULT_DATE_FORMAT = "YYYY-MM-dd"
    const val SAVED_SUMMARIZED_DATA = "saved_summary"
    const val SAVED_COUNTRY_STATS = "saved_country_stats"
}