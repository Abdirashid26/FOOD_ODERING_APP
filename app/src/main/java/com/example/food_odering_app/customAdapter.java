package com.example.food_odering_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class customAdapter extends ArrayAdapter<Item> {

    Context context;
    int resource;
    List<Item> itemList;

    public customAdapter(@NonNull Context context, int resource, List<Item> itemList) {
        super(context, resource, itemList);

        this.context = context;
        this.resource = resource;
        this.itemList = itemList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(resource,null,false);

        TextView name = view.findViewById(R.id.name);
        ImageView food = view.findViewById(R.id.imageFood);
        TextView description = view.findViewById(R.id.description);

        Item item = itemList.get(position);

        name.setText(item.getName());
        food.setImageResource(item.getImage());
        description.setText(item.getDescription());

        return view;
    }
}
