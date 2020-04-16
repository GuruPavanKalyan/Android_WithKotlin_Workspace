package com.example.newexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newexample.databinding.ActivityMainBinding
import timber.log.Timber



class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var mainViewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // Timber.i("we are on Oncreate")
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.mvmvar = mainViewModel
        binding.setLifecycleOwner(this)
       /* mainViewModel.count.observe(this, Observer {
            binding.textView.text = mainViewModel.count.value.toString()
        })*/
       /* binding.button.setOnClickListener{
            mainViewModel.increment()
            binding.textView.text=mainViewModel.count.value.toString()
        }
        binding.button2.setOnClickListener {
            mainViewModel.dicreament()
            binding.textView.text=mainViewModel.count.value.toString()
        }*/
    }
}
