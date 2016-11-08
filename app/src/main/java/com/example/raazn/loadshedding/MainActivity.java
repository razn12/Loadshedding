package com.example.raazn.loadshedding;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.raazn.loadshedding.Volley.UpdateGroup;
import com.example.raazn.loadshedding.GroupTabs.TabsPagerAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Spinner spn;
    SharedPreferences spf;
    SharedPreferences.Editor spe;
    Handler myhandler;
    int groupno;
    TextView d,t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);
        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        myhandler=new Handler();
        d=(TextView)findViewById(R.id.date);
        t=(TextView)findViewById(R.id.time);


        updateTime();

        String date= new SimpleDateFormat("EEEE, d MMM yyyy").format(new Date());;
        d.setText(date);


        //Initialize default value to groups for once
        spf=getSharedPreferences("myprefs", Context.MODE_PRIVATE);
        spe=spf.edit();
        groupno=spf.getInt("group",0);
        String check=spf.getString("check", "true");
        if (check.equals("true")){

            DatabaseDefaultValue dvalue=new DatabaseDefaultValue(this);
            dvalue.insert();
        }
        else
            System.out.println("false");
        spe.putString("check", "false");
        spe.commit();

        spn=(Spinner)findViewById(R.id.spinner);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int groupnum=spn.getSelectedItemPosition();
                System.out.println(groupnum);
                spe.putInt("group",groupnum);
                spe.commit();
                viewPager.setCurrentItem(groupnum);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        System.out.println(groupno);
        spn.setSelection(groupno);


    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    public void refresh(View v){
        UpdateGroup update=new UpdateGroup(this);
        update.volleyJsonArrayRequest();
        Intent intent = getIntent();
        finish();
        startActivity(intent);

    }
    Runnable run =new Runnable() {
        @Override
        public void run() {
            updateTime();
        }
    };
    public void updateTime(){
        DateFormat df = new SimpleDateFormat("hh:mm:ss a");
        String time = df.format(Calendar.getInstance().getTime());
        t.setText("Now: "+time);
        myhandler.postDelayed(run, 1000);
    }
    public void flashlight(View v){
        Intent i=new Intent();
        i.setComponent(new ComponentName(getApplicationContext(),FlashLight.class));
        startActivity(i);
    }
    public void startService(){

        Intent i=new Intent();
        i.setComponent(new ComponentName(getApplicationContext(), NotificationService.class));
        startService(i);
    }

}
