package com.mobile.foodorderingproject.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobile.foodorderingproject.Model.Drink;
import com.mobile.foodorderingproject.R;

import java.util.List;

public class CustomDrinkAdapter extends BaseAdapter {
    List<Drink> lsDrink;
    private final LayoutInflater layoutInflater;


    @Override
    public int getCount() {
        return lsDrink.size();
    }

    @Override
    public Object getItem(int position) {
        return lsDrink.get(position);
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
            holder = new CustomDrinkAdapter.ViewHolder();
            holder.menuView = (ImageView) convertView.findViewById(R.id.imgMenu);
            holder.nameView = (TextView) convertView.findViewById(R.id.tvName);
            holder.priceView = (TextView) convertView.findViewById(R.id.tvPrice);
            convertView.setTag(holder);
        }
        else{
            holder = (CustomDrinkAdapter.ViewHolder) convertView.getTag();
        }
        //Truyền data lên view
        Drink drink = this.lsDrink.get(position);
        holder.nameView.setText(drink.getTenDrink());
        holder.priceView.setText(drink.getGiaDrink());
        int imageId = this.getMipMapResIdByName(drink.getImgDrink(), convertView.getContext());
        holder.menuView.setImageResource(imageId);
        return convertView;
    }

    public CustomDrinkAdapter(List<Drink> lsDrink, LayoutInflater layoutInflater) {
        this.lsDrink = lsDrink;
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
