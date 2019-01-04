package com.example.caoviet.timetableapp.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caoviet.timetableapp.R;

import java.util.ArrayList;
import java.util.List;

public class TimetableAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Timetable>timetableList;

    public TimetableAdapter(Context context, int layout, ArrayList<Timetable> timetableList) {
        this.context = context;
        this.layout = layout;
        this.timetableList = timetableList;
    }

    @Override
    public int getCount() {
        return timetableList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder
    {
        ImageView imgHinh;
        TextView txtTen,txtMota,txtNoidung;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if(view==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder=new ViewHolder();
            //Ánh xạ
            holder.txtTen=(TextView)view.findViewById(R.id.textViewTen);
            holder.txtMota=(TextView)view.findViewById(R.id.textViewMota);
            holder.txtNoidung=(TextView)view.findViewById(R.id.textViewNoidung);
            holder.imgHinh=(ImageView)view.findViewById(R.id.imageHinh);
            view.setTag(holder);
        }
        else {
            holder= (ViewHolder) view.getTag();
        }


        Timetable timetable=timetableList.get(i);
        holder.txtTen.setText(timetable.getTen());
        holder.txtMota.setText(timetable.getMota());
        holder.txtNoidung.setText(timetable.getNoidung());
        holder.imgHinh.setImageResource(timetable.getHinh());

        return view;
    }
}
