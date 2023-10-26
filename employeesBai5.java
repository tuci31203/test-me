import java.util.Random;
import java.util.random.*;
class NhanVien{
    private String tenNhanVien;
    private double luongCoBan, heSoLuong, LUONG_MAX;
    static int soNhanVien;
    public NhanVien(String t, double l, double h, double max){
        this.setTenNhanVien(t);
        this.setLuongCoBan(l);
        this.setHeSoLuong(h);
        this.setLUONG_MAX(max);
        soNhanVien++;
    }

    public void setTenNhanVien(String o){
        this.tenNhanVien = o;
    }
    public void setLuongCoBan(double o){
        this.luongCoBan = o;
    }
    public void setHeSoLuong(double o){
        this.heSoLuong = o;
    }
    public void setLUONG_MAX(double o){
        this.LUONG_MAX = o;
    }



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


    public double tinhLuong(){
        return this.luongCoBan*this.heSoLuong;
    }
    public boolean tangLuong(double n){
        this.setHeSoLuong(this.getHeSoLuong() + n);
        if(this.tinhLuong()>this.LUONG_MAX){ this.setHeSoLuong(this.getHeSoLuong() - n); return false;}
        else return true;  
    }
    public void inTTin(){
        System.out.println("Ten nhan vien:\t"+getTenNhanVien());
        System.out.println("Luong co ban:\t"+getLuongCoBan());
        System.out.println("He so luong:\t"+getHeSoLuong());
        System.out.println("Luong:\t"+tinhLuong());
    }

}
class PhongBan{
    private String tenPhongBan; private byte soNhanVien;
    public static final int SO_NV_MAX = 100;
    private NhanVien[] dsnv;
    public boolean themNhanVien(NhanVien nv){
        if (soNhanVien < SO_NV_MAX){
            dsnv[soNhanVien] = nv; soNhanVien++;
            return true;
        } else return false;
    }
    public NhanVien xoaNhanVien(){
        if(soNhanVien > 0){
            NhanVien tmp = dsnv[soNhanVien-1];
            dsnv[soNhanVien-1] = null; soNhanVien--;
            return tmp;
        }else return null;
    }
    public PhongBan(String tenPB){
        dsnv = new NhanVien[SO_NV_MAX];
        tenPhongBan = tenPB; soNhanVien = 0;
    }
    public double tongLuong(){
        double tong = 0.0;
        for (int i=0; i<soNhanVien;i++)
            tong += dsnv[i].tinhLuong();
        return tong;
    }
    public void inTTin(){
        System.out.println("Ten phong: "+tenPhongBan);
        System.out.println("So NV: " + soNhanVien);
        System.out.println("Thong tin cac NV");
        for (int i=0; i<soNhanVien; i++)
            dsnv[i].inTTin();
    }
}
public class employeesBai5 {
    public static void main(String args[]){
        NhanVien nv1 = new NhanVien("Banh Thi Banh", 1000,4.0,10000.0);
        NhanVien nv2;
        nv2 = new NhanVien("Tong Thi Tong", 999, 3.8, 9000);
        nv1.inTTin();
        System.out.print("Luong moi: ");
        if(nv1.tangLuong(10)) System.out.println(nv1.tinhLuong());
            else System.out.println(nv1.getLUONG_MAX());
        nv2.inTTin();
        nv2.tangLuong(3);
        System.out.print("Luong moi: ");
        if(nv2.tangLuong(2)) System.out.println(nv2.tinhLuong());
            else System.out.println(nv2.getLUONG_MAX());
        System.out.println(NhanVien.soNhanVien);


        Random rand = new Random();
        int n = rand.nextInt(10);
        double sum = 0.0;
        NhanVien[] nv = new NhanVien[n];
        for (int i = 0; i < n; i++){
            nv[i] = new NhanVien("Nhan Vien", 1000, (double)(rand.nextInt(3)+rand.nextDouble()), 10000.0);
            sum += nv[i].tinhLuong();
        }
        System.out.println("Tong luong cua" + n + " nhan vien la: " + sum );
    }
}
