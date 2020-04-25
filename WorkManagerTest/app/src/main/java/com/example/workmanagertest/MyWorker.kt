package com.example.workmanagertest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyWorker(val context: Context,workerParameters: WorkerParameters):Worker(context,workerParameters){
    override fun doWork(): Result {
        CoroutineScope(Dispatchers.Main).launch {
            waitfor5seconds()
        }
        return Result.success()
    }

    suspend fun waitfor5seconds(){
        Thread.sleep(5000)
        showNotification(context)
    }

    private fun showNotification(context: Context) {
        val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (android.os.Build.VERSION.SDK_INT >=
            android.os.Build.VERSION_CODES.O) {
            val notificationChannel: NotificationChannel =
                NotificationChannel("NOTIFY","MYNEWCHANNEL", NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification from Mascot");
            notificationManager.createNotificationChannel(notificationChannel)
        }
        val notification = NotificationCompat.Builder(context,"NOTIFY")
            .setContentTitle("WORK FINISHED")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentText("This Notification is created by mastan ")
            .build()
        notificationManager.notify(23,notification)

    }

}