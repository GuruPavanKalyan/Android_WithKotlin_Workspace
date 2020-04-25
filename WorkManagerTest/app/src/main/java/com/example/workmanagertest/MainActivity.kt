package com.example.workmanagertest

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.SyncRequest
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.lifecycle.Observer
import androidx.work.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    lateinit var btn:Button
    lateinit var constraints: Constraints
    lateinit var workRequest: WorkRequest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.button)

        constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        workRequest = PeriodicWorkRequestBuilder<MyWorker>(1,TimeUnit.SECONDS)
            .setConstraints(constraints)
            .build()


        btn.setOnClickListener {

            WorkManager.getInstance(this).enqueue(workRequest)
        }

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(workRequest.id).observe(this, Observer { workInfo ->
            val tv:TextView = findViewById(R.id.textView)
            if (workInfo!=null && (workInfo.state == WorkInfo.State.SUCCEEDED)){
                tv.text = "Work Finished"
            } else if(workInfo!=null && workInfo.state == WorkInfo.State.RUNNING){
                tv.text = "WORK Running"

            }
        })

    }


}
