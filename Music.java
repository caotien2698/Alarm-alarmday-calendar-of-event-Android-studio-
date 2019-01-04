package com.example.caoviet.timetableapp.Main;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.example.caoviet.timetableapp.R;

public class Music extends Service {
    MediaPlayer mediaPlayer;
    int id;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String get_extra=intent.getExtras().getString("extra");
        if(get_extra.equals("on")) {id=1; }
        else if (get_extra.equals("off")) {id=0;}
        if(id==1)
        {
            mediaPlayer=MediaPlayer.create(this,R.raw.wakemeup);
            mediaPlayer.start();
            id=0;
        }
        else if(id==0)
        {
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
        return START_NOT_STICKY;
    }
}
