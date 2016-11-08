package com.example.raazn.loadshedding.SqliteHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by raazn on 15-Oct-16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TAG = "DBHelper";
    public static final String DATABASE_NAME = "loadshedding";
    private static final int DATABASE_VERSION = 1;
    //Group1
    public static final String TABLE_GROUP1 = "group1";
    public static final String COL1 = "day";
    public static final String COL2 = "phase1";
    public static final String COL3 = "phase2";
    //Group2
    public static final String TABLE_GROUP2 = "group2";
    //Group3
    public static final String TABLE_GROUP3 = "group3";
    //Group4
    public static final String TABLE_GROUP4 = "group4";
    //Group5
    public static final String TABLE_GROUP5 = "group5";
    //Group6
    public static final String TABLE_GROUP6 = "group6";
    //Group7
    public static final String TABLE_GROUP7 = "group7";

    //create group1 table
    private static final String SQL_CREATE_TABLE_G1= "CREATE TABLE " + TABLE_GROUP1 + "("
            + COL1 + " TEXT NOT NULL PRIMARY KEY, "
            + COL2 + " TEXT, "
            + COL3 + " TEXT"
            + ");";
    //create group1 table
    private static final String SQL_CREATE_TABLE_G2 = "CREATE TABLE " + TABLE_GROUP2 + "("
            + COL1 + " TEXT NOT NULL PRIMARY KEY, "
            + COL2 + " TEXT, "
            + COL3 + " TEXT"
            + ");";
    //create group1 table
    private static final String SQL_CREATE_TABLE_G3 = "CREATE TABLE " + TABLE_GROUP3 + "("
            + COL1 + " TEXT NOT NULL PRIMARY KEY, "
            + COL2 + " TEXT, "
            + COL3 + " TEXT"
            + ");";
    //create group1 table
    private static final String SQL_CREATE_TABLE_G4 = "CREATE TABLE " + TABLE_GROUP4 + "("
            + COL1 + " TEXT NOT NULL PRIMARY KEY, "
            + COL2 + " TEXT, "
            + COL3 + " TEXT"
            + ");";
    //create group1 table
    private static final String SQL_CREATE_TABLE_G5 = "CREATE TABLE " + TABLE_GROUP5 + "("
            + COL1 + " TEXT NOT NULL PRIMARY KEY, "
            + COL2 + " TEXT, "
            + COL3 + " TEXT"
            + ");";
    //create group1 table
    private static final String SQL_CREATE_TABLE_G6 = "CREATE TABLE " + TABLE_GROUP6 + "("
            + COL1 + " TEXT NOT NULL PRIMARY KEY, "
            + COL2 + " TEXT, "
            + COL3 + " TEXT"
            + ");";
    //create group1 table
    private static final String SQL_CREATE_TABLE_G7 = "CREATE TABLE " + TABLE_GROUP7 + "("
            + COL1 + " TEXT NOT NULL PRIMARY KEY, "
            + COL2 + " TEXT, "
            + COL3 + " TEXT"
            + ");";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_G1);
        db.execSQL(SQL_CREATE_TABLE_G2);
        db.execSQL(SQL_CREATE_TABLE_G3);
        db.execSQL(SQL_CREATE_TABLE_G4);
        db.execSQL(SQL_CREATE_TABLE_G5);
        db.execSQL(SQL_CREATE_TABLE_G6);
        db.execSQL(SQL_CREATE_TABLE_G7);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG,
                "Upgrading the database from version " + oldVersion + " to " + newVersion);
        // clear all data
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROUP1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROUP2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROUP3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROUP4);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROUP5);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROUP6);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROUP7);
        // recreate the tables
        onCreate(db);
    }
    //Group1
    public boolean insert_group1(String day, String phase1, String phase2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL1, day);
        cv.put(COL2, phase1);
        cv.put(COL3, phase2);
        long res = db.insert(TABLE_GROUP1, null, cv);
        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor get_group1() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_GROUP1, null);
        return c;

    }
    public void update_group1(String day, String phase1, String phase2) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_GROUP1 + " SET " + COL2 + "='" + phase1 + "'," + COL3 + "='" + phase2 + "' WHERE " + COL1 + "='" + day + "';");
    }
    //Group2
    public boolean insert_group2(String day, String phase1, String phase2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL1, day);
        cv.put(COL2, phase1);
        cv.put(COL3, phase2);
        long res = db.insert(TABLE_GROUP2, null, cv);
        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor get_group2() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_GROUP2, null);
        return c;

    }
    public void update_group2(String day, String phase1, String phase2) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_GROUP2 + " SET " + COL2 + "='" + phase1 + "'," + COL3 + "='" + phase2 + "' WHERE " + COL1 + "='" + day + "';");
    }
    //Group3
    public boolean insert_group3(String day, String phase1, String phase2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL1, day);
        cv.put(COL2, phase1);
        cv.put(COL3, phase2);
        long res = db.insert(TABLE_GROUP3, null, cv);
        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor get_group3() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_GROUP3, null);
        return c;

    }
    public void update_group3(String day, String phase1, String phase2) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_GROUP3 + " SET " + COL2 + "='" + phase1 + "'," + COL3 + "='" + phase2 + "' WHERE " + COL1 + "='" + day + "';");
    }
    //Group4
    public boolean insert_group4(String day, String phase1, String phase2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL1, day);
        cv.put(COL2, phase1);
        cv.put(COL3, phase2);
        long res = db.insert(TABLE_GROUP4, null, cv);
        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor get_group4() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_GROUP4, null);
        return c;

    }
    public void update_group4(String day, String phase1, String phase2) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_GROUP4 + " SET " + COL2 + "='" + phase1 + "'," + COL3 + "='" + phase2 + "' WHERE " + COL1 + "='" + day + "';");
    }
    //Group5
    public boolean insert_group5(String day, String phase1, String phase2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL1, day);
        cv.put(COL2, phase1);
        cv.put(COL3, phase2);
        long res = db.insert(TABLE_GROUP5, null, cv);
        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor get_group5() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_GROUP5, null);
        return c;

    }
    public void update_group5(String day, String phase1, String phase2) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_GROUP5 + " SET " + COL2 + "='" + phase1 + "'," + COL3 + "='" + phase2 + "' WHERE " + COL1 + "='" + day + "';");
    }
    //Group6
    public boolean insert_group6(String day, String phase1, String phase2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL1, day);
        cv.put(COL2, phase1);
        cv.put(COL3, phase2);
        long res = db.insert(TABLE_GROUP6, null, cv);
        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor get_group6() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_GROUP6, null);
        return c;

    }
    public void update_group6(String day, String phase1, String phase2) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_GROUP6 + " SET " + COL2 + "='" + phase1 + "'," + COL3 + "='" + phase2 + "' WHERE " + COL1 + "='" + day + "';");
    }
    //Group7
    public boolean insert_group7(String day, String phase1, String phase2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL1, day);
        cv.put(COL2, phase1);
        cv.put(COL3, phase2);
        long res = db.insert(TABLE_GROUP7, null, cv);
        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor get_group7() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_GROUP7, null);
        return c;

    }
    public void update_group7(String day, String phase1, String phase2) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_GROUP7 + " SET " + COL2 + "='" + phase1 + "'," + COL3 + "='" + phase2 + "' WHERE " + COL1 + "='" + day + "';");
    }


}
