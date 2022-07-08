package com.example.food_odering_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Food extends AppCompatActivity {

    ImageView imageView;
    TextView name,description,price;

    HashMap<String, Integer> orders = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        imageView = findViewById(R.id.imageNew);
        name = findViewById(R.id.nameNew);
        description = findViewById(R.id.descriptionNew);
        price = findViewById(R.id.priceNew);


        imageView.setImageResource(getIntent().getExtras().getInt("image"));
        name.setText(getIntent().getExtras().getString("name"));
        description.setText(getIntent().getExtras().getString("description"));
        price.setText(String.valueOf(getIntent().getExtras().getInt("price")));

    }

    public void addOrder(View view) {
        TextView food = (TextView) findViewById(R.id.nameNew);
        TextView price = (TextView) findViewById(R.id.priceNew);
        EditText quantity = (EditText) findViewById(R.id.quantity);


        if(!quantity.getText().toString().isEmpty()){
            int n1 = Integer.parseInt(price.getText().toString());
            int n2 = Integer.parseInt(String.valueOf(quantity.getText()));
            int total =  n1 * n2 ;
            StaticOrder.staticOrders.put(food.getText().toString(),total);
            Toast.makeText(this, "Order Added", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Please select Quantity", Toast.LENGTH_SHORT).show();
        }

    }

    public void checkOut(View view) {
        Intent checkOut = new Intent(Food.this,CheckOut.class);
        finish();
        startActivity(checkOut);
    }
}