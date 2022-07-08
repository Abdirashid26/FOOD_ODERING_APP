package com.example.food_odering_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckOut extends AppCompatActivity {

    ListView ordersList;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        ordersList = findViewById(R.id.ordersList);
        TextView header = new TextView(this);
        header.setText("Order");
        header.setTextSize(30);
        header.setTextColor(Color.BLACK);
        header.setGravity(Gravity.CENTER);
        ordersList.addHeaderView(header);
//        hashmap
        Intent intent = getIntent();

        customAdapter2 custom = new customAdapter2(StaticOrder.staticOrders);
        ordersList.setAdapter(custom);


        total = findViewById(R.id.total);
        List<Integer> values = new ArrayList<>(StaticOrder.staticOrders.values());

        int odersTotal = 0;

        for(int i =0;i<values.size();i++){
            odersTotal += values.get(i);
        }

        total.setText("Total: "+odersTotal);

    }

    public void payOrder(View view) {
        Toast.makeText(this, "Completed Order and Payment..Thank You", Toast.LENGTH_LONG).show();
        StaticOrder.staticOrders = new HashMap<>();
        finish();
    }

//    remove order code
    public void removeOrder(View view) {
        TextView foodName = (TextView) findViewById(R.id.orderName);
        StaticOrder.staticOrders.remove(foodName.getText());
        finish();
        startActivity(getIntent());

    }
}