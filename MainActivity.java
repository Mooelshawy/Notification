package com.example.malek.notification;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager =  (NotificationManager) getSystemService(NOTIFICATION_SERVICE) ;

    }

    NotificationManager manager ;

    static  int Counter  = 1;
    public void addNotification(View view) {
        NotificationCompat.Builder  bulider = new NotificationCompat.Builder(getApplicationContext(),"ChannelId").
                setContentTitle("Try Notification").
                setContentText("this Notification from app...").
                setSmallIcon(R.drawable.index).
                setColor(getResources().getColor(R.color.colorPrimaryDark)).
                setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 }).
                setShowWhen(true).
                setWhen(System.currentTimeMillis()).
                setStyle(new NotificationCompat.BigTextStyle());

        manager.notify(Counter, bulider.build());
        Counter++ ;
    }

    public void deleteNotification(View view) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),"ChannelId").
                setAutoCancel(true);
        manager.cancel(Counter);
        manager.notify(Counter,builder.build());
    }

    public void DeleteAll(View view) {
// Clear all notification
        manager.cancelAll();
    }
}
