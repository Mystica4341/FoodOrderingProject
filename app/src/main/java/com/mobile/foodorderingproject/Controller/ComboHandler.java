package com.mobile.foodorderingproject.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ComboHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "qlch";
    @SuppressLint("SdCardPath")
    private static final String PATH = "/data/data/com.mobile.foodorderingproject/database/FoodOrdering.db";
    private static final String TABLE_NAME = "Combo";
    private static final String MACOMBO_COL = "MaCombo";
    private static final String TENCOMBO_COL = "TenCombo";
    private static final String GIACOMBO_COL = "GiaCombo";
    private static final String MADOAN_COL = "MaDoAn";
    private static final String MADOUONG_COL = "MaDoUong";
    private static final String MATRANGMIENG_COL = "MaTrangMieng";
    public ComboHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db = SQLiteDatabase.openDatabase(PATH, null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + MACOMBO_COL +" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + TENCOMBO_COL + " TEXT NOT NULL UNIQUE, " + GIACOMBO_COL + " INTEGER NOT NULL, " + MADOAN_COL + " INTERGER NOT NULL, " + MADOUONG_COL + " INTERGER NOT NULL, "+ MATRANGMIENG_COL + " INTERGER  NOT NULL, FOREIGN KEY ("+ MATRANGMIENG_COL+ ","+MADOAN_COL+","+MADOUONG_COL+") REFERENCES (()) )";
        db.execSQL(sql);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
