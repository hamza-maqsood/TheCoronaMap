package com.grayhatdevelopers.thecoronamap.models

data class DateStat(
    val dead: Int = 0,
    val recovered: Int = 0,
    val confirmed: Int = 0,
    val active_cases: Int = 0,
    val country_name: String = "",
    val country_pk: Int = 0
)

fun DateStat.toCountryStat() = CountryStat(
    name = country_name,
    casesCount = confirmed,
    deathsCount = dead,
    recoveredCount = recovered
)