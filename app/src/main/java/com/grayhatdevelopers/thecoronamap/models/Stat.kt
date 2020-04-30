package com.grayhatdevelopers.thecoronamap.models

data class Stat(
    val new_dead: Int = 0,
    val new_recovered: Int = 0,
    val new_cases: Int = 0,
    val active_cases: Int = 0,
    val date: String = ""
)