package com.example.caoviet.timetableapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;



import com.example.caoviet.timetableapp.Main.TimetableAdapter;
import com.example.caoviet.timetableapp.Main.Week;
import com.example.caoviet.timetableapp.Main.WeekAdapter;

import java.util.ArrayList;

public class Week_activity extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;
    ArrayList<Week> arrayWeek;
    WeekAdapter weekAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_activity);
        setupUIViews();
        initToolbar();
        weekAdapter=new WeekAdapter(this,R.layout.week_activity_single_item,arrayWeek);
        listView.setAdapter(weekAdapter);


    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Week");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void setupUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarWeek);
        listView = (ListView) findViewById(R.id.lvWeek);
        arrayWeek = new ArrayList<>();
        arrayWeek.add(new Week("onday", "Click here", R.drawable.m));
        arrayWeek.add(new Week("uesday", "Click here", R.drawable.t));
        arrayWeek.add(new Week("ednesday", "Click here", R.drawable.w));
        arrayWeek.add(new Week("hursday", "Click here", R.drawable.t));
        arrayWeek.add(new Week("riday", "Click here", R.drawable.f));
        arrayWeek.add(new Week("aturday", "Click here", R.drawable.s));
        arrayWeek.add(new Week("unday", "Click here", R.drawable.s));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0: {
                        Intent intent=new Intent(Week_activity.this,Daydetails.class);
                        intent.putExtra("Day","Monday");
                        startActivity(intent);
                        break;
                    }
                    case 1: {
                        Intent intent=new Intent(Week_activity.this,Daydetails.class);
                        intent.putExtra("Day","Tuesday");
                        startActivity(intent);
                        break;
                    }
                    case 2: {
                        Intent intent=new Intent(Week_activity.this,Daydetails.class);
                        intent.putExtra("Day","Wednesday");
                        startActivity(intent);
                        break;
                    }
                    case 3: {
                        Intent intent=new Intent(Week_activity.this,Daydetails.class);
                        intent.putExtra("Day","Thursday");
                        startActivity(intent);
                        break;
                    }
                    case 4: {
                        Intent intent=new Intent(Week_activity.this,Daydetails.class);
                        intent.putExtra("Day","Friday");
                        startActivity(intent);
                        break;
                    }
                    case 5: {
                        Intent intent=new Intent(Week_activity.this,Daydetails.class);
                        intent.putExtra("Day","Saturday");
                        startActivity(intent);
                        break;
                    }
                    case 6: {
                        Intent intent=new Intent(Week_activity.this,Daydetails.class);
                        intent.putExtra("Day","Sunday");
                        startActivity(intent);
                        break;
                    }
                }
            }
        });
    }
}


