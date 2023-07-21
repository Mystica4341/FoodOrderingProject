package com.mobile.foodorderingproject.Model;

public class HoaDon {
    int mahoadon, manhanvien, maban, tongtien;
    String thoigian;

    public HoaDon() {
    }

    public int getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(int mahoadon) {
        this.mahoadon = mahoadon;
    }

    public int getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(int manhanvien) {
        this.manhanvien = manhanvien;
    }

    public int getMaban() {
        return maban;
    }

    public void setMaban(int maban) {
        this.maban = maban;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public HoaDon(int mahoadon, int manhanvien, int maban, int tongtien, String thoigian) {
        this.mahoadon = mahoadon;
        this.manhanvien = manhanvien;
        this.maban = maban;
        this.tongtien = tongtien;
        this.thoigian = thoigian;
    }
}
