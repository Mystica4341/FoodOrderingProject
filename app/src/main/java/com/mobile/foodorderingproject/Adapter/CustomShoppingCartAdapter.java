package com.mobile.foodorderingproject.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mobile.foodorderingproject.Model.LuuHoaDon;
import com.mobile.foodorderingproject.R;

import java.util.ArrayList;

public class CustomShoppingCartAdapter extends ArrayAdapter {

    int layoutItem;
    Context context;
    ArrayList<LuuHoaDon> arrayListLuuHoaDon;

    public CustomShoppingCartAdapter(@NonNull Context context, int resource, @NonNull ArrayList<LuuHoaDon> objects) {
        super(context, resource, objects);
        this.layoutItem = resource;
        this.context = context;
        this.arrayListLuuHoaDon = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LuuHoaDon luuHoaDon = arrayListLuuHoaDon.get(position);
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(layoutItem,null);
        }

        TextView tvTen = (TextView) convertView.findViewById(R.id.tvTen);
        TextView tvGia = (TextView) convertView.findViewById(R.id.tvGia);
        tvTen.setText(luuHoaDon.getTen());
        tvGia.setText(String.valueOf(luuHoaDon.getGia()));
        return convertView;
    }
}
