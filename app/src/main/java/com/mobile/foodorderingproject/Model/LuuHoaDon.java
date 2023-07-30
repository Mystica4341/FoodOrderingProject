package com.mobile.foodorderingproject.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class LuuHoaDon implements Parcelable {

    protected LuuHoaDon(Parcel in) {
        ten = in.readString();
        img = in.readString();
        gia = in.readInt();
        soluong = in.readInt();
    }

    public static final Creator<LuuHoaDon> CREATOR = new Creator<LuuHoaDon>() {
        @Override
        public LuuHoaDon createFromParcel(Parcel in) {
            return new LuuHoaDon(in);
        }

        @Override
        public LuuHoaDon[] newArray(int size) {
            return new LuuHoaDon[size];
        }
    };

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }



    public LuuHoaDon() {
    }


    String ten;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    String img;

    public LuuHoaDon(String ten, String img, int gia, int soluong) {
        this.ten = ten;
        this.img = img;
        this.gia = gia;
        this.soluong = soluong;
    }

    int gia, soluong;

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(ten);
        dest.writeString(img);
        dest.writeInt(gia);
        dest.writeInt(soluong);
    }
}
