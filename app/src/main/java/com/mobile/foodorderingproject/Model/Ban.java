package com.mobile.foodorderingproject.Model;

public class Ban {
    public Ban(String trangthai, int maban) {
        this.trangthai = trangthai;
        this.maban = maban;
    }

    String trangthai;
    int maban;

    public String getTrangthai() {
        return trangthai;
    }

    public Ban() {
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public int getMaban() {
        return maban;
    }

    public void setMaban(int maban) {
        this.maban = maban;
    }
}
