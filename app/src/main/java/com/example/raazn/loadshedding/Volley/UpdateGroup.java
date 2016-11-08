package com.example.raazn.loadshedding.Volley;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.raazn.loadshedding.MainActivity;
import com.example.raazn.loadshedding.SqliteHelper.DatabaseHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

/**
 * Created by raazn on 16-Oct-16.
 */

public class UpdateGroup {
    // JSON Node names
    private static final String TAG = "info";
    private static final String TAG_DAY = "day";
    private static final String TAG_PHASE1 = "phase1";
    private static final String TAG_PHASE2 = "phase2";
    // contacts JSONArray
    JSONArray results = null;

    Context context;
    DatabaseHelper mydb;


    public UpdateGroup(Context mactivity) {
        context=mactivity;
        mydb=new DatabaseHelper(context);

    }
    public void volleyJsonArrayRequest(){
        String url[]=new String[]{"https://razn-loadshedding.000webhostapp.com/group1.php","https://razn-loadshedding.000webhostapp.com/group2.php","https://razn-loadshedding.000webhostapp.com/group3.php","https://razn-loadshedding.000webhostapp.com/group4.php","https://razn-loadshedding.000webhostapp.com/group5.php","https://razn-loadshedding.000webhostapp.com/group6.php","https://razn-loadshedding.000webhostapp.com/group7.php"};
        String  REQUEST_TAG = "com.example.raazn.loadshedding.Volley.volleyJsonArrayRequest";

        StringRequest jsonObjectReq = new StringRequest(url[0],
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response.toString());
                        String jsonStr=response.toString();
                        if(jsonStr!=null) {
                            try {
                                JSONObject jsonObj = new JSONObject(jsonStr);
                                results = jsonObj.getJSONArray(TAG);

                                for (int i = 0; i < results.length(); i++) {
                                    JSONObject c = results.getJSONObject(i);
                                    String day = c.getString(TAG_DAY);
                                    String phase1 = c.getString(TAG_PHASE1);
                                    String phase2 = c.getString(TAG_PHASE2);
                                    System.out.println(day);
                                    System.out.println(phase1);
                                    System.out.println(phase2);
                                    mydb.update_group1(day,phase1,phase2);

                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "$$$$$$$$$Error: " + error.getMessage());

            }

        });

        // Adding JsonObject request to request queue
        AppSingleton.getInstance(context.getApplicationContext()).addToRequestQueue(jsonObjectReq,REQUEST_TAG);


        StringRequest jsonObjectReq2 = new StringRequest(url[1],
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response.toString());
                        String jsonStr=response.toString();
                        if(jsonStr!=null) {
                            try {
                                JSONObject jsonObj = new JSONObject(jsonStr);
                                results = jsonObj.getJSONArray(TAG);

                                for (int i = 0; i < results.length(); i++) {
                                    JSONObject c = results.getJSONObject(i);
                                    String day = c.getString(TAG_DAY);
                                    String phase1 = c.getString(TAG_PHASE1);
                                    String phase2 = c.getString(TAG_PHASE2);
                                    System.out.println(day);
                                    System.out.println(phase1);
                                    System.out.println(phase2);
                                    mydb.update_group2(day,phase1,phase2);

                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "$$$$$$$$$Error: " + error.getMessage());

            }

        });

        // Adding JsonObject request to request queue
        AppSingleton.getInstance(context.getApplicationContext()).addToRequestQueue(jsonObjectReq2,REQUEST_TAG);

        //group 3 update
        StringRequest jsonObjectReq3 = new StringRequest(url[2],
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response.toString());
                        String jsonStr=response.toString();
                        if(jsonStr!=null) {
                            try {
                                JSONObject jsonObj = new JSONObject(jsonStr);
                                results = jsonObj.getJSONArray(TAG);

                                for (int i = 0; i < results.length(); i++) {
                                    JSONObject c = results.getJSONObject(i);
                                    String day = c.getString(TAG_DAY);
                                    String phase1 = c.getString(TAG_PHASE1);
                                    String phase2 = c.getString(TAG_PHASE2);
                                    System.out.println(day);
                                    System.out.println(phase1);
                                    System.out.println(phase2);
                                    mydb.update_group3(day,phase1,phase2);

                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "$$$$$$$$$Error: " + error.getMessage());

            }

        });

        // Adding JsonObject request to request queue
        AppSingleton.getInstance(context.getApplicationContext()).addToRequestQueue(jsonObjectReq3,REQUEST_TAG);

        //group4 update
        StringRequest jsonObjectReq4 = new StringRequest(url[3],
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response.toString());
                        String jsonStr=response.toString();
                        if(jsonStr!=null) {
                            try {
                                JSONObject jsonObj = new JSONObject(jsonStr);
                                results = jsonObj.getJSONArray(TAG);

                                for (int i = 0; i < results.length(); i++) {
                                    JSONObject c = results.getJSONObject(i);
                                    String day = c.getString(TAG_DAY);
                                    String phase1 = c.getString(TAG_PHASE1);
                                    String phase2 = c.getString(TAG_PHASE2);
                                    System.out.println(day);
                                    System.out.println(phase1);
                                    System.out.println(phase2);
                                    mydb.update_group4(day,phase1,phase2);

                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "$$$$$$$$$Error: " + error.getMessage());

            }

        });

        // Adding JsonObject request to request queue
        AppSingleton.getInstance(context.getApplicationContext()).addToRequestQueue(jsonObjectReq4,REQUEST_TAG);

        //group5 update
        StringRequest jsonObjectReq5 = new StringRequest(url[4],
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response.toString());
                        String jsonStr=response.toString();
                        if(jsonStr!=null) {
                            try {
                                JSONObject jsonObj = new JSONObject(jsonStr);
                                results = jsonObj.getJSONArray(TAG);

                                for (int i = 0; i < results.length(); i++) {
                                    JSONObject c = results.getJSONObject(i);
                                    String day = c.getString(TAG_DAY);
                                    String phase1 = c.getString(TAG_PHASE1);
                                    String phase2 = c.getString(TAG_PHASE2);
                                    System.out.println(day);
                                    System.out.println(phase1);
                                    System.out.println(phase2);
                                    mydb.update_group5(day,phase1,phase2);

                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "$$$$$$$$$Error: " + error.getMessage());

            }

        });

        // Adding JsonObject request to request queue
        AppSingleton.getInstance(context.getApplicationContext()).addToRequestQueue(jsonObjectReq5,REQUEST_TAG);

        //group6 update
        StringRequest jsonObjectReq6 = new StringRequest(url[5],
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response.toString());
                        String jsonStr=response.toString();
                        if(jsonStr!=null) {
                            try {
                                JSONObject jsonObj = new JSONObject(jsonStr);
                                results = jsonObj.getJSONArray(TAG);

                                for (int i = 0; i < results.length(); i++) {
                                    JSONObject c = results.getJSONObject(i);
                                    String day = c.getString(TAG_DAY);
                                    String phase1 = c.getString(TAG_PHASE1);
                                    String phase2 = c.getString(TAG_PHASE2);
                                    System.out.println(day);
                                    System.out.println(phase1);
                                    System.out.println(phase2);
                                    mydb.update_group6(day,phase1,phase2);

                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "$$$$$$$$$Error: " + error.getMessage());

            }

        });

        // Adding JsonObject request to request queue
        AppSingleton.getInstance(context.getApplicationContext()).addToRequestQueue(jsonObjectReq6,REQUEST_TAG);

        //group 7 update
        StringRequest jsonObjectReq7 = new StringRequest(url[6],
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response.toString());
                        String jsonStr=response.toString();
                        if(jsonStr!=null) {
                            try {
                                JSONObject jsonObj = new JSONObject(jsonStr);
                                results = jsonObj.getJSONArray(TAG);

                                for (int i = 0; i < results.length(); i++) {
                                    JSONObject c = results.getJSONObject(i);
                                    String day = c.getString(TAG_DAY);
                                    String phase1 = c.getString(TAG_PHASE1);
                                    String phase2 = c.getString(TAG_PHASE2);
                                    System.out.println(day);
                                    System.out.println(phase1);
                                    System.out.println(phase2);
                                    mydb.update_group7(day,phase1,phase2);

                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "$$$$$$$$$Error: " + error.getMessage());

            }

        });

        // Adding JsonObject request to request queue
        AppSingleton.getInstance(context.getApplicationContext()).addToRequestQueue(jsonObjectReq7,REQUEST_TAG);
    }


}
