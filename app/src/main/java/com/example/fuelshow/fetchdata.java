package com.example.fuelshow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class fetchdata extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<fuelEff> dataholder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetchdata);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor = new DataBaseHelper(this).getalldata();

        while (cursor.moveToNext())
        {
            fuelEff obj = new fuelEff(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));
            dataholder.add(obj);
        }
        myAdpt adpt = new myAdpt(dataholder);
                recyclerView.setAdapter(adpt);
    }
}