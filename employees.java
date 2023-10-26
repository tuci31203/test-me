
class NhanVien {
    private String tenNhanVien;
    private double luongCoBan, heSoLuong, LUONG_MAX;

    public NhanVien(String t, double l, double h, double max) {
        this.setTenNhanVien(t);
        this.setLuongCoBan(l);
        this.setHeSoLuong(h);
        this.setLUONG_MAX(max);
    }

    public void setTenNhanVien(String o) {
        this.tenNhanVien = o;
    }

    public void setLuongCoBan(double o) {
        this.luongCoBan = o;
    }

    public void setHeSoLuong(double o) {
        this.heSoLuong = o;
    }

    public void setLUONG_MAX(double o) {
        this.LUONG_MAX = o;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public double getLUONG_MAX() {
        return LUONG_MAX;
    }

    public double tinhLuong() {
        return this.luongCoBan * this.heSoLuong;
    }

    public boolean tangLuong(double n) {
        this.setHeSoLuong(this.getHeSoLuong() + n);
        if (this.tinhLuong() > this.LUONG_MAX)
            return false;
        else
            return true;
    }

    public void inTTin() {
        System.out.println("Ten nhan vien:\t" + getTenNhanVien());
        System.out.println("Luong co ban:\t" + getLuongCoBan());
        System.out.println("He so luong:\t" + getHeSoLuong());
        System.out.println("Luong:\t" + tinhLuong());
    }

}

public class employees {
    public static void main(String args[]) {
        NhanVien nv1 = new NhanVien("Banh Thi Banh", 1000, 4.0, 10000.0);
        NhanVien nv2;
        nv2 = new NhanVien("Tong Thi Tong", 999, 3.8, 9000);
        nv1.inTTin();
        System.out.print("Luong moi: ");
        if (nv1.tangLuong(10))
            System.out.println(nv1.tinhLuong());
        else
            System.out.println(nv1.getLUONG_MAX());
        nv2.inTTin();
        nv2.tangLuong(3);
        System.out.print("Luong moi: ");
        if (nv2.tangLuong(2))
            System.out.println(nv2.tinhLuong());
        else
            System.out.println(nv2.getLUONG_MAX());
    }
}

//test
