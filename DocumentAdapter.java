package com.example.caoviet.timetableapp.Main;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caoviet.timetableapp.Database.AlarmReminderDBHelper;
import com.example.caoviet.timetableapp.Doccument;
import com.example.caoviet.timetableapp.R;

import java.util.List;
public class DocumentAdapter extends BaseAdapter {
    private Doccument context;
    private int layout;
    List<Documents>documentsList;

    public DocumentAdapter(Doccument context, int layout, List<Documents> documentsList) {
        this.context = context;
        this.layout = layout;
        this.documentsList = documentsList;
    }
    @Override

    public int getCount() {
        return documentsList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class Viewholder{
        TextView txtdocument;
        ImageView imgdelete;
    }
    @Override
    public View getView(int i, View view, ViewGroup parent) {
        Viewholder holder;
        if(view==null)
        {
            holder=new Viewholder();
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder.txtdocument=(TextView)view.findViewById(R.id.txtDocument);
            holder.imgdelete=(ImageView)view.findViewById(R.id.imgdeleteDocument);
            view.setTag(holder);
        }
        else
        {
            holder=(Viewholder)view.getTag();
        }
        final Documents documents=documentsList.get(i);
        holder.txtdocument.setText(documents.getText());
        holder.imgdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.Dialogdelete(documents.getText(),documents.getIdDocuments());
            }
        });
        return view;
    }
}
