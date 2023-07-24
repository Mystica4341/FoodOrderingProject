package com.mobile.foodorderingproject.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.mobile.foodorderingproject.Model.NhanVien;

public class NhanVienHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "qlch";
    @SuppressLint("SdCardPath")
    private static final String PATH = "/data/data/com.mobile.foodorderingproject/database/FoodOrdering.db";
    private static final String TABLE_NAME = "NhanVien";
    private static final String MANHANVIEN_COL = "MaNhanVien";
    private static final String TENNHANVIEN_COL = "TenNhanVien";
    private static final String TAIKHOAN_COL = "TaiKhoan";
    private static final String MATKHAU_COL = "MatKhau";
    public NhanVienHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db = SQLiteDatabase.openDatabase(PATH, null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + MANHANVIEN_COL +" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " + TENNHANVIEN_COL + " TEXT NOT NULL UNIQUE, " + TAIKHOAN_COL + " INTEGER NOT NULL," + MATKHAU_COL +" INTEGER NOT NULL)";
        db.execSQL(sql);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
