package com.example.caoviet.timetableapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.provider.DocumentsContract;
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
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import com.example.caoviet.timetableapp.R;
import com.example.caoviet.timetableapp.Database.Database;
import com.example.caoviet.timetableapp.Main.DocumentAdapter;
import com.example.caoviet.timetableapp.Main.Documents;

import org.w3c.dom.Document;

import java.util.ArrayList;
public class Doccument extends AppCompatActivity {

    private Database database;
    private ListView listViewDocument;
    private Toolbar toolbarDocument;
    private ArrayList<Documents>documentsArrayList;
    private DocumentAdapter documentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doccument);
        setupUIView();
        Inittoolbar();
        documentsArrayList=new ArrayList<>();
        documentAdapter=new DocumentAdapter(this,R.layout.activity_document_single_item,documentsArrayList);
        listViewDocument.setAdapter(documentAdapter);
        database=new Database(this,"Document.sql",null,1);
        database.QueryData("CREATE TABLE IF NOT EXISTS Document(Id INTEGER PRIMARY KEY AUTOINCREMENT ,Name VARCHAR(200))");
        Getdata();


    }
    private void Inittoolbar()
    {
        setSupportActionBar(toolbarDocument);
        getSupportActionBar().setTitle("Documents");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupUIView()
    {
        listViewDocument=(ListView)findViewById(R.id.ListviewDocument);
        toolbarDocument=(Toolbar)findViewById(R.id.ToolbarDocument);



    }
    private void Getdata()
    {
        Cursor data=database.GetData("SELECT*FROM Document");
        while (data.moveToNext()){
            String name=data.getString(1);
            int id=data.getInt(0);
            documentsArrayList.add(new Documents(id,name));
        }
        documentAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_document,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menuAdddocument)
        {
            Dialogadddocument();
        }
        return super.onOptionsItemSelected(item);

    }

    private void Dialogadddocument()
    {
        final Dialog dialog =new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add_document);
        final EditText editText=(EditText)dialog.findViewById(R.id.editTextDocument);
        Button btnadddocument=(Button)dialog.findViewById(R.id.btnadddocument);
        Button btncanceldocument=(Button)dialog.findViewById(R.id.btncanceldocument);

        btnadddocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editText.getText().toString();
                if(name.equals("")){
                    Toast.makeText(Doccument.this,"Pls insert name document!",Toast.LENGTH_SHORT).show();
                }
                else{
                    database.QueryData("INSERT INTO Document VALUES(null,'"+name+"')");
                    Toast.makeText(Doccument.this,"Success!",Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    startActivity(getIntent());
                    Getdata();
                }
            }
        });
        btncanceldocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void Dialogdelete(String name, final int Id)
    {
        AlertDialog.Builder diaLogdelete=new AlertDialog.Builder(this);
        diaLogdelete.setMessage("Are you sure to delete this document?");
        diaLogdelete.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                database.QueryData("DELETE FROM Document WHERE Id='"+Id+"'");
                Toast.makeText(Doccument.this,"Delete complete!",Toast.LENGTH_SHORT).show();
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
}
