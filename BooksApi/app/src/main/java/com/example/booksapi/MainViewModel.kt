package com.example.booksapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel(){
    val list = MutableLiveData<MutableList<MyData>>()

    init {
        val items = mutableListOf<MyData>()
        list.value = items
    }
}