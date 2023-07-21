package com.mobile.foodorderingproject.Model;

public class NhanVien {
    String tennv, taikhoan, matkhau;
    int manv;

    public NhanVien(String tennv, String taikhoan, String matkhau, int manv) {
        this.tennv = tennv;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.manv = manv;
    }

    public NhanVien() {
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }
}
