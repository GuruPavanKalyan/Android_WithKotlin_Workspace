package com.example.calendereventaddingintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openCalender(view: View) {
        val cal = Calendar.getInstance()
        val intent = Intent(Intent.ACTION_EDIT)
        intent.type = "vnd.android.cursor.item/event"
        intent.putExtra("beginTime", cal.getTimeInMillis())
        intent.putExtra("allDay", true)
        intent.putExtra("rrule", "FREQ=YEARLY")
        intent.putExtra("endTime", cal.getTimeInMillis() + 60 * 60 * 1000)
        intent.putExtra("title", "A Test Event from android app")
        startActivity(intent)

    }
}
