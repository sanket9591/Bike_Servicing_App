package com.example.bikeservicemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "RIT.db";
    private static final String TABLE_NAME = "USER";
    private static final String Col1_NAME = "Name";
    private static final String Col2_NAME = "Contact";
    private static final String Col3_NAME = "Bike_Manufacturer";
    private static final String Col4_NAME = "Bike_model";
    private static final String Col5_NAME = "Bike_Build_Year";
    private static final String Col6_NAME = "Bike_No";
    private static final String Col7_NAME = "Daily_Running";
    private static final String Col8_NAME = "Address";
    private static final String CID = "_id";
    private static final String SID = "_id1";
    private static final int DATABASE_VERSION = 1;


    public MySQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE if not Exists " + TABLE_NAME +
                " ("
                + CID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Col1_NAME + " TEXT,"
                + Col2_NAME + " TEXT,"
                + Col3_NAME + " TEXT,"
                + Col4_NAME + " TEXT,"
                + Col5_NAME + " TEXT,"
                + Col6_NAME + " TEXT,"
                + Col7_NAME + " TEXT,"
                + Col8_NAME + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        sqLiteDatabase.execSQL(query);

        /*
        try {
            sqLiteDatabase.execSQL("drop table ServiceDetails");
            String query1 = " CREATE TABLE if not Exists ServiceDetails " +
                    " ("
                    + SID + " INTEGER PRIMARY KEY,"
                    + CID + " INTEGER ,"
                    + "FOREIGN KEY (SID) REFERENCES  TABLE_NAME(CID) )";
            sqLiteDatabase.execSQL(query1);
        } catch (Exception e) {
            Log.d("-->", e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }*/
    }


    public void insertRecord(String name, String contact, String Bike_Manufacturer, String Bike_model, String Bike_Build_Year, String Bike_No, String Daily_Running, String Address) {

        try {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(Col1_NAME, name);
            contentValues.put(Col2_NAME, contact);
            contentValues.put(Col3_NAME, Bike_Manufacturer);
            contentValues.put(Col4_NAME, Bike_model);
            contentValues.put(Col5_NAME, Bike_Build_Year);
            contentValues.put(Col6_NAME, Daily_Running);
            contentValues.put(Col7_NAME, Bike_No);
            contentValues.put(Col8_NAME, Address);
            db.insert(TABLE_NAME, null, contentValues);
            db.close();
        } catch (Exception e) {
            Log.d("-->", e.getMessage());
        }
    }
/*
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        //  sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ServiceDetails" );
        onCreate(sqLiteDatabase);
    }*/


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}