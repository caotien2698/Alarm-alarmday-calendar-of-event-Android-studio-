package com.example.caoviet.timetableapp.Main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.caoviet.timetableapp.Alarmday;
import com.example.caoviet.timetableapp.MainActivity;


public class AlarmdayReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String string_intent=intent.getExtras().getString("extra");
        Intent myIntent=new Intent(context,Music.class);
        myIntent.putExtra("extra",string_intent);
        context.startService(myIntent);
        Intent intent1 = new Intent();
        intent1.setClassName(context.getPackageName(), Alarmday.class.getName());
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);

    }
}
