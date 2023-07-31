package com.mobile.foodorderingproject.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobile.foodorderingproject.Model.Food;
import com.mobile.foodorderingproject.R;

import java.util.ArrayList;
import java.util.List;

public class CustomFoodAdapter extends BaseAdapter {

Context context;
    List<Food> lsFood;
    private final LayoutInflater layoutInflater;


    @Override
    public int getCount() {
        return lsFood.size();
    }

    @Override
    public Object getItem(int position) {
        return lsFood.get(position);
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
            holder = new ViewHolder();
            holder.menuView = (ImageView) convertView.findViewById(R.id.imgMenu);
            holder.nameView = (TextView) convertView.findViewById(R.id.tvName);
            holder.priceView = (TextView) convertView.findViewById(R.id.tvPrice);
            holder.btnImgPlus = (ImageButton) convertView.findViewById(R.id.btnImgPlus);
            holder.btnImgMinus = (ImageButton) convertView.findViewById(R.id.btnImgMinus);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        //Truyền data lên view
        Food food = this.lsFood.get(position);
        holder.nameView.setText(food.getTenFood());
        holder.priceView.setText(String.valueOf(food.getGiaFood()));
        int imageId = this.getMipMapResIdByName(food.getImgFood());
        holder.menuView.setImageResource(imageId);
        holder.btnImgPlus.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                ((GridView)parent).performItemClick(v, position, 0);
            }
        });
        holder.btnImgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GridView)parent).performItemClick(v, position, 0);
            }
        });
        return convertView;
    }

    public CustomFoodAdapter(Context aContext, ArrayList<Food> lsFood) {
        this.lsFood = lsFood;
        this.layoutInflater = LayoutInflater.from(aContext);
       this.context = aContext;
    }

    public int getMipMapResIdByName(String resName){
        String pkgName = context.getPackageName();
        int ResId = context.getResources().getIdentifier(resName, "mipmap", pkgName);
        return ResId;
    }

    static class ViewHolder {
        ImageButton btnImgPlus, btnImgMinus;
        ImageView menuView;
        TextView nameView, priceView;
    }
}
