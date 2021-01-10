package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.binusezyfood.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private Button btn_drinks;
    private ImageView btn_location;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnTopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String b = binding.topup.getText().toString();
                int a = Integer.parseInt(b);
                if(a > 2000000){
                    binding.balance.setText("Over Limit");
                }else{
                    binding.balance.setText("Rp. "+b);
                }
            }
        });
    }
    public void viewdrink(View v){
        Intent drink = new Intent(this, drinks.class);
        startActivity(drink);
    }

    public void cart(View v){
        Intent cart = new Intent(this,cart.class);
        cart.putExtra("name","kosong");
        cart.putExtra("price", "kosong");
        startActivity(cart);
    }

    public void viewlocation(View v){
        Intent maps= new Intent(this, MapsActivity.class);
        startActivity(maps);
    }
}