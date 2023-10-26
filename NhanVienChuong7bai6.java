class NhanVien{
    private String tenNhanVien;
    private  double heSoLuong;
    private static double luongCoBan;
    public static final double LUONG_MAX = 20000000.0;
    
    public boolean setTenNhanVien(String a){
        if(a.trim().equals("")){
            System.out.println("Can't set Ten Nhan Vien");
            return false;
        }else{
            this.tenNhanVien = a;
            return true;
        }
    }
    public boolean setHeSoLuong(double a){
        if(a<=0){
            System.out.println("Warning this value can not be < 0");
            return false;
        }else if(a*luongCoBan > LUONG_MAX){
            System.out.println("Can't set He So Luong");
            return false;
        }else{
            this.heSoLuong = a;
            return true;
        }
    }
    public boolean setLuongCoBan(double a){
        if (a<=0){
            System.out.println("ERROR: VALUE <=0 ");
            return false;
        }else if(a*heSoLuong <= LUONG_MAX){
            luongCoBan = a;
            return true;
        }else{
            System.out.println("Can't set Luong Co Ban");
            return false;
        }
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

    public NhanVien(String ten, double lcb, double hsl){
        if(ten == " ") this.tenNhanVien = "No Name";
            else this.tenNhanVien = ten;
        if((hsl<=0)||(lcb<=0)){
            if (hsl <= 0) heSoLuong = 3.0;
            else heSoLuong = hsl;
            if (lcb <= 0) luongCoBan = 1000000;
        }else if(lcb*hsl <= LUONG_MAX){
            luongCoBan = lcb;
            heSoLuong = hsl;
        }else{
            System.out.println("ERROR: Exceed LUONG_MAX");
        }
        
    }

    public double tinhLuong(){
        return luongCoBan*heSoLuong;
    }

    public boolean tangLuong(double a){
        if(a<=0){
            System.out.println("Error: VALUE<=0");
            return false;
        }else if((getHeSoLuong() + a)*luongCoBan > LUONG_MAX){
            System.out.println("Error: Exceed LUONG_MAX");
            return false;
        }else{
            this.heSoLuong += a;
            return true;
        }
    }
    public void inTTin(){
        System.out.println("Ten nhan vien: " + getTenNhanVien() + " \tLuong co ban: " + luongCoBan + " \tHe so luong: " + getHeSoLuong() + " \tLuong: " + tinhLuong());
    }
    
}

interface IQuanLy{
    public double tinhHoaHong();
}


class GiamDoc extends NhanVien implements IQuanLy{
    private double phuCap;
    public static double loiNhuanCongTy;

    public GiamDoc(String ten, double lcb, double hsl, double pc, double lnct){
        super(ten, lcb, hsl);
        if(pc < 0) phuCap =0.0; else phuCap = pc;
        if(lnct < 0) loiNhuanCongTy = 0.0; else loiNhuanCongTy = lnct;
    }
    @Override
    public double tinhHoaHong(){
        return (double)5/(double)100*loiNhuanCongTy;
    }
    @Override
    public double tinhLuong(){
        double luong = getLuongCoBan() * getHeSoLuong() + phuCap + tinhHoaHong();
        if(luong > LUONG_MAX) return LUONG_MAX;
            else return luong;
    }
    @Override
    public void inTTin(){
        System.out.println("Ten truong phong: " + getTenNhanVien() +"\tLuong co ban: " + getLuongCoBan() + " \t He so luong: "+ getHeSoLuong() + " \tLuong: " + tinhLuong() + " \tPhu cap: "+ phuCap +" \t Hoa hong: " + tinhHoaHong());
    }
}

class CanBoQuanLy extends NhanVien implements IQuanLy{
    public static double loiNhuanCongTy;

    public CanBoQuanLy(String ten, double lcb, double hsl, double lnct){
        super(ten,lcb,hsl);
        if(lnct<0) loiNhuanCongTy = 0.0; else loiNhuanCongTy = lnct;
    }

    @Override
    public double tinhHoaHong(){
        return (double)2/(double)1000 * loiNhuanCongTy;
    }
    @Override
    public double tinhLuong(){
        double luong = getLuongCoBan() * getHeSoLuong() +tinhHoaHong();
        if(luong >LUONG_MAX) return LUONG_MAX;
            else return luong;
    }
    @Override
    public void inTTin(){
        System.out.println("Ten can bo quan ly: " + getTenNhanVien() +"\tLuong co ban: " + getLuongCoBan() + " \t He so luong: "+ getHeSoLuong() + " \tLuong: " + tinhLuong() + " \t Hoa hong: " + tinhHoaHong());
    }
}

public class NhanVienChuong7bai6 {
    public static void main(String args[]){
        NhanVien nv1 = new NhanVien("Nguyen Van A",2000000,5.5);
        nv1.inTTin();
        nv1.tangLuong(1.0);
        nv1.inTTin();
        GiamDoc gd1 = new GiamDoc("Tran Hoang B",2000000,7.0,1000000,100000000);
        gd1.inTTin();
        CanBoQuanLy cb1 = new CanBoQuanLy("Mai Thanh C",2000000,6.0,100000000);
        cb1.inTTin();
    }
    
}