package com.example.caoviet.timetableapp.Main;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.caoviet.timetableapp.Daydetails;
import com.example.caoviet.timetableapp.R;

import java.util.List;

public class SubjectAdapter extends BaseAdapter {

    private Daydetails context;
    private int layout;
    private List<Subject>subjectList;

    public SubjectAdapter(Daydetails context, int layout, List<Subject> subjectList) {
        this.context = context;
        this.layout = layout;
        this.subjectList = subjectList;
    }

    @Override
    public int getCount() {
        return subjectList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder {
        TextView txtName;
        TextView txtTime;
        TextView txtDay;
        ImageView imageedit;
        ImageView imagedelete;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null)
        {
            holder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder.txtName=(TextView)view.findViewById(R.id.textViewName);
            holder.txtTime=(TextView)view.findViewById(R.id.textViewTime);
            holder.txtDay=(TextView)view.findViewById(R.id.textViewDay);
            holder.imageedit=(ImageView)view.findViewById(R.id.imageEdit);
            holder.imagedelete=(ImageView)view.findViewById(R.id.imageDelete);
            view.setTag(holder);
        }
        else {
            holder=(ViewHolder)view.getTag();
        }
        final Subject subject=subjectList.get(i);
        holder.txtName.setText(subject.getSubject_name());
        holder.txtTime.setText(subject.getSubject_time());
        holder.txtDay.setText(subject.getSubject_day());

        holder.imageedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogUpdatesubject(subject.getIdSubject(),subject.getSubject_name(),subject.getSubject_time(),subject.getSubject_day());
            }
            
        });
        holder.imagedelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                context.DialogDeletesubject(subject.getSubject_name(),subject.getIdSubject());
            }
            
        });
        return view;
    }
}
