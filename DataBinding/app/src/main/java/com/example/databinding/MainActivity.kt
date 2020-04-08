package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var dataBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        dataBinding.setBtn.setOnClickListener{setName()}

    }

    private fun setName() {
        val n = dataBinding.name.text.toString()
       /* dataBinding.sample1.text = n*/
        val d = MyName(n)
        dataBinding.n=d
        dataBinding.name.text.clear()
    }
}
