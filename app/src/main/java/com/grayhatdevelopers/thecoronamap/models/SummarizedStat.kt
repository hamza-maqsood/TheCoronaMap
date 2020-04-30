package com.grayhatdevelopers.thecoronamap.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.grayhatdevelopers.thecoronamap.BR
import com.grayhatdevelopers.thecoronamap.utils.toFormattedString

data class SummarizedStatData(
    val confirmed__sum: String = "0",
    val dead__sum: String = "0",
    val recovered__sum: String = "0",
    val active_cases__sum: String = "0",
    val new_cases__sum: String = "0",
    val new_dead__sum: String = "0",
    val new_recovered__sum: String = "0"
)

@Suppress("PropertyName")
data class SummarizedStat(
    private var confirmed__sum: Long,
    private var dead__sum: Long,
    private var recovered__sum: Long,
    private var active_cases__sum: Long,
    private var new_cases__sum: Long,
    private var new_dead__sum: Long,
    private var new_recovered__sum: Long
) : BaseObservable() {

    var _confirmed__sum: Long
        @Bindable get() = confirmed__sum
        set(value) {
            confirmed__sum = value
            notifyPropertyChanged(BR._confirmed__sum)
        }

    var _dead__sum: Long
        @Bindable get() = dead__sum
        set(value) {
            dead__sum = value
            notifyPropertyChanged(BR._dead__sum)
        }

    var _recovered__sum: Long
        @Bindable get() = recovered__sum
        set(value) {
            recovered__sum = value
            notifyPropertyChanged(BR._recovered__sum)
        }

    var _active_cases__sum: Long
        @Bindable get() = active_cases__sum
        set(value) {
            active_cases__sum = value
            notifyPropertyChanged(BR._active_cases__sum)
        }


    var _new_cases__sum: Long
        @Bindable get() = new_cases__sum
        set(value) {
            new_cases__sum = value
            notifyPropertyChanged(BR._new_cases__sum)
        }

    var _new_dead__sum: Long
        @Bindable get() = new_dead__sum
        set(value) {
            new_dead__sum = value
            notifyPropertyChanged(BR._new_dead__sum)
        }

    var _new_recovered__sum: Long
        @Bindable get() = new_recovered__sum
        set(value) {
            new_recovered__sum = value
            notifyPropertyChanged(BR._new_recovered__sum)
        }
}


fun SummarizedStat.toSummarizedData() = SummarizedStatData(
    confirmed__sum = _confirmed__sum.toFormattedString(),
    dead__sum = _dead__sum.toFormattedString(),
    recovered__sum = _recovered__sum.toFormattedString(),
    active_cases__sum = _active_cases__sum.toFormattedString(),
    new_cases__sum = _new_cases__sum.toFormattedString(),
    new_dead__sum = _new_dead__sum.toFormattedString(),
    new_recovered__sum = _new_recovered__sum.toFormattedString()
)