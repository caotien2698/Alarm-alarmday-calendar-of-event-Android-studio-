package com.example.caoviet.timetableapp;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.caoviet.timetableapp.Database.Database;
import com.example.caoviet.timetableapp.Main.Subject;
import com.example.caoviet.timetableapp.Main.SubjectAdapter;

import java.util.ArrayList;

public class Daydetails extends AppCompatActivity {
    public static Database database;
    private ListView listViewsubject;
    private FloatingActionButton floatingActionButton;
    private ArrayList<Subject>subjectArrayList;
    private Toolbar toolbar;
    private SubjectAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daydetails);
        setupUIViews();
        initToolbar();
        subjectArrayList=new ArrayList<>();
        adapter=new SubjectAdapter(this,R.layout.activity_daydetail_single_item,subjectArrayList);
        listViewsubject.setAdapter(adapter);
        database=new Database(this,"Subject_Manager",null,1);
        database.QueryData("CREATE TABLE IF NOT EXISTS Table_works(Id INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR(150),Time VARCHAR(150),Day VARCHAR(150))");
        //database.QueryData("INSERT INTO Table_works VALUES(null,'Mobile','11h','Monday')");
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAddsubject();
            }
        });
        Getdata();
        adapter.notifyDataSetChanged();
    }
    private void Getdata()
    {
        Intent intent=getIntent();
        String day_transport=intent.getStringExtra("Day");
        Cursor cursor=database.GetData("SELECT*FROM Table_works WHERE Day='"+day_transport+"'");

        while (cursor.moveToNext())
        {

            subjectArrayList.add(new Subject(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            ));
        }
    }


    private void initToolbar() {
        Intent intent=getIntent();
        String day_transport=intent.getStringExtra("Day");
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(day_transport);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_subject,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menuAdd)
        {
            DialogAddsubject();
        }
        return super.onOptionsItemSelected(item);
    }
    private void DialogAddsubject()
    {
        final Dialog dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add);
        final EditText edittextname=(EditText)dialog.findViewById(R.id.editTextName);
        final EditText edittexttime=(EditText)dialog.findViewById(R.id.editTextTime);
        final EditText edittextday=(EditText)dialog.findViewById(R.id.editTextDay);
        Button btnadd=(Button)dialog.findViewById(R.id.btnadd);
        Button btncancel=(Button)dialog.findViewById(R.id.btncancel);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newname=edittextname.getText().toString();
                String newtime=edittexttime.getText().toString();
                String newday=edittextday.getText().toString();
                if(newname.equals("")||newtime.equals("")||newday.equals(""))
                {
                    Toast.makeText(Daydetails.this,"Pls insert data",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    database.QueryData("INSERT INTO Table_works VALUES(null,'"+newname+"','"+newtime+"','"+newday+"')");
                    Toast.makeText(Daydetails.this,"Add success!",Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    startActivity(getIntent());
                    Getdata();
                }
            }

        });
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }


    public void DialogUpdatesubject(final int Id, String name, String time, String day)
    {
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialog_update);
        final EditText edittextupdatename=(EditText)dialog.findViewById(R.id.editTextupdatename);
        final EditText edittextupdatetime=(EditText)dialog.findViewById(R.id.editTextupdatetime);
        final EditText edittextupdateday=(EditText)dialog.findViewById(R.id.editTextupdateday);
        Button btnupdate=(Button)dialog.findViewById(R.id.btnupdate);
        Button btncancel=(Button)dialog.findViewById(R.id.btncancelupdate);

        edittextupdatename.setText(name);
        edittextupdatetime.setText(time);
        edittextupdateday.setText(day);
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newname=edittextupdatename.getText().toString().trim();
                String newtime=edittextupdatetime.getText().toString().trim();
                String newday=edittextupdateday.getText().toString().trim();
                database.QueryData("UPDATE Table_works SET Name='"+newname+"'WHERE Id='"+Id+"'");
                database.QueryData("UPDATE Table_works SET Time='"+newtime+"'WHERE Id='"+Id+"'");
                database.QueryData("UPDATE Table_works SET Day='"+newday +"'WHERE Id='"+Id+"'");
                Toast.makeText(Daydetails.this,"Update success!",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                startActivity(getIntent());
                Getdata();

            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }
    public void DialogDeletesubject(String name, final int Id)
    {
        AlertDialog.Builder diaLogdelete=new AlertDialog.Builder(this);
        diaLogdelete.setMessage("Are you sure to delete this subject?");
        diaLogdelete.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                database.QueryData("DELETE FROM Table_works WHERE Id='"+Id+"'");
                Toast.makeText(Daydetails.this,"Delete complete!",Toast.LENGTH_SHORT).show();
                Getdata();
                startActivity(getIntent());
            }
        });
        diaLogdelete.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        diaLogdelete.show();
    }
    private void setupUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarSubject);
        listViewsubject = (ListView) findViewById(R.id.ListviewSubject);
        floatingActionButton=(FloatingActionButton)findViewById(R.id.fab);
    }


}
