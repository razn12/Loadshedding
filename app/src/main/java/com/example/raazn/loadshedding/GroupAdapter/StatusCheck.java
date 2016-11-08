package com.example.raazn.loadshedding.GroupAdapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.raazn.loadshedding.R;
import com.example.raazn.loadshedding.SqliteHelper.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by raazn on 25-Oct-16.
 */

public class StatusCheck {
    private int group;
    private TextView timer,grop,ph1,ph2;
    private Context context;
    private Cursor c;
    private DatabaseHelper mydb;
    private String date;
    private ImageView light;
    public StatusCheck(int i, TextView tv, Context groupContext, ImageView img, TextView grp, TextView p1, TextView p2) {
        context=groupContext;
        group=i;
        timer=tv;grop=grp;ph1=p1;ph2=p2;
        mydb=new DatabaseHelper(groupContext);
        date= new SimpleDateFormat("EEE").format(new Date());
        light=img;
    }
    public void setStatus(){

        switch (group){
            case 1:{
                grop.setText("Group 1");
                c=mydb.get_group1();
                break;
            }
            case 2:{
                grop.setText("Group 2");
                c=mydb.get_group2();
                break;
            }
            case 3:{
                grop.setText("Group 3");
                c=mydb.get_group3();
                break;
            }
            case 4:{
                grop.setText("Group 4");
                c=mydb.get_group4();
                break;
            }
            case 5:{
                grop.setText("Group 5");
                c=mydb.get_group5();
                break;
            }
            case 6:{
                grop.setText("Group 6");
                c=mydb.get_group6();
                break;
            }
            case 7:{
                grop.setText("Group 7");
                c=mydb.get_group7();
                break;
            }
        }
        for(int position=0;position<7;position++){
            c.moveToPosition(position);
            if(c.getString(0).equals(date)){
                String phase1=c.getString(1);
                String phase2=c.getString(2);

                ph1.setText("Phase 1 : "+phase1);
                ph2.setText("Phase 2 : "+phase2);
                String nextp1;
                if(position<6){
                    c.moveToPosition(position+1);
                    nextp1=c.getString(1);
                }
                else{
                    c.moveToPosition(0);
                    nextp1=c.getString(1);
                }


                String[] bati=new TimeConverter().TimeValue(phase1,phase2,nextp1);

                if(bati[0].equals("true")) {
                    light.setImageResource(R.drawable.on);

                    timer.setText(bati[1]+" m left");
                    timer.setBackgroundColor(Color.parseColor("#6E1B2C"));
                    grop.setBackgroundColor(Color.parseColor("#dc970e"));

                }
                else {
                    light.setImageResource(R.drawable.off);
                    timer.setText(bati[1]+" m left");
                    timer.setBackgroundColor(Color.parseColor("#1b666e"));
                    grop.setBackgroundColor(Color.parseColor("#787061"));
                }
            }

        }
    }
}
