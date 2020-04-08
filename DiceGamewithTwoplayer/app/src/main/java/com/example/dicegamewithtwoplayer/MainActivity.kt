package com.example.dicegamewithtwoplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.dicegamewithtwoplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var r1:Int = 0
    var r2:Int = 0
    lateinit var dataBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

    }

    fun roll(view: View) {
        r1 = (1..6).random()
        r2 = (1..6).random()
        var d = MyData(r1,r2)
        displayDice1(d.r1)
        displayDice2(d.r2)

        dataBinding.result.text = d.r1.toString()+"----"+d.r2.toString()
    }

    private fun displayDice2(r2: Int) {
        when(r2) {
            1 -> dataBinding.pdice2.setImageResource(R.drawable.dice_1)
            2 -> dataBinding.pdice2.setImageResource(R.drawable.dice_2)
            3 -> dataBinding.pdice2.setImageResource(R.drawable.dice_3)
            4 -> dataBinding.pdice2.setImageResource(R.drawable.dice_4)
            5 -> dataBinding.pdice2.setImageResource(R.drawable.dice_5)
            6 -> dataBinding.pdice2.setImageResource(R.drawable.dice_6)
            else -> {
                dataBinding.pdice2.setImageResource(R.drawable.empty_dice)
            }
        }
    }

    private fun displayDice1(r1: Int) {
        when(r1){
            1 -> dataBinding.pdice1.setImageResource(R.drawable.dice_1)
            2 -> dataBinding.pdice1.setImageResource(R.drawable.dice_2)
            3 -> dataBinding.pdice1.setImageResource(R.drawable.dice_3)
            4 -> dataBinding.pdice1.setImageResource(R.drawable.dice_4)
            5 -> dataBinding.pdice1.setImageResource(R.drawable.dice_5)
            6 -> dataBinding.pdice1.setImageResource(R.drawable.dice_6)
            else -> {
                dataBinding.pdice1.setImageResource(R.drawable.empty_dice)
            }
        }
    }

    fun upCount(view: View) {
        if((r1 == 0) and (r2 == 0)){
            dataBinding.pdice1.setImageResource(R.drawable.dice_1)
            dataBinding.pdice2.setImageResource(R.drawable.dice_1)
        }else if((r1<6) and (r2<6)){
            var d = MyData(r1,r2)
            d.r1++
            d.r2++
            dataBinding.result.text = d.r1.toString()+"----"+d.r2.toString()
            displayDice1(d.r1)
            displayDice2(d.r2)
        }


    }
}
