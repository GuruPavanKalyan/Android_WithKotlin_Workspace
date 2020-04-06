package com.example.dicegamewithtwoplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var img1:ImageView
    lateinit var img2:ImageView
    var r1:Int = 0
    var r2:Int = 0
    lateinit var tv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img1 = findViewById(R.id.pdice1)
        img2 = findViewById(R.id.pdice2)
        tv=findViewById(R.id.result)
    }

    fun roll(view: View) {
        r1 = (1..6).random()
        r2 = (1..6).random()
        displayDice1(r1)
        displayDice2(r2)

        tv.text = r1.toString()+"----"+r2.toString()
    }

    private fun displayDice2(r2: Int) {
        when(r2) {
            1 -> img2.setImageResource(R.drawable.dice_1)
            2 -> img2.setImageResource(R.drawable.dice_2)
            3 -> img2.setImageResource(R.drawable.dice_3)
            4 -> img2.setImageResource(R.drawable.dice_4)
            5 -> img2.setImageResource(R.drawable.dice_5)
            6 -> img2.setImageResource(R.drawable.dice_6)
            else -> {
                img2.setImageResource(R.drawable.empty_dice)
            }
        }
    }

    private fun displayDice1(r1: Int) {
        when(r1){
            1 -> img1.setImageResource(R.drawable.dice_1)
            2 -> img1.setImageResource(R.drawable.dice_2)
            3 -> img1.setImageResource(R.drawable.dice_3)
            4 -> img1.setImageResource(R.drawable.dice_4)
            5 -> img1.setImageResource(R.drawable.dice_5)
            6 -> img1.setImageResource(R.drawable.dice_6)
            else -> {
                img1.setImageResource(R.drawable.empty_dice)
            }
        }
    }

    fun upCount(view: View) {
        if((r1 == 0) and (r2 == 0)){
            img1.setImageResource(R.drawable.dice_1)
            img2.setImageResource(R.drawable.dice_1)
        }else if((r1<6) and (r2<6)){
            r1++
            r2++
            tv.text = r1.toString()+"----"+r2.toString()
            displayDice1(r1)
            displayDice2(r2)
        }


    }
}
