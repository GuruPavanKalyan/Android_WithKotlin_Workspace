package com.example.taskonviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var textView2: TextView
    var count:Int = 0
    var arr = arrayOf("Apple","bat","cat","dog","eagel","fun")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.word)
        textView2 = findViewById(R.id.word2)
        textView.text = arr[0]
    }

    fun addWord(view: View) {
        if(count == arr.size){

        }else{
            count++
        }
        if(count<arr.size){
            Log.d("COUNTM",count.toString())
            if(count == arr.size-1){
                textView.append(" "+arr[count])
            }else{
                textView.append(" "+arr[count])
            }
        }


    }

    fun gotoPrevious(view: View) {
        if(count>0){
            count--
            Log.d("COUNTM",count.toString())
            if(count == 0){
                textView2.text = arr[0]
            }
            textView2.text = arr[count]
        }

    }
    fun gotoNext(view: View) {
        count++
        if(count == arr.size){
            count = arr.size-1
        }
        if(count<arr.size){
            Log.d("COUNTM",count.toString())
            textView2.text = arr[count]
        }

    }

}
