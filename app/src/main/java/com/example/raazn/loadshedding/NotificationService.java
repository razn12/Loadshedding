package com.example.raazn.loadshedding;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.example.raazn.loadshedding.GroupAdapter.TimeConverter;
import com.example.raazn.loadshedding.SqliteHelper.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by raazn on 08-Nov-16.
 */
public class NotificationService extends Service {
    Cursor c;
    DatabaseHelper mydb;
    String date,phase1,phase2,nextp1;;
    SharedPreferences spf;
    boolean loop,light;
    @Override
    public void onCreate() {
        Toast.makeText(getApplicationContext(),"service created",Toast.LENGTH_LONG).show();

        mydb=new DatabaseHelper(this);
        spf=getSharedPreferences("myprefs", Context.MODE_PRIVATE);
        int group=spf.getInt("group",0);
        System.out.println("$$$$$$$$$$$$$");
        System.out.println(group);
        System.out.println("$$$$$$$$$$$$$");
        switch (group) {
            case 0: {
                c = mydb.get_group1();
                break;
            }
            case 1: {
                c = mydb.get_group2();
                break;
            }
            case 2: {
                c = mydb.get_group3();
                break;
            }
            case 3: {
                c = mydb.get_group4();
                break;
            }
            case 4: {
                c = mydb.get_group5();
                break;
            }
            case 5: {
                c = mydb.get_group6();
                break;
            }
            case 6: {
                c = mydb.get_group7();
                break;
            }
        }
        date= new SimpleDateFormat("EEE").format(new Date());
        loop=true;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(),"service starred",Toast.LENGTH_LONG).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(loop){

                    String lefttime=bati();
                    System.out.println("$$$$$$$$$$$$$$$$$");
                    Log.i("Timeleft:",lefttime);
                    System.out.println("$$$$$$$$$$$$$$$$$");
                    if(lefttime.equals("00:15")){
                        if(light)
                            notification(true);
                        else
                            notification(false);
                    }
                    try {

                        Thread.sleep(60000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getApplicationContext(),"service destroyed",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public String bati(){

        for(int position=0;position<=6;position++){
            c.moveToPosition(position);
            if(c.getString(0).equals(date)){
                phase1=c.getString(1);
                phase2=c.getString(2);
                if(position<6){
                    c.moveToPosition(position+1);
                    nextp1=c.getString(1);
                }
                else{
                    c.moveToPosition(0);
                    nextp1=c.getString(1);
                }
                c.moveToPosition(position);
            }
        }
        String[] bati=new TimeConverter().TimeValue(phase1,phase2,nextp1);
        if(bati[0].equals("true"))
            light=true;
        else
            light=false;
        return bati[1];
    }
    public void notification(boolean bati){
        if(bati){
            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.off)
                            .setContentTitle("Loadshedding Notification")
                            .setContentText("Light goes in 15 min")
                            .setAutoCancel(true)
                            .setDefaults(Notification.DEFAULT_ALL);


            Intent notificationIntent = new Intent(this, MainActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(contentIntent);

            // Add as notification
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(0, builder.build());
        }
        else{
            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.on)
                            .setContentTitle("Loadshedding Notification")
                            .setContentText("Light comes in 15 min")
                            .setAutoCancel(true)
                            .setDefaults(Notification.DEFAULT_ALL);


            Intent notificationIntent = new Intent(this, MainActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(contentIntent);

            // Add as notification
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(0, builder.build());
        }


    }

}
