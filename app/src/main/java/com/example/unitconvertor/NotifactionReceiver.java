package com.example.unitconvertor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotifactionReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1=new Intent(context,NotifacationIntentService.class);
        context.startService(intent1);

    }
}
