package com.example.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var img:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img = findViewById(R.id.imageview)
    }

    fun showToast(view: View) {
        val r = (1..6).random()
        val tv:TextView = findViewById(R.id.result)
        tv.text = r.toString();
        displayDice(r)
        val toast:Toast = Toast.makeText(this,
            "The random number is generated "+r,Toast.LENGTH_LONG)
        toast.show();
    }

    private fun displayDice(r: Int){
        when(r){
            1 -> img.setImageResource(R.drawable.dice_1)
            2 -> img.setImageResource(R.drawable.dice_2)
            3 -> img.setImageResource(R.drawable.dice_3)
            4 -> img.setImageResource(R.drawable.dice_4)
            5 -> img.setImageResource(R.drawable.dice_5)
            6 -> img.setImageResource(R.drawable.dice_6)
            else -> {
                img.setImageResource(R.drawable.empty_dice)
            }
        }

    }

}
