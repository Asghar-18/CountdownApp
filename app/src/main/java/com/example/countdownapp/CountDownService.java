package com.example.countdownapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class CountDownService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(
                () -> {
                    while (true) {
                        Log.d("TAG", "The CountDown is commencing....... ");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ignored) {

                        }
                    }
                }
        ).start();

        final String CHANNEL_ID = "CountDown Service";
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_LOW);
        getSystemService(NotificationManager.class).createNotificationChannel(channel);
        Notification.Builder notification = new Notification.Builder(this, CHANNEL_ID)
                .setContentText("CountDown App")
                .setContentTitle("This is Title");

        startForeground(1001, notification.build());
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}