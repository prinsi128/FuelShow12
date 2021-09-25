package com.example.fuelshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class dashboard extends AppCompatActivity {

    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        floatingActionButton =findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(v -> {
            Intent i=new Intent(getApplicationContext(),FuelConsumption.class);
            startActivity(i);
        });
    }
}