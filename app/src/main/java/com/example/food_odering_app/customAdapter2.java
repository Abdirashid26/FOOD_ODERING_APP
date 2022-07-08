package com.example.food_odering_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class customAdapter2 extends BaseAdapter {
    private final ArrayList mData;

    public customAdapter2(Map<String, Integer> map) {
        mData = new ArrayList();
        mData.addAll(map.entrySet());
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Map.Entry<String, Integer> getItem(int position) {
        return (Map.Entry) mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO implement you own logic with ID
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View result;

        if (convertView == null) {
            result = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders, parent, false);
        } else {
            result = convertView;
        }

        Map.Entry<String, Integer> item = getItem(position);

        // TODO replace findViewById by ViewHolder
        ((TextView) result.findViewById(R.id.orderName)).setText(item.getKey());
        ((TextView) result.findViewById(R.id.orderPrice)).setText("Price: "+item.getValue());

        System.out.println(item.getKey());

        return result;
    }
}