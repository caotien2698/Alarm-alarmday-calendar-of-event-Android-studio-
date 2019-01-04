package com.example.caoviet.timetableapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Calendar extends AppCompatActivity {

    private Toolbar cToolbar;
    private Button cbuttonevent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        cToolbar = (Toolbar) findViewById(R.id.toolbarcalendar);
        setSupportActionBar(cToolbar);
        getSupportActionBar().setTitle("Calendar of Event");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cbuttonevent=(Button)findViewById(R.id.buttonevents);
        cbuttonevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Calendar.this,AddReminderActivity.class);
                startActivity(intent);
            }
        });
    }
}
