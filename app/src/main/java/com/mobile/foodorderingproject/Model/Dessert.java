package com.mobile.foodorderingproject.Model;

public class Dessert {
    int madessert, giadessert;
    String tendessert;

    public int getMadessert() {
        return madessert;
    }

    public Dessert(int madessert, int giadessert, String tendessert) {
        this.madessert = madessert;
        this.giadessert = giadessert;
        this.tendessert = tendessert;
    }

    public Dessert() {
    }

    public void setMadessert(int madessert) {
        this.madessert = madessert;
    }

    public int getGiadessert() {
        return giadessert;
    }

    public void setGiadessert(int giadessert) {
        this.giadessert = giadessert;
    }

    public String getTendessert() {
        return tendessert;
    }

    public void setTendessert(String tendessert) {
        this.tendessert = tendessert;
    }
}
