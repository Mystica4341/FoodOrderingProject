package com.mobile.foodorderingproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobile.foodorderingproject.Model.Combo;
import com.mobile.foodorderingproject.Model.Dessert;
import com.mobile.foodorderingproject.Model.Drink;
import com.mobile.foodorderingproject.Model.Food;
import com.mobile.foodorderingproject.R;
import com.mobile.foodorderingproject.View.MainActivity;

import java.util.List;

public class CustomMenuAdapter extends BaseAdapter {

    private List<Food> lsFood;
    private List<Drink> lsDrink;
    private List<Dessert> lsDessert;
    private List<Combo> lsCombo;
    private LayoutInflater layoutInflater;

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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        // NUll = chưa có => tạo mới
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.menu_item_layout, null);
            holder = new ViewHolder();
            holder.menuView = (ImageView) convertView.findViewById(R.id.imgMenu);
            holder.nameView = (TextView) convertView.findViewById(R.id.tvName);
            holder.priceView = (TextView) convertView.findViewById(R.id.tvPrice);
            convertView.setTag(holder);
        }
        //nếu có thì đổi thành get thông tin
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        //giá trị tại vị trí position
        Food food = this.lsFood.get(position);
        //gọi getter của class Country
        holder.nameView.setText(food.getTenFood());
        holder.priceView.setText("" + food.getGiaFood());
        int imageId = this.getMipMapResIdByName(food.getImgFood(), convertView.getContext());
        holder.menuView.setImageResource(imageId);
        return convertView;
    }

    public CustomMenuAdapter(List<Food> lsFood, LayoutInflater layoutInflater) {
        this.lsFood = lsFood;
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
    public void  MenuFood ()
    {
        Intent intent = new Intent(CustomMenuAdapter.this, MainActivity.class);
    }
}
