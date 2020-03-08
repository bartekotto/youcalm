package com.example.youcalm.ui.breathe

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import com.example.youcalm.MainActivity
import com.example.youcalm.R

class NotificationReceiver : BroadcastReceiver() {
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "com.example.youcalm.ui.breathe"
    private val description = "Breath reminder"
    override fun onReceive(context: Context?, intent: Intent?) {
        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        val pendingIntent: PendingIntent =
            PendingIntent.getActivity(context, 100, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        notificationManager =
            context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = Notification.Builder(context, channelId)
                .setSmallIcon(R.mipmap.breathe_foreground)
                .setContentTitle("Breathing exercises")
                .setContentText("How are you? Take a couple deep breaths :)")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
            notificationChannel =
                NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_DEFAULT)
            notificationChannel.enableVibration(true)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationManager.createNotificationChannel(notificationChannel)
            notificationManager.notify(1234, builder.build())
        }
    }

}
