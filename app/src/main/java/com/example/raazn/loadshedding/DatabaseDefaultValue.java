package com.example.raazn.loadshedding;

import com.example.raazn.loadshedding.MainActivity;
import com.example.raazn.loadshedding.SqliteHelper.DatabaseHelper;

/**
 * Created by raazn on 15-Oct-16.
 */

public class DatabaseDefaultValue {
    DatabaseHelper mydb;
    String day[],phase1[],phase2[];
    DatabaseDefaultValue(MainActivity mainActivity){
        mydb=new DatabaseHelper(mainActivity);
    }
    public void insert(){
        day= new String[]{"Sun", "Mon","Tue","Wed","Thu","Fri","Sat"};
        phase1=new String[]{"9:00 am - 12:00 pm", "12:00 pm - 4:00 pm","11:00 am - 3:00 pm","7:00 am - 11:00 am","10:00 am - 2:00 pm","5:00 am - 9:00 am","6:00 am - 10:00 am"};
        phase2=new String[]{"5:00 pm - 8:30 pm", "8:00 pm - 10:00 pm","7:00 pm - 9:30 pm","4:00 pm - 8:00 pm","6:30 pm - 9:00 pm","2:00 pm - 5:00 pm","3:00 pm - 7:00 pm"};
        for(int i=0;i<=6;i++){

            try {
                boolean res=mydb.insert_group1(day[i],phase1[i],phase2[i]);
                mydb.insert_group2(day[i],phase1[i],phase2[i]);
                mydb.insert_group3(day[i],phase1[i],phase2[i]);
                mydb.insert_group4(day[i],phase1[i],phase2[i]);
                mydb.insert_group5(day[i],phase1[i],phase2[i]);
                mydb.insert_group6(day[i],phase1[i],phase2[i]);
                mydb.insert_group7(day[i],phase1[i],phase2[i]);
                System.out.println(res);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
