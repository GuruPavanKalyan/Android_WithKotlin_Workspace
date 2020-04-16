package com.example.newexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber


class MainViewModel :ViewModel(){
    var count = MutableLiveData<Int>()
    init {
        Timber.i("View Model Created")
        count.value = 0
    }

    fun increment(){
        count.value = count.value?.plus(1)
    }
    fun dicreament(){
        count.value = count.value?.minus(1)
    }
}