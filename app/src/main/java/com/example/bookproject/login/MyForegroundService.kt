package com.example.bookproject.login

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.bookproject.R

class MyForegroundService: Service() {

    override fun onCreate() {
        super.onCreate()
        Log.d("Service","onCrete")
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        createNotificationChannel()

        val notification = NotificationCompat.Builder(this, "foreground_channel")
            .setContentTitle("Foreground Service")
            .setContentText("Service is running...")
            .setSmallIcon(R.drawable.agat_logo)
            .build()
            startForeground(1, notification)

        Thread{
            for(i in 1..20){
                Log.d("SERVICE", "Working $i")
                Thread.sleep(1000)
            }
            stopSelf()
        }.start()


        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SERVICE", "onDestroy")
    }

    fun createNotificationChannel(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val channel = NotificationChannel(
                "foreground_channel",
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
                        val manager = getSystemService(NotificationManager::class.java)
                         manager.createNotificationChannel(channel)


        }
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}