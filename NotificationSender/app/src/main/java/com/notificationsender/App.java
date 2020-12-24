package com.notificationsender;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String Channel_Id_1="Channel 1";
    public static final String Channel_Id_2="Channel 2";

    public void onCreate(){
        super.onCreate();
        createNotification();
    }

    private void createNotification() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(Channel_Id_1,"This is Custom notification", NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("this is Message of Channel 1");

            NotificationChannel channel2 = new NotificationChannel(Channel_Id_2,"This is Custom notification 2", NotificationManager.IMPORTANCE_LOW);
            channel1.setDescription("this is Message of Channel 2");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }
}
