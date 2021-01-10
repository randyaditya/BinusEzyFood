package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class cart extends AppCompatActivity {

    TextView nameCart,priceCart,value;
    ImageView imgCart;
    int count = 0;
    private Button pay;

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        nameCart = (TextView) findViewById(R.id.name);
        priceCart = (TextView) findViewById(R.id.price);

        imgCart = (ImageView) findViewById(R.id.cartImg);

        bundle = getIntent().getExtras();

        value = (TextView) findViewById(R.id.value);


        if(bundle != null){
            String name = bundle.getString("name");
            String price = bundle.getString("price");
            setUp(name,price);
        }

        pay = findViewById(R.id.pay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = bundle.getString("name");
                String nilai = value.getText().toString();
                pay(name,nilai);
            }
        });
    }

    private void setUp(String name, String price) {
        if (name.equals("JUICE")){
            nameCart.setText(name);
            priceCart.setText(price);
            imgCart.setImageResource(R.drawable.juice);
        }else if(name.equals("COFFEE")){
            nameCart.setText(name);
            priceCart.setText(price);
            imgCart.setImageResource(R.drawable.coffee);
        }else if(name.equals("SODA")){
            nameCart.setText(name);
            priceCart.setText(price);
            imgCart.setImageResource(R.drawable.soda);
        }else if(name.equals("WATER")){
            nameCart.setText(name);
            priceCart.setText(price);
            imgCart.setImageResource(R.drawable.water);
        }else{
            nameCart.setText("Order");
            priceCart.setText("First");
            imgCart.setImageResource(R.drawable.empty);
        }
    }

    public void plus(View v){
        count++;
        value.setText("" + count);
    }
    public void min(View v){
        if(count <= 0) count=0;
        else count--;
        value.setText(""+ count);
    }

    public void pay(String name, String nilai){
        Intent pay = new Intent(this, complete.class);
        pay.putExtra("qty",nilai);
        if(name.equals("JUICE")){
            pay.putExtra("name","ORDER    : JUICE");
            pay.putExtra("price", "PRICE    : Rp.15000");
            startActivity(pay);
        }else if(name.equals("COFFEE")){
            pay.putExtra("name","ORDER    : COFFEE");
            pay.putExtra("price", "PRICE    : Rp.25000");
            startActivity(pay);
        }else if(name.equals("SODA")){
            pay.putExtra("name","ORDER    : SODA");
            pay.putExtra("price", "PRICE    : Rp.10000");
            startActivity(pay);
        }else if(name.equals("WATER")){
            pay.putExtra("name","ORDER    : WATER");
            pay.putExtra("price", "ORDER    : Rp.5000");
            startActivity(pay);
        }
    }
}