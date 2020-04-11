package com.example.intentstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.intentstest.databinding.ActivityMainBinding

class SecondActivity : AppCompatActivity() {

    lateinit var tv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_second)
        tv = findViewById(R.id.res)
        val d = intent.getShortArrayExtra("key")
        tv.text = d.toString()


    }
}
