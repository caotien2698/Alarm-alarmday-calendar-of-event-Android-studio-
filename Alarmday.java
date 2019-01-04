package com.example.caoviet.timetableapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import com.example.caoviet.timetableapp.Main.AlarmdayReceiver;
import com.example.caoviet.timetableapp.Main.Music;

import java.util.Calendar;

public class Alarmday extends AppCompatActivity {
    Toolbar toolbaralarmday;
    TextView txtalarmday;
    Button btnsettime,btncancelalarmday;
    TimePicker timePicker;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmday);
        Inittoolbar();
        btnsettime=(Button)findViewById(R.id.buttonsetalarmday);
        btncancelalarmday=(Button)findViewById(R.id.buttoncancelalarmday);
        txtalarmday=(TextView)findViewById(R.id.textViewalarmday);
        timePicker=(TimePicker)findViewById(R.id.time_picker);
        final Calendar calendar=Calendar.getInstance();
        alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        final Intent intent=new Intent(Alarmday.this,AlarmdayReceiver.class);
        btnsettime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());
                int hour=timePicker.getCurrentHour();
                int minute=timePicker.getCurrentMinute();
                // Parse to string
                String string_hour=String.valueOf(hour);
                String string_minute=String.valueOf(minute);
                if(minute<10)
                {
                    string_minute="0"+String.valueOf(minute);
                }
                intent.putExtra("extra","on");
                pendingIntent=PendingIntent.getBroadcast(Alarmday.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
                txtalarmday.setText("Alarm set at "+string_hour+":"+string_minute);
            }
        });
        btncancelalarmday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtalarmday.setText("Cancel alarm!");
                alarmManager.cancel(pendingIntent);
                intent.putExtra("extra","off");
                sendBroadcast(intent);
            }
        });

    }
    private void Inittoolbar()
    {
        toolbaralarmday=(Toolbar)findViewById(R.id.toolbaralarmday);
        setSupportActionBar(toolbaralarmday);
        getSupportActionBar().setTitle("AlarmDay");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}

