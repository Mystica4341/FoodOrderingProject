package com.mobile.foodorderingproject.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Objects;

public class ComboHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "qlch";
    @SuppressLint("SdCardPath")
    private static final String PATH = "/data/data/com.mobile.foodorderingproject/database/FoodOrdering.db";
    private static final String TABLE_NAME = "Combo";
    private static final String MACOMBO_COL = "MaCombo";
    private static final String TENCOMBO_COL = "TenCombo";
    private static final String GIACOMBO_COL = "GiaCombo";
    private static final String MADOAN_COL = "MaFood";
    private static final String MADOUONG_COL = "MaDrink";
    private static final String MATRANGMIENG_COL = "MaDessert";
    static final String TABLE_DATA_FOOD = "Food";
    static final String TABLE_DATA_DRINK = "Drink";
    static final String TABLE_DATA_DESSERT = "Dessert";
    public ComboHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db = SQLiteDatabase.openDatabase(PATH, null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " + MACOMBO_COL +" INTEGER NOT NULL UNIQUE, " + TENCOMBO_COL + " TEXT NOT NULL UNIQUE, " + GIACOMBO_COL + " INTEGER NOT NULL, " + MADOAN_COL + " INTERGER NOT NULL REFERENCES Food("+MADOAN_COL+"), " + MADOUONG_COL + " INTERGER NOT NULL REFERENCES Drink("+MADOUONG_COL+"), "+ MATRANGMIENG_COL + " INTERGER  NOT NULL REFERENCES Dessert("+MATRANGMIENG_COL+"))";
        db.execSQL(sql);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public String descFoodCombo(int maFood, int maCombo){
        String result = "";
        SQLiteDatabase db = SQLiteDatabase.openDatabase(PATH, null,SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = db.rawQuery("SELECT TenFood FROM " + TABLE_DATA_FOOD + " WHERE MaFood = ? and MaCombo = ?", new String[]{String.valueOf(maFood), String.valueOf(maCombo)});
        cursor.moveToFirst();
        do{
            String temp2 = "";
            int i = 0;
            String temp1 = cursor.getString(0);
            if (temp1 != null){
                i = 1;
            }
            if(Objects.equals(temp1, temp2)){
                i += 1;
                result = i + " " + temp1;
            }
            else
                result = i + " " + temp1;
            temp2 = temp1;
            temp1 = "";
        }while(cursor.moveToNext());
        return result;
    }
    public String descDrinkCombo(int maDrink, int maCombo){
        String result = "";
        SQLiteDatabase db = SQLiteDatabase.openDatabase(PATH, null,SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = db.rawQuery("SELECT TenDrink FROM " + TABLE_DATA_DRINK + " WHERE MaDrink = ? and MaCombo = ?", new String[]{String.valueOf(maDrink), String.valueOf(maCombo)});
        cursor.moveToFirst();
        do{
            String temp2 = "";
            int i = 0;
            String temp1 = cursor.getString(0);
            if (temp1 != null){
                i = 1;
            }
            if(Objects.equals(temp1, temp2)){
                i += 1;
                result = i + " " + temp1;
            }
            else
                result = i + " " + temp1;
            temp2 = temp1;
            temp1 = "";
        }while(cursor.moveToNext());
        return result;
    }
    public String descDessertCombo(int maDessert, int maCombo){
        String result = "";
        SQLiteDatabase db = SQLiteDatabase.openDatabase(PATH, null,SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = db.rawQuery("SELECT TenDessert FROM " + TABLE_DATA_DESSERT + " WHERE MaDessert = ? and MaCombo = ?", new String[]{String.valueOf(maDessert), String.valueOf(maCombo)});
        cursor.moveToFirst();
        do{
            String temp2 = "";
            int i = 0;
            String temp1 = cursor.getString(0);
            if (temp1 != null){
                i = 1;
            }
            if(Objects.equals(temp1, temp2)){
                i += 1;
                result = i + " " + temp1;
            }
            else
                result = i + " " + temp1;
            temp2 = temp1;
            temp1 = "";
        }while(cursor.moveToNext());
        return result;
    }
}
