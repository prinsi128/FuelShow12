package com.example.fuelshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView title, signinbtn;
    EditText fullname, driverid, phonenum;
    Button btnsign;
    DataBaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullname = findViewById(R.id.fullname);
        phonenum = findViewById(R.id.phonenum);
        driverid = findViewById(R.id.driverid);
        btnsign=findViewById(R.id.btnsign);
        title = findViewById(R.id.tsignup);
        signinbtn = findViewById(R.id.signin);
        mydb = new DataBaseHelper(this);




        signinbtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, dashboard.class);
            startActivity(intent);
        });


        btnsign.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String afullname = fullname.getText().toString();
                String adriverid= driverid.getText().toString();
                String aphonenum = phonenum.getText().toString();

                Boolean checkinsertdata=mydb.insertuserdata(afullname, adriverid, aphonenum);
                if(checkinsertdata){
                    Toast.makeText(MainActivity.this,"Registration Successfully!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Registration Failed, Try again!",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

}
