package com.mobile.foodorderingproject.Model;

public class Combo {
    int macombo;
    int mafood;

    public Combo() {
    }

    public Combo(int macombo, int mafood, int madrink, int madessert, int giacombo, String tencombo) {
        this.macombo = macombo;
        this.mafood = mafood;
        this.madrink = madrink;
        this.madessert = madessert;
        this.giacombo = giacombo;
        this.tencombo = tencombo;
    }

    int madrink;
    int madessert;

    public int getMacombo() {
        return macombo;
    }

    public void setMacombo(int macombo) {
        this.macombo = macombo;
    }

    public int getMafood() {
        return mafood;
    }

    public void setMafood(int mafood) {
        this.mafood = mafood;
    }

    public int getMadrink() {
        return madrink;
    }

    public void setMadrink(int madrink) {
        this.madrink = madrink;
    }

    public int getMadessert() {
        return madessert;
    }

    public void setMadessert(int madessert) {
        this.madessert = madessert;
    }

    public int getGiacombo() {
        return giacombo;
    }

    public void setGiacombo(int giacombo) {
        this.giacombo = giacombo;
    }

    public String getTencombo() {
        return tencombo;
    }

    public void setTencombo(String tencombo) {
        this.tencombo = tencombo;
    }

    int giacombo;
    String tencombo;
}
