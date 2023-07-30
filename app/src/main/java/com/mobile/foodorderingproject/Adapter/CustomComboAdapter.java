package com.mobile.foodorderingproject.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobile.foodorderingproject.Model.Combo;
import com.mobile.foodorderingproject.R;
import com.mobile.foodorderingproject.Controller.ComboHandler;

import java.util.List;

public class CustomComboAdapter extends BaseAdapter {
    List<Combo> lsCombo;
    ComboHandler comboHandler;
    Context context;
    private final LayoutInflater layoutInflater;


    @Override
    public int getCount() {
        return lsCombo.size();
    }

    @Override
    public Object getItem(int position) {
        return lsCombo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        String desc;
        //Tạo view Grid
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.menu_food_drink_dessert_layout, null);
            holder = new CustomComboAdapter.ViewHolder();
            holder.menuView = (ImageView) convertView.findViewById(R.id.imgMenu);
            holder.nameView = (TextView) convertView.findViewById(R.id.tvName);
            holder.priceView = (TextView) convertView.findViewById(R.id.tvPrice);
            holder.descView = (TextView)convertView.findViewById(R.id.tvDesc);
            convertView.setTag(holder);
        }
        else{
            holder = (CustomComboAdapter.ViewHolder) convertView.getTag();
        }
        //Truyền data lên view
        Combo combo = this.lsCombo.get(position);
        holder.nameView.setText(combo.getTenCombo());
        holder.priceView.setText(combo.getGiaCombo());
        int imageId = this.getMipMapResIdByName(combo.getImgCombo(), convertView.getContext());
        if (String.valueOf(combo.getMaDrink()) == null)
            desc = comboHandler.descFoodCombo(combo.getMaFood(),combo.getMaCombo()) + "\n" + comboHandler.descDessertCombo(combo.getMaDessert(),combo.getMaCombo());
        else if (String.valueOf(combo.getMaFood()) == null)
            desc = comboHandler.descDrinkCombo(combo.getMaDrink(),combo.getMaCombo()) + "\n" + comboHandler.descDessertCombo(combo.getMaDessert(),combo.getMaCombo());
        else if (String.valueOf(combo.getMaDessert()) == null)
            desc = comboHandler.descFoodCombo(combo.getMaFood(),combo.getMaCombo()) + "\n" + comboHandler.descDessertCombo(combo.getMaDrink(),combo.getMaCombo());
        else if (String.valueOf(combo.getMaDrink()) == null && String.valueOf(combo.getMaFood()) == null)
            desc = comboHandler.descDessertCombo(combo.getMaDessert(),combo.getMaCombo());
        else if (String.valueOf(combo.getMaDrink()) == null && String.valueOf(combo.getMaDessert()) == null)
            desc = comboHandler.descFoodCombo(combo.getMaFood(),combo.getMaCombo());
        else if (String.valueOf(combo.getMaFood()) == null && String.valueOf(combo.getMaDessert()) == null)
            desc = comboHandler.descDrinkCombo(combo.getMaDrink(),combo.getMaCombo());
        else if (String.valueOf(combo.getMaFood()) == null && String.valueOf(combo.getMaDessert()) == null && String.valueOf(combo.getMaDrink()) == null)
            desc = null;
        else
            desc = comboHandler.descFoodCombo(combo.getMaFood(),combo.getMaCombo()) + "\n" +comboHandler.descDrinkCombo(combo.getMaDrink(),combo.getMaCombo()) + "\n" + comboHandler.descDessertCombo(combo.getMaDessert(),combo.getMaCombo());
        holder.descView.setText(desc);
        holder.menuView.setImageResource(imageId);
        return convertView;
    }

    public CustomComboAdapter(Context aContext, List<Combo> lsCombo) {
        this.context = aContext;
        this.lsCombo = lsCombo;
        layoutInflater = LayoutInflater.from(aContext);
    }

    public int getMipMapResIdByName(String resName, Context context){
        String pkgName = context.getPackageName();
        int ResId = context.getResources().getIdentifier(resName, "mipmap", pkgName);
        Log.i("CustomGridView", "Res Name: "+ resName+"==> Res ID = "+ ResId);
        return ResId;
    }

    static class ViewHolder {
        ImageView menuView;
        TextView nameView, priceView, descView;
    }
}
