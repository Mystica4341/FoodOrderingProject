package com.mobile.foodorderingproject.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BanHandler extends SQLiteOpenHelper {


    private static final String DB_NAME = "qlch";
    @SuppressLint("SdCardPath")
    private static final String PATH = "/data/data/com.mobile.foodorderingproject/database/FoodOrdering.db";
    private static final String TABLE_NAME = "Ban";
    private static final String MABAN_COL = "MaBan";
    private static final String TRANGTHAI_COL = "TrangThai";

    public BanHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db = SQLiteDatabase.openDatabase(PATH, null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + MABAN_COL +" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + TRANGTHAI_COL + " TEXT NOT NULL UNIQUE)";
        db.execSQL(sql);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

