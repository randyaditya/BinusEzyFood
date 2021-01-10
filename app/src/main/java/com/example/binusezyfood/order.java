package com.example.binusezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class order extends AppCompatActivity {

    TextView nameOrder,priceOrder,value;
    ImageView orderImg;
    int count = 0;
    Bundle bundle;

    private Button order;
    private ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        nameOrder = (TextView) findViewById(R.id.name);
        priceOrder = (TextView) findViewById(R.id.price);

        orderImg = (ImageView) findViewById(R.id.cartImg);

        value = (TextView) findViewById(R.id.value);

        bundle = getIntent().getExtras();

        order = findViewById(R.id.more);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

        cart = findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = bundle.getString("name");
                cart(name);
            }
        });

        if(bundle != null){
            String name = bundle.getString("name");
            String price = bundle.getString("price");

            setUp(name,price);
        }
    }

    private void setUp(String name, String price) {
        if (name.equals("JUICE")){
            nameOrder.setText(name);
            priceOrder.setText(price);
            orderImg.setImageResource(R.drawable.juice);
        }else if(name.equals("COFFEE")){
            nameOrder.setText(name);
            priceOrder.setText(price);
            orderImg.setImageResource(R.drawable.coffee);
        }else if(name.equals("SODA")){
            nameOrder.setText(name);
            priceOrder.setText(price);
            orderImg.setImageResource(R.drawable.soda);
        }else if(name.equals("WATER")){
            nameOrder.setText(name);
            priceOrder.setText(price);
            orderImg.setImageResource(R.drawable.water);
        }
    }

    public void back(){
        Intent back = new Intent(this,drinks.class);
        startActivity(back);
    }

    public void cart(String name){
        Intent cart = new Intent(this, cart.class);
        if(name.equals("JUICE")){
            cart.putExtra("name","JUICE");
            cart.putExtra("price", "Rp.15.000");
            startActivity(cart);
        }else if(name.equals("COFFEE")){
            cart.putExtra("name","COFFEE");
            cart.putExtra("price", "Rp.25.000");
            startActivity(cart);
        }else if(name.equals("SODA")){
            cart.putExtra("name","SODA");
            cart.putExtra("price", "Rp.10.000");
            startActivity(cart);
        }else if(name.equals("WATER")){
            cart.putExtra("name","WATER");
            cart.putExtra("price", "Rp.5.000");
            startActivity(cart);
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
}