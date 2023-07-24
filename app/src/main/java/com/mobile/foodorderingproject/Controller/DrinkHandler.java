package com.mobile.foodorderingproject.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DrinkHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "qlch";
    @SuppressLint("SdCardPath")
    private static final String PATH = "/data/data/com.mobile.foodorderingproject/database/FoodOrdering.db";
    private static final String TABLE_NAME = "Drink";
    private static final String MADRINK_COL = "MaDrink";
    private static final String TENDRINK_COL = "TenDring";
    private static final String GIADRINK_COL = "GiaDring";
    public DrinkHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db = SQLiteDatabase.openDatabase(PATH, null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + MADRINK_COL +" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + TENDRINK_COL + " TEXT NOT NULL UNIQUE, " + GIADRINK_COL + " INTEGER NOT NULL)";
        db.execSQL(sql);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}