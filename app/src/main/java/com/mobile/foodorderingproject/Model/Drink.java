package com.mobile.foodorderingproject.Model;

public class Drink {
    public Drink() {
    }

    public Drink(int madrink, int giadrink, String tendrink) {
        this.madrink = madrink;
        this.giadrink = giadrink;
        this.tendrink = tendrink;
    }

    public int getMadrink() {
        return madrink;
    }

    public void setMadrink(int madrink) {
        this.madrink = madrink;
    }

    public int getGiadrink() {
        return giadrink;
    }

    public void setGiadrink(int giadrink) {
        this.giadrink = giadrink;
    }

    public String getTendrink() {
        return tendrink;
    }

    public void setTendrink(String tendrink) {
        this.tendrink = tendrink;
    }

    int madrink, giadrink;
    String tendrink;

}
