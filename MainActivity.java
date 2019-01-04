package com.example.caoviet.timetableapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

import com.example.caoviet.timetableapp.Main.Timetable;
import com.example.caoviet.timetableapp.Main.TimetableAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;
    ArrayList<Timetable> arrayTimetable;
    TimetableAdapter timetableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();
        initToolbar();
        timetableAdapter=new TimetableAdapter(this,R.layout.main_activity_single_item,arrayTimetable);
        listView.setAdapter(timetableAdapter);


    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Timetable App");
    }


    private void setupUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarMain);
        listView = (ListView) findViewById(R.id.ListviewMain);
        arrayTimetable = new ArrayList<>();
        arrayTimetable.add(new Timetable("Timetable", "Get to known the classes, only a click away and get rid of fussy image timetable", "Click here", R.drawable.timetable1));
        arrayTimetable.add(new Timetable("Document", "Written, drawn, presented, or memorialized representation", "Click here", R.drawable.book1));
        arrayTimetable.add(new Timetable("Alarm", "Wake up, wake up, wake up!!!!", "Click here", R.drawable.alarm));
        arrayTimetable.add(new Timetable("Calender Of Event", "Time,days,weeks,months,years", "Click here", R.drawable.calender));
        arrayTimetable.add(new Timetable("Resources", "Get all the study meterials, extra info, all in one place", "Click here", R.drawable.settings1));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:
                    {
                        Intent intent=new Intent(MainActivity.this,Week_activity.class);
                        startActivity(intent);
                        break;
                    }
                    case 1:
                    {
                        Intent intent=new Intent(MainActivity.this,Doccument.class);
                        startActivity(intent);
                        break;
                    }
                    case 2:
                    {
                        Intent intent=new Intent(MainActivity.this,Alarmday.class);
                        startActivity(intent);
                        break;
                    }
                    case 3:
                    {
                        Intent intent=new Intent(MainActivity.this,Calendar.class);
                        startActivity(intent);
                        break;
                    }
                }
            }
        });
    }
}