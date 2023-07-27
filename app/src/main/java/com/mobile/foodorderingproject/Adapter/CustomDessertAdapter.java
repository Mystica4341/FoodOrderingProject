package com.mobile.foodorderingproject.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobile.foodorderingproject.Model.Dessert;
import com.mobile.foodorderingproject.R;

import java.util.List;

public class CustomDessertAdapter extends BaseAdapter {
    List<Dessert> lsDessert;
    private final LayoutInflater layoutInflater;


    @Override
    public int getCount() {
        return lsDessert.size();
    }

    @Override
    public Object getItem(int position) {
        return lsDessert.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        //Tạo view Grid
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.menu_food_drink_dessert_layout, null);
            holder = new CustomDessertAdapter.ViewHolder();
            holder.menuView = (ImageView) convertView.findViewById(R.id.imgMenu);
            holder.nameView = (TextView) convertView.findViewById(R.id.tvName);
            holder.priceView = (TextView) convertView.findViewById(R.id.tvPrice);
            convertView.setTag(holder);
        }
        else{
            holder = (CustomDessertAdapter.ViewHolder) convertView.getTag();
        }
        //Truyền data lên view
        Dessert dessert = this.lsDessert.get(position);
        holder.nameView.setText(dessert.getTenDessert());
        holder.priceView.setText(dessert.getGiaDessert());
        int imageId = this.getMipMapResIdByName(dessert.getImgDessert(), convertView.getContext());
        holder.menuView.setImageResource(imageId);
        return convertView;
    }

    public CustomDessertAdapter(List<Dessert> lsDessert, LayoutInflater layoutInflater) {
        this.lsDessert = lsDessert;
        this.layoutInflater = layoutInflater;
    }

    public int getMipMapResIdByName(String resName, Context context){
        String pkgName = context.getPackageName();
        int ResId = context.getResources().getIdentifier(resName, "mipmap", pkgName);
        Log.i("CustomGridView", "Res Name: "+ resName+"==> Res ID = "+ ResId);
        return ResId;
    }

    static class ViewHolder {
        ImageView menuView;
        TextView nameView, priceView;
    }
}
