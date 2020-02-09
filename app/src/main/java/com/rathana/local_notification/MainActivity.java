package com.rathana.local_notification;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.rathana.local_notification.util.notification.NotificationHelper;

public class MainActivity extends AppCompatActivity {

    NotificationHelper notificationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationHelper = new NotificationHelper(this);
    }

    public void simpleNotification(View view) {
        Notification notification = notificationHelper.simple();
        notificationHelper.push(notification);
    }

    public void collapsingContent(View view) {
        Notification notification = notificationHelper.collapsingContent();
        notificationHelper.push(notification);
    }

    public void collapsingBigPicture(View view){
        Notification n= notificationHelper.collapsingBigPicture();
        notificationHelper.push(n);
    }
}
