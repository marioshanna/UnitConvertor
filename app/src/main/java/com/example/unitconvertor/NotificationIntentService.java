package com.example.unitconvertor;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.os.Build;

import java.util.Currency;

import androidx.core.app.NotificationManagerCompat;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
    public  class NotificationIntentService extends IntentService {
    // THIS IS THE CHANELL id for notification manegment uses
    private static final int NOTIFICATION_ID =3 ;

    public NotificationIntentService() {
        super("NotificationIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Notification.Builder noBuilder=new Notification.Builder(this);
        //todo need to change the notification title
        noBuilder.setContentTitle("welcome to my app");
        //todo need to change the notification text
        noBuilder.setContentText("use this app to convert between units");
        //TODO need to changr the notification Icon
        noBuilder.setSmallIcon(R.drawable.ic_baseline_compare_arrows_24);
        // this intent will be pending until the user clicks on the notification
        //and will activate the activity specified in the intent
        Intent noIntent1=new Intent(this, ConvertorActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,2,noIntent1,PendingIntent.FLAG_UPDATE_CURRENT);
        noBuilder.setContentIntent(pendingIntent);
        //the attributes of the object we have assumed above
        Notification notification=noBuilder.build();
        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(this);
        managerCompat.notify(NOTIFICATION_ID,notification);

        NotificationManager mNotificationManager;
        mNotificationManager =
                (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        // this is recquired for sdk version 26 and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            String channelId = "Your_channel_id";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_HIGH);
            mNotificationManager.createNotificationChannel(channel);
            noBuilder.setChannelId(channelId);
        }
        noBuilder.build();
        mNotificationManager.notify(NOTIFICATION_ID,notification);

    }


}