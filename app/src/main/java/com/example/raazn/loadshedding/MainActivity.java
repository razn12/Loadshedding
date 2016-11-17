package com.example.raazn.loadshedding;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ToxicBakery.viewpager.transforms.CubeInTransformer;
import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
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
        viewPager.setPageTransformer(true,new CubeOutTransformer());

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        d=(TextView)findViewById(R.id.date);
        t=(TextView)findViewById(R.id.time);

        //set today's date
        String date= new SimpleDateFormat("EEEE, d MMM yyyy").format(new Date());;
        d.setText(date);

        //update time for each second
        myhandler=new Handler();
        updateTime();

        //Initialize default value to groups for once
        spf=getSharedPreferences("myprefs", Context.MODE_PRIVATE);
        spe=spf.edit();
        groupno=spf.getInt("group",0);
        String check=spf.getString("check", "true");
        if (check.equals("true")){

            DatabaseDefaultValue dvalue=new DatabaseDefaultValue(this);
            dvalue.insert();
            Toast.makeText(getApplicationContext(),"Please refresh to get updated schedule",Toast.LENGTH_LONG).show();
        }
        else
            System.out.println("false");
        spe.putString("check", "false");
        spe.commit();

        //group list spinner
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
        if(isNetworkAvailable()){
            UpdateGroup update=new UpdateGroup(this);
            update.volleyJsonArrayRequest();
            this.finish();
            Intent i=new Intent();
            i.setComponent(new ComponentName(getApplicationContext(),MainActivity.class));
            startActivity(i);
            Toast.makeText(getApplicationContext(),"Updated Sucessfully",Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_LONG).show();


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
    public void stopService(){

        Intent i=new Intent();
        i.setComponent(new ComponentName(getApplicationContext(), NotificationService.class));
        stopService(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.notify:
                startService();
                return true;

            case R.id.unnotify:
                stopService();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager =(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }

        return false;
    }
}
