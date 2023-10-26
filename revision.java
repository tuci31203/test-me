class NhanVien{
    protected String tenNhanVien;
    protected double heSoLuong;
    public static final double LUONG_CO_BAN = 750000, LUONG_MAX = 20000000;

    public NhanVien(String ten, double hsl){
        if(ten.trim().equals("")) tenNhanVien ="Nhan vien chua co ten";
        else tenNhanVien = ten;
        if( hsl<0 ) hsl = 3.0;
        else if (hsl * LUONG_CO_BAN > LUONG_MAX)
            System.out.println("Vuot qua luong toi da");
        else heSoLuong = hsl;
    }

    public boolean setTenNhanVien(String ten){
        if (ten.trim().equals("")){
            System.out.println("Nhan vien chua co ten");
            return false;
        } else {
            tenNhanVien = ten;
            return true;
        }
    }

    public boolean setHeSoLuong(double hsl){
        if(hsl <= 0){
            System.out.println("Khong the thiet lap he so luong"); 
            return false;
        }else if(hsl*LUONG_CO_BAN <= LUONG_MAX){
            heSoLuong = hsl;
            return true;
        }else{
            System.out.println("Khong the thiet lap he so luong");
            return false;
        }
    }
    public String getTenNhanVien(){
        return tenNhanVien;
    }
    public double getHeSoLuong(){
        return heSoLuong;
    }


    public double tinhLuong(){
        return heSoLuong*LUONG_CO_BAN;
    }

    public boolean tangLuong(double a){
        if(a<=0){
            System.out.println("Khong the tang luong");
            return false;
        }else if((getHeSoLuong()+a) * LUONG_CO_BAN > LUONG_MAX){
            System.out.println("Khong the tang luong");
            return false;
        }else{
            heSoLuong += a;
            return true;
        }
    }

    public void inTTin(){
        System.out.println("Ho va ten: " + getTenNhanVien() + " \tHe so luong: " + getHeSoLuong() + " \tLuong: "+tinhLuong());
    }
}

class TruongPhong extends NhanVien{
    private double phuCap, soNamDuongChuc;

    public TruongPhong(String ten, double hsl, double pc, double sndc){
        super(ten,hsl);
        if(pc <= 0) phuCap = 0.0;
        else phuCap = pc;
        if(sndc < 1) soNamDuongChuc = 1;
        else soNamDuongChuc = sndc;
    }

    @Override
    public double tinhLuong(){
        double luong = super.tinhLuong() + phuCap;
        if(luong > LUONG_MAX) return LUONG_MAX;
        else return luong;
    }
    @Override
    public void inTTin(){
        System.out.println("Ho va ten truong phong: " + getTenNhanVien() + " \tHe so luong: " + getHeSoLuong() + " \tPhu cap: " + phuCap + " \tSo nam duong chuc: " + soNamDuongChuc + " \tLuong: "+tinhLuong());
    }
}

public class revision{
    public static void main(String args[]){
        NhanVien nv1 = new NhanVien("", 10.0);
        nv1.inTTin();
        nv1.tangLuong(5.0);
        nv1.inTTin();
        TruongPhong tp1 = new TruongPhong("Nguyễn Cái Tên",10.0,1000000,3);
        tp1.inTTin();
    }
}