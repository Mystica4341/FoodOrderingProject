package com.mobile.foodorderingproject.Model;

public class Food {
    int mafood, giafood;

    public Food(int mafood, int giafood, String tenfood) {
        this.mafood = mafood;
        this.giafood = giafood;
        this.tenfood = tenfood;
    }

    public int getMafood() {
        return mafood;
    }

    public void setMafood(int mafood) {
        this.mafood = mafood;
    }

    public int getGiafood() {
        return giafood;
    }

    public void setGiafood(int giafood) {
        this.giafood = giafood;
    }

    public String getTenfood() {
        return tenfood;
    }

    public void setTenfood(String tenfood) {
        this.tenfood = tenfood;
    }

    public Food() {
    }

    String tenfood;

}
