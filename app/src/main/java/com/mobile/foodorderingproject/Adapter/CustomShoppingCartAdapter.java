package com.mobile.foodorderingproject.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mobile.foodorderingproject.Model.LuuHoaDon;
import com.mobile.foodorderingproject.Model.ShoppingCart;
import com.mobile.foodorderingproject.R;

import java.util.ArrayList;

public class CustomShoppingCartAdapter extends ArrayAdapter {

    int layoutItem;
    Context context;
    ArrayList<ShoppingCart> arrayListShoppingCart;

    public CustomShoppingCartAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ShoppingCart> objects) {
        super(context, resource, objects);
        this.layoutItem = resource;
        this.context = context;
        this.arrayListShoppingCart = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ShoppingCart shoppingCart = arrayListShoppingCart.get(position);
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(layoutItem,null);
        }

        TextView tvTen = (TextView) convertView.findViewById(R.id.tvTen);
        TextView tvGia = (TextView) convertView.findViewById(R.id.tvGia);
        tvTen.setText(shoppingCart.getTen());
        tvGia.setText(String.valueOf(shoppingCart.getGia()));
        return convertView;
    }
}
