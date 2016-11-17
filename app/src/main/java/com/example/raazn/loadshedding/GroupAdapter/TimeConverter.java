package com.example.raazn.loadshedding.GroupAdapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by raazn on 16-Oct-16.
 */

public class TimeConverter {
    private boolean result;
    private long lefttime;

    public String[] TimeValue(String phase1,String phase2,String nextp1) {
        String[] part1 = phase1.split("-");
        long p1a = convertTo24Hour(part1[0]);
        long p1b = convertTo24Hour(part1[1]);

        String[] part2 = phase2.split("-");
        long p2a = convertTo24Hour(part2[0]);
        long p2b = convertTo24Hour(part2[1]);

        String[] part3 = nextp1.split("-");
        long np1 = convertTo24Hour(part3[0]);

        long day=86400000;

        //current time
        DateFormat df = new SimpleDateFormat("hh:mm a");
        long time = convertTo24Hour(df.format(Calendar.getInstance().getTime()));


        if(time<p1a){
            lefttime=p1a-time;
            result= true;
        }
        else if(time>=p1a&&time<p1b){
            lefttime=p1b-time;
            result= false;
        }
        else if(time>=p1b&&time<p2a){
            lefttime=p2a-time;
            result= true;
        }
        else if(time>=p2a&&time<p2b){
            lefttime=p2b-time;
            result= false;
        }
        else {
            lefttime=(day+np1)-time;
            result= true;
        }
        String s= String.valueOf(result);


        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String date3 = timeFormat.format(new Date(lefttime));


        return new String[]{s,date3};

    }
    public static long convertTo24Hour(String Time) {
        SimpleDateFormat f1 = new SimpleDateFormat("hh:mm a"); //11:00 pm
        Date d = null;
        try {
            d = f1.parse(Time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SimpleDateFormat f2 = new SimpleDateFormat("HH:mm");
        String x = f2.format(d); // "23:00"

        f2.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date1 = null;

        try {
            date1 = f2.parse(x);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return date1.getTime();
    }
}
