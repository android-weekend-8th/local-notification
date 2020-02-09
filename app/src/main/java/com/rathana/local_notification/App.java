package com.rathana.local_notification;

import android.app.Application;

import com.rathana.local_notification.util.notification.ChannelHelper;

public class App extends Application {

    public static final String CHANNEL_ID_1 = "EVENT_1";
    public static final String CHANNEL_NAME_1 = "ANY EVENT";

    public static final String CHANNEL_ID_2 = "GENERAL_INFO";
    public static final String CHANNEL_NAME_2 = "General information";

    @Override
    public void onCreate() {
        super.onCreate();

        ChannelHelper channelHelper=new ChannelHelper(this);
        channelHelper.create(CHANNEL_ID_1, CHANNEL_NAME_1);
        channelHelper.create(CHANNEL_ID_2,CHANNEL_NAME_2);
    }


}
