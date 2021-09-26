package com.example.fuelshow;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class FuelConsumption extends AppCompatActivity {

    TextView avg_fuel, avg_eco, proflit, fuel,km, price,avgfuel, avgwithineco;
    EditText rsperltr, litres, dkm, dprice, date, time;
    Button result;
    ImageButton save;
    DataBaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_consumption);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        date = (EditText) findViewById(R.id.date);
        time = (EditText) findViewById(R.id.time);
        result = (Button) findViewById(R.id.id_result);
        save = (ImageButton)findViewById(R.id.btnsave);
        proflit = findViewById(R.id.proflit);  // TextView
        fuel = findViewById(R.id.fuel);  // TextView
        km = findViewById(R.id.km);  // TextView
        price = findViewById(R.id.price);  // TextView
        avgfuel = findViewById(R.id.avgfuel);  // TextView
        avgwithineco = findViewById(R.id.avgwithineco);  // TextView
        dprice = findViewById(R.id.id_price); //EditText

        //to calculate avg_fuel
        avg_fuel = findViewById(R.id.id_avg_fuel); //TextView
        litres = findViewById(R.id.id_litres);     //EditText
        dkm = findViewById(R.id.id_km);            //EditText
        //to calculate avg_price per 100km
        avg_eco = findViewById(R.id.id_avg_eco);   //TextView
        rsperltr=findViewById(R.id.id_rsperltr);   //EditText
        avg_fuel=findViewById(R.id.id_avg_fuel);   //TextView


       mydb = new DataBaseHelper(this);

                result.setOnClickListener(v -> {
                    Convertltrper100km();
                    Findavgprice();
                    String newdate = date.getText().toString();
                    String newtime = time.getText().toString();
                    String fuelrsperltr = rsperltr.getText().toString();
                    String fuellitres = litres.getText().toString();
                    String fueldkm = dkm.getText().toString();
                    String fueldprice = dprice.getText().toString();

                    if (newdate.isEmpty() && newtime.isEmpty() && fuelrsperltr.isEmpty() && fuellitres.isEmpty() && fueldkm.isEmpty() && fueldprice.isEmpty()) {
                        Toast.makeText(FuelConsumption.this, "Please enter all the data!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    //  DataBaseHelper.addNewData(fuelrsperltr,fuellitres,fueldkm,fueldprice);

                    // after adding the data,display a toast message.
                    Toast.makeText(FuelConsumption.this, "Data has been added.", Toast.LENGTH_SHORT).show();
                    date.setText("");
                    time.setText("");
                    rsperltr.setText("");
                    litres.setText("");
                    dkm.setText("");
                    dprice.setText("");
                });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  String newdate = date.getText().toString();
                String newtime = time.getText().toString();
                String fuelrsperltr = rsperltr.getText().toString();
                String fuellitres = litres.getText().toString();
                String fueldkm = dkm.getText().toString();
                String fueldprice = dprice.getText().toString();
                processinsert(date.getText().toString(),time.getText().toString(),rsperltr.getText().toString(),litres.getText().toString(),dkm.getText().toString(),dkm.getText().toString());
*/
            }
        });
    }

   /* private void processinsert(String date, String time, String rsperltr, String litres, String dkm, String dprice) {
    String res = new DataBaseHelper(this).addrecord(date,time,rsperltr,litres,dkm,dprice);
        date.setText("");
        time.setText("");
        rsperltr.setText("");
        litres.setText("");
        dkm.setText("");
        dprice.setText("");
        // after adding the data,display a toast message.
        Toast.makeText(FuelConsumption.this, "Data has been added.", Toast.LENGTH_SHORT).show();
    }*/

    @SuppressLint("SetTextI18n")
    private void Convertltrper100km() {
        String valueEnterInLtr = litres.getText().toString();
        String valueEnterInkm = dkm.getText().toString();

        double ltr = Double.parseDouble(valueEnterInLtr);
        double klm = Double.parseDouble(valueEnterInkm);

        double AvgFuel = ltr * klm / 100 ;
        avg_fuel.setText("" + AvgFuel);
    }

    @SuppressLint("SetTextI18n")
    private void Findavgprice() {
        String valueofltrpr100km = avg_fuel.getText().toString();
        String priceperltr = rsperltr.getText().toString();

        double ltrpr100km = Double.parseDouble(valueofltrpr100km);
        double Rs = Double.parseDouble(priceperltr);

        double AvgPriceper100l = ltrpr100km * Rs ;
        avg_eco.setText("" + AvgPriceper100l);
    }

}
