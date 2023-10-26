package myClassPackage;

public class NhanVien {
    private String tenNhanVien;
    private double luongCoBan, heSoLuong, LUONG_MAX;
    //GET
    public String getTenNhanVien(){
        return tenNhanVien;
    }
    public double getLuongCoBan(){
        return luongCoBan;
    }
    public double getHeSoLuong(){
        return heSoLuong;
    }
    public double getLUONG_MAX(){
        return LUONG_MAX;
    }

    //SET
    public void setTenNhanVien(String tenNhanVien){
        this.tenNhanVien = tenNhanVien;
    }
    public void setLuongCoBan(double luongCoBan){
        this.luongCoBan =luongCoBan;
    }
    public void setHeSoLuong(double heSoLuong){
        this.heSoLuong = heSoLuong;
    }
    public void setLUONG_MAX(double MAX){
        this.LUONG_MAX = MAX;
    }

    //OTHER METHODS
    public double tinhLuong(){
        return luongCoBan*heSoLuong;
    }
    public boolean tangLuong(double a){
        this.heSoLuong += a;
        if (this.tinhLuong() > this.LUONG_MAX){
            System.out.println("Vuot qua muc luong cho phep");
            return false;
        } else return true;
    }
    public void inTTin(){
        System.out.println("Ten nhan vien:\t"+ tenNhanVien);
        System.out.println("Luong co ban:\t"+ luongCoBan);
        System.out.println("He so luong:\t"+ heSoLuong);
        System.out.println("Luong toi da cho phep:\t"+ LUONG_MAX);
        System.out.println("Luong hien tai:\t"+this.tinhLuong());
    }
}
