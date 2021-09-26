package com.example.fuelshow;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(Context context) {
        super(context, "Userdata.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase mydb) {
        mydb.execSQL("create Table DriverInfo(fullname TEXT,phonenum TEXT,driverid TEXT primary key )");
        mydb.execSQL("create Table Efficiency(date TEXT,time TEXT,proflit TEXT, fuel Text,km TEXT,price TEXT,avgfuel TEXT,avgwithineco TEXT, dprice TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase mydb, int i, int i1) {
        mydb.execSQL("drop Table if exists DriverInfo");
        mydb.execSQL("drop Table if exists Efficiency");
    }

    public Boolean insertuserdata(String fullname, String phonenum, String driverid){

        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("fullname",fullname);
        cv.put("phonenum",phonenum);
        cv.put("driverid",driverid);
        long result = mydb.insert("DriverInfo",null,cv);
        return result != -1;
    }

    public Boolean averagedata(String date, String time, String proflit , String fuel, String km,String price,String avgfuel,String avgwithineco,String dprice)
    {
        SQLiteDatabase mydb=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("date",date);
        cv.put("time",time);
        cv.put("proflit",proflit);
        cv.put("fuel",fuel);
        cv.put("km",km);
        cv.put("price",price);
        cv.put("avgfuel",avgfuel);
        cv.put("avgwithineco",avgwithineco);
        cv.put("dprice",dprice);
        long result = mydb.insert("Efficiency",null,cv);
        return result != -1;
    }


    public Cursor getalldata()
    {
        SQLiteDatabase mydb=this.getWritableDatabase();
        Cursor cursor =  mydb.rawQuery("Select * from Userdetails", null);
        return cursor;
    }


}


