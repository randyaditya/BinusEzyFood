package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class drinks extends AppCompatActivity {

    private Button btn_juice;
    private Button btn_coffee;
    private Button btn_soda;
    private Button btn_water;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        btn_juice = findViewById(R.id.btn_juice);
        btn_juice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                juice();
            }
        });

        btn_coffee = findViewById(R.id.btn_coffee);
        btn_coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffee();
            }
        });

        btn_soda = findViewById(R.id.btn_soda);
        btn_soda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soda();
            }
        });

        btn_water = findViewById(R.id.btn_water);
        btn_water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                water();
            }
        });

    }
    public void juice(){
        Intent order = new Intent(this, order.class);
        order.putExtra("name","JUICE");
        order.putExtra("price", "Rp.15.000");
        startActivity(order);
    }

    public void coffee(){
        Intent order = new Intent(this, order.class);
        order.putExtra("name","COFFEE");
        order.putExtra("price", "Rp.25.000");
        startActivity(order);
    }

    public void soda(){
        Intent order = new Intent(this, order.class);
        order.putExtra("name","SODA");
        order.putExtra("price", "Rp.10.000");
        startActivity(order);
    }

    public void water(){
        Intent order = new Intent(this, order.class);
        order.putExtra("name","WATER");
        order.putExtra("price", "Rp.5.000");
        startActivity(order);
    }

    public void cart(View v){
        Intent cart = new Intent(this,cart.class);
        cart.putExtra("name","kosong");
        cart.putExtra("price", "kosong");
        startActivity(cart);
    }

}