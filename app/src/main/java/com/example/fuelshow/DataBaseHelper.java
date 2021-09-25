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
        mydb.execSQL("create Table Average(date TEXT,time TEXT,did1 TEXT,codometer Text,lodometer TEXT,priceperl TEXT,totalcost TEXT,liter TEXT,average TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase mydb, int i, int i1) {
        mydb.execSQL("drop Table if exists DriverInfo");
        mydb.execSQL("drop Table if exists Average");
    }

    public Boolean insertuserdata(String fullname, String phonenum, String driverid){

        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",fullname);
        contentValues.put("phone",phonenum);
        contentValues.put("did",driverid);
        long result = mydb.insert("DriverInfo",null,contentValues);
        return result != -1;
    }

    public Boolean averagedata(String date, String time, String did1, String codometer, String lodometer,String priceperl,String totalcost,String liter,String average){

        SQLiteDatabase mydb=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date",date);
        contentValues.put("time",time);
        contentValues.put("did1",did1);
        contentValues.put("codometer",codometer);
        contentValues.put("lodometer",lodometer);
        contentValues.put("priceperl",priceperl);
        contentValues.put("totalcost",totalcost);
        contentValues.put("liter",liter);
        contentValues.put("average",average);
        long result = mydb.insert("Average",null,contentValues);
        return result != -1;
    }


    public Cursor getdata()
    {
        SQLiteDatabase mydb=this.getWritableDatabase();
        return mydb.rawQuery("Select * from Userdetails", null);

    }


}


