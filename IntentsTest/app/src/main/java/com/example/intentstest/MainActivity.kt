package com.example.intentstest

import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.intentstest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var dataBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        dataBinding.takebtn.setOnClickListener{ gotoNext()}
    }

    private fun gotoNext() {
        val i:Intent=Intent(this,SecondActivity::class.java)
        i.putExtra("key","Hello Hi everyone")
        startActivity(i)
    }

}
