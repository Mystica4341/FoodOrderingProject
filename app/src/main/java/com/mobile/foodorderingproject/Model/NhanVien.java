package com.mobile.foodorderingproject.Model;

public class NhanVien {
    String tenNv, taiKhoan, matKhau;
    int maNv;

    public NhanVien(String tennv, String taikhoan, String matkhau, int manv) {
        this.tenNv = tennv;
        this.taiKhoan = taikhoan;
        this.matKhau = matkhau;
        this.maNv = manv;
    }

    public NhanVien() {
    }

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getMaNv() {
        return maNv;
    }

    public void setMaNv(int maNv) {
        this.maNv = maNv;
    }
}
