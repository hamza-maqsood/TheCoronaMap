package com.grayhatdevelopers.thecoronamap.models

data class CountryStat(
    val casesCount: Int = 0,
    val deathsCount: Int = 0,
    val recoveredCount: Int = 0,
    val casesPercentile: Int = 0,
    val deathsPercentile: Int = 0,
    val recoveredPercentile: Int = 0
)