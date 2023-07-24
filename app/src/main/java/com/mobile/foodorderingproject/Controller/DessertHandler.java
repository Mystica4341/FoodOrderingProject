package com.mobile.foodorderingproject.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.mobile.foodorderingproject.Model.Dessert;

public class DessertHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "qlch";
    @SuppressLint("SdCardPath")
    private static final String PATH = "/data/data/com.mobile.foodorderingproject/database/FoodOrdering.db";
    private static final String TABLE_NAME = "TrangMieng";
    private static final String MATRANGMIENG_COL = "MaTrangMieng";
    private static final String TENTRANGMIENG_COL = "TenTrangMieng";
    private static final String GIATRANGMIENG_COL = "GiaTrangMieng";
    public DessertHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db = SQLiteDatabase.openDatabase(PATH, null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + MATRANGMIENG_COL +" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + TENTRANGMIENG_COL + " TEXT NOT NULL UNIQUE, " + GIATRANGMIENG_COL + " INTEGER NOT NULL)";
        db.execSQL(sql);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}