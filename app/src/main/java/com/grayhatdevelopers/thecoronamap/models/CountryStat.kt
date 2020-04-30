package com.grayhatdevelopers.thecoronamap.models

data class CountryStat(
    val name: String = "",
    val casesCount: Int = 0,
    val deathsCount: Int = 0,
    val recoveredCount: Int = 0,
    val casesPercentile: Double = 0.toDouble(),
    val deathsPercentile: Double = 0.toDouble(),
    val recoveredPercentile: Double = 0.toDouble(),
    var mortalityRate: Double = 0.toDouble()
) {
    init {
       mortalityRate = (deathsCount * 100) / casesCount.toDouble()
    }
}