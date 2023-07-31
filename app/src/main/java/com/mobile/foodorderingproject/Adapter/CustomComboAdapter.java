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

import java.util.ArrayList;

public class CustomComboAdapter extends BaseAdapter {
    ArrayList<Combo> arrayListCombo;

    Context context;
    private final LayoutInflater layoutInflater;


    @Override
    public int getCount() {
        return arrayListCombo.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListCombo.get(position);
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
            convertView = layoutInflater.inflate(R.layout.menu_combo_layout, null);
            holder = new CustomComboAdapter.ViewHolder();
            holder.menuView = (ImageView) convertView.findViewById(R.id.imgMenu);
            holder.nameView = (TextView) convertView.findViewById(R.id.tvName);
            holder.priceView = (TextView) convertView.findViewById(R.id.tvPrice);
            holder.descView = (TextView)convertView.findViewById(R.id.tvDesc);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        //Truyền data lên view
        Combo combo = this.arrayListCombo.get(position);
        ComboHandler comboHandler = new ComboHandler(convertView.getContext(),ComboHandler.DB_NAME,null,1);
        holder.nameView.setText(combo.getTenCombo());
        holder.priceView.setText(String.valueOf(combo.getGiaCombo()));
        int imageId = this.getMipMapResIdByName(combo.getImgCombo(), convertView.getContext());
        String desc;
        if (combo.getMaDrink() == 0)
            desc = comboHandler.descFoodCombo(combo.getMaFood(),combo.getMaCombo()) + "\n" + comboHandler.descDessertCombo(combo.getMaDessert(),combo.getMaCombo());
        else if (combo.getMaFood() == 0)
            desc = comboHandler.descDrinkCombo(combo.getMaDrink(),combo.getMaCombo()) + "\n" + comboHandler.descDessertCombo(combo.getMaDessert(),combo.getMaCombo());
        else if (combo.getMaDessert() == 0)
            desc = comboHandler.descFoodCombo(combo.getMaFood(),combo.getMaCombo()) + "\n" + comboHandler.descDessertCombo(combo.getMaDrink(),combo.getMaCombo());
        else if (combo.getMaDrink() == 0 && combo.getMaFood() == 0)
            desc = comboHandler.descDessertCombo(combo.getMaDessert(),combo.getMaCombo());
        else if (combo.getMaDrink() == 0 && combo.getMaDessert() == 0)
            desc = comboHandler.descFoodCombo(combo.getMaFood(),combo.getMaCombo());
        else if (combo.getMaFood() == 0 && combo.getMaDessert() == 0)
            desc = comboHandler.descDrinkCombo(combo.getMaDrink(),combo.getMaCombo());
        else if (combo.getMaFood() == 0 && combo.getMaDessert() == 0 && combo.getMaDrink() == 0)
            desc = null;
        else
            desc = comboHandler.descFoodCombo(combo.getMaFood(),combo.getMaCombo())
                    + "\n" +comboHandler.descDrinkCombo(combo.getMaDrink(),combo.getMaCombo())
                    + "\n" + comboHandler.descDessertCombo(combo.getMaDessert(),combo.getMaCombo());
        holder.descView.setText(desc);
        holder.menuView.setImageResource(imageId);
        return convertView;
    }

    public CustomComboAdapter(Context aContext, ArrayList<Combo> lsCombo) {
        this.context = aContext;
        this.arrayListCombo = lsCombo;
        this.layoutInflater = LayoutInflater.from(aContext);
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
