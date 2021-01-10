package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class complete extends AppCompatActivity {

    TextView nameCart, priceCart,qty,sum,date,time;
    ImageView home;
    Bundle bundle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        nameCart = (TextView) findViewById(R.id.name);
        priceCart = (TextView) findViewById(R.id.price);
        qty = (TextView) findViewById(R.id.qty);
        sum = (TextView)findViewById(R.id.total);
        date = (TextView) findViewById(R.id.date);
        time = (TextView) findViewById(R.id.time);
        bundle = getIntent().getExtras();

        if (bundle != null) {
            String name = bundle.getString("name");
            String price = bundle.getString("price");
            String value = bundle.getString("qty");

            int q = Integer.parseInt(value);

            setUp(name, price,value,q);
        }

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MMM/yyyy");
        String dates = simpleDateFormat.format(calendar.getTime());
        date.setText("DATE     : "+dates);

        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm:ss");
        String times = simpleTimeFormat.format((calendar.getTime()));
        time.setText("TIME     : "+times);


    }


    private void setUp(String name, String price, String value,int q) {
        qty.setText("QUANTITY : "+value);
        if (name.equals("ORDER    : JUICE")) {
            nameCart.setText(name);
            priceCart.setText(price);
            int p = 15000;
            int total = p*q;
            sum.setText("Total    : Rp." + total);

        } else if (name.equals("ORDER    : COFFEE")) {
            nameCart.setText(name);
            priceCart.setText(price);
            int p = 25000;
            int total = p*q;
            sum.setText("Total    : Rp." + total);
        } else if (name.equals("ORDER    : SODA")) {
            nameCart.setText(name);
            priceCart.setText(price);
            int p = 10000;
            int total = p*q;
            sum.setText("Total    : Rp." + total);
        } else if (name.equals("ORDER    : WATER")) {
            nameCart.setText(name);
            priceCart.setText(price);
            int p = 5000;
            int total = p*q;
            sum.setText("Total    : Rp." + total);
        } else {
            nameCart.setText("Order");
            priceCart.setText("First");
            sum.setText("-");
        }
    }

    public void home(View v){
        Intent home = new Intent(this,MainActivity.class);
        startActivity(home);
    }
}