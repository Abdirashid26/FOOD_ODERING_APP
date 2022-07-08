package com.example.food_odering_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FoodsAndDrinks extends AppCompatActivity {

    List<Item> listMenu = new ArrayList<>();
    ListView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods_and_drinks);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);


        listMenu.add(new Item("Chapati",R.drawable.chapati,"served with beans, kamande, ndegu and stew",20));
        listMenu.add(new Item("Tea",R.drawable.tea,"served with anything you want !",20));
        listMenu.add(new Item("Coffee",R.drawable.coffee,"served with anything you want !",40));
        listMenu.add(new Item("Pilau",R.drawable.pilau,"served with beans, kamande, ndegu and stew",70));
        listMenu.add(new Item("Bhajia",R.drawable.bhajia,"served with anything you want !",10));
        listMenu.add(new Item("Ugali",R.drawable.ugali,"served with beans,kamande, ndegu, cabbage and stew",70));
        listMenu.add(new Item("Kaimati",R.drawable.kaimati,"served with anything you want !",10));
        listMenu.add(new Item("Soda",R.drawable.soda,"served with anything you want !",30));






//        menu
        menu = findViewById(R.id.menu);

        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setPadding(10,50,20,20);
        textView.setTextColor(Color.BLACK );
        textView.setGravity(Gravity.CENTER);

        textView.setText("Menu");

        menu.addHeaderView(textView);

        customAdapter myAdapter = new customAdapter(this,R.layout.list_item,listMenu);

        menu.setAdapter(myAdapter);


        menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item  = listMenu.get(i - 1);
//                Toast.makeText(FoodsAndDrinks.this, item.getName(), Toast.LENGTH_SHORT).show();
                Intent food = new Intent(FoodsAndDrinks.this,Food.class);
                food.putExtra("name",item.getName());
                food.putExtra("image",item.getImage());
                food.putExtra("description",item.getDescription());
                food.putExtra("price",item.getPrice());
                startActivity(food);
            }
        });



    }
}