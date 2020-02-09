package com.rathana.local_notification.util.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;

public class ChannelHelper {

    private Context context;

    public ChannelHelper(Context context) {
        this.context = context;
    }

    public void create(String id, String name) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    id,
                    name,
                    NotificationManager.IMPORTANCE_HIGH);

            channel.setDescription("Getting any event from server admin");
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.setShowBadge(false);

            NotificationManager manager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            if (manager != null)
                manager.createNotificationChannel(channel);
        }

    }

}
