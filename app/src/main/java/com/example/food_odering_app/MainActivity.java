package com.example.food_odering_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextInputEditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);


        username = findViewById(R.id.user);
        password = findViewById(R.id.pass);

    }

    public void goToMenu(View view) {
        if(username.getText().toString().equals("Group") && password.getText().toString().equals("Group")){
            Intent menu = new Intent(MainActivity.this,FoodsAndDrinks.class);
            startActivity(menu);
        }else{
            Toast.makeText(this, "Wrong Username and Password", Toast.LENGTH_SHORT).show();
        }
    }
}