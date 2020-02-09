package com.rathana.local_notification.util.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.core.app.NotificationCompat;

import com.rathana.local_notification.App;
import com.rathana.local_notification.NotificationDetailActivity;
import com.rathana.local_notification.R;

public class NotificationHelper {

    Context context;

    public NotificationHelper(Context context) {
        this.context = context;
    }

    public void push(Notification notification) {
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        int noId = (int) System.currentTimeMillis() / 1000;
        if (notificationManager != null)
            notificationManager.notify(noId, notification);
    }

    public Notification simple() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, App.CHANNEL_ID_1);
        builder.setSmallIcon(R.drawable.ic_beach_access_black_24dp);

        Bitmap bitmap = BitmapFactory.decodeResource(
                context.getResources(),
                R.drawable.panda);

        builder.setLargeIcon(bitmap);

        builder.setContentTitle("Hello");
        builder.setContentText("slslsoeolw");

        return builder.build();
    }

    public Notification collapsingContent() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, App.CHANNEL_ID_1);
        builder.setSmallIcon(R.drawable.ic_beach_access_black_24dp);

        Bitmap bitmap = BitmapFactory.decodeResource(
                context.getResources(),
                R.drawable.panda);

        builder.setLargeIcon(bitmap);

        builder.setContentTitle("Hello");

        NotificationCompat.BigTextStyle style =
                new NotificationCompat.BigTextStyle();
        style.setBigContentTitle("Security is an important part of development. Users expect you to protect");
        style.bigText(context.getString(R.string.content));
        builder.setStyle(style);

        return builder.build();
    }

    public Notification collapsingBigPicture() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, App.CHANNEL_ID_1);
        builder.setSmallIcon(R.drawable.ic_beach_access_black_24dp);

        Bitmap bitmap = BitmapFactory.decodeResource(
                context.getResources(),
                R.drawable.panda);

        builder.setLargeIcon(bitmap);

        builder.setContentTitle("Hello");

        NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
        style.setBigContentTitle("Panda");
        style.bigPicture(bitmap);
        builder.setStyle(style);

        builder.setContentIntent(createPendingIntent());

        return builder.build();
    }

    private PendingIntent createPendingIntent() {

//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com.kh"));
        Intent intent = new Intent(context, NotificationDetailActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                99,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        return pendingIntent;
    }

}
