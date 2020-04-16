package com.example.assignment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val list = MutableLiveData<MutableList<String>>()
    var index = MutableLiveData<Int>()
    var word = MutableLiveData<String>()
    var wordList = MutableLiveData<String>()

    init {
        val items = mutableListOf("Apple", "bat")
        list.value = items
        index.value = 0
        displayWord(index.value!!)
        createWordString(list.value!!)

    }

    private fun createWordString(value: MutableList<String>) {
        var w:String = ""
        for (i in value){
            w = w+i+" "
        }
        wordList.value = w
    }

    fun upDateList() {
        val items = list.value
        for (i in 0..9) {
            items?.add("cat ${i + 1}")
        }
        list.value = items
        createWordString(list.value!!)

    }

    fun nextWord() {
        if (index.value?.plus(1)!! < list.value?.size!!) {
            index.value = index.value?.plus(1)
            displayWord(index.value!!)
        }
    }


    fun previousWord() {
        if (index.value?.minus(1)!! >= 0) {
            index.value = index.value?.minus(1)
            displayWord(index.value!!)
        }
    }

    private fun displayWord(index: Int) {
        val items = list.value
        word.value = items?.get(index)

    }
}