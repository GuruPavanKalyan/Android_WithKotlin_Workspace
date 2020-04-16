package com.example.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
   // var list:MutableList<String> = mutableListOf()
    //var index = 0
    lateinit var mainViewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.word.observe(this, Observer {
            binding.word2.text = mainViewModel.word.value
        })

        mainViewModel.wordList.observe(this, Observer {
            binding.word.text = mainViewModel.wordList.value
        })
        //initList()
        binding.updatebutton.setOnClickListener {
            mainViewModel.upDateList()
        }
       binding.nextbutton.setOnClickListener {
           mainViewModel.nextWord()
       }
        binding.prevbutton.setOnClickListener {

           mainViewModel.previousWord()
        }

    }

   /* private fun updateList() {
        for (i in 0..9){
            list.add("cat ${i+1}")
        }
        displayValues()
    }
*/
   /* private fun displayValues() {
        binding.word.text = ""
        for (i in list){
            binding.word.append(i+" ")
        }
    }

    private fun initList() {
        list = mutableListOf("Apple","bat")
        displayword(0)
       displayValues()
    }

    fun displayword(i:Int){
        binding.word2.text = list.get(i)
    }*/
}
