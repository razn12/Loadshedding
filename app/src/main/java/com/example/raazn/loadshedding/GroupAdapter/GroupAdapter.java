package com.example.raazn.loadshedding.GroupAdapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raazn.loadshedding.R;
import com.example.raazn.loadshedding.SqliteHelper.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by raazn on 25-Oct-16.
 */
public class GroupAdapter extends RecyclerView.Adapter<GroupViewHolder>{
    Cursor c;
    DatabaseHelper mydb;
    String date;

    Context context;
    public GroupAdapter(Context group1, int group) {

        context=group1;
        mydb=new DatabaseHelper(group1);
        switch (group) {
            case 1: {
                c = mydb.get_group1();
                break;
            }
            case 2: {
                c = mydb.get_group2();
                break;
            }
            case 3: {
                c = mydb.get_group3();
                break;
            }
            case 4: {
                c = mydb.get_group4();
                break;
            }
            case 5: {
                c = mydb.get_group5();
                break;
            }
            case 6: {
                c = mydb.get_group6();
                break;
            }
            case 7: {
                c = mydb.get_group7();
                break;
            }
        }
        date= new SimpleDateFormat("EEE").format(new Date());
        System.out.println(date);

    }

    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.group_list_item,parent,false);
        GroupViewHolder vh=new GroupViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(GroupViewHolder holder, int position) {
        c.moveToPosition(position);
        String day=c.getString(0);
        String phase1=c.getString(1);
        String phase2=c.getString(2);

        if(c.getString(0).equals(date)){
            String nextp1;
            if(position<6){
                c.moveToPosition(position+1);
                nextp1=c.getString(1);
            }
            else{
                c.moveToPosition(0);
                nextp1=c.getString(1);
            }
            c.moveToPosition(position);
            String[] bati=new TimeConverter().TimeValue(phase1,phase2,nextp1);
            if(bati[0].equals("true")) {
                holder.t1.setBackgroundColor(Color.parseColor("#1b666e"));
                holder.t1.setTextColor(Color.parseColor("#ffffff"));
                holder.bulb.setImageResource(R.drawable.bon);
                holder.t4.setText(bati[1]+" m left");


            }
            else {
                holder.t1.setBackgroundColor(Color.parseColor("#6E1B2C"));
                holder.t1.setTextColor(Color.parseColor("#ffffff"));
                holder.bulb.setImageResource(R.drawable.boff);
                holder.t4.setText(bati[1]+" m left");
            }
        }

        holder.t1.setText(c.getString(0));
        holder.t2.setText(c.getString(1));
        holder.t3.setText(c.getString(2));

    }

    @Override
    public int getItemCount() {
        return c.getCount();
    }
}
