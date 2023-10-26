class NhanVien{
    protected String tenNhanVien;
    protected double heSoLuong;
    public static final double LUONG_CO_BAN=750000.0, LUONG_MAX = 20000000.0;
    
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
        }else if(a*LUONG_CO_BAN > LUONG_MAX){
            System.out.println("Can't set He So Luong");
            return false;
        }else{
            this.heSoLuong = a;
            return true;
        }
    }

    public String getTenNhanVien(){
        return tenNhanVien;
    }
    public double getLuongCoBan(){
        return LUONG_CO_BAN;
    }
    public double getHeSoLuong(){
        return heSoLuong;
    }

    public NhanVien(String ten, double hsl){
        if(ten == " ") this.tenNhanVien = "No Name";
            else this.tenNhanVien = ten;
        if(hsl<=0) this.heSoLuong = 3.0;
            else if(hsl*LUONG_CO_BAN > LUONG_MAX) System.out.println("Can't set He So Luong");
                else this.heSoLuong = hsl;
    }

    public double tinhLuong(){
        return LUONG_CO_BAN*heSoLuong;
    }

    public boolean tangLuong(double a){
        if(a<=0){
            System.out.println("Error: VALUE<=0");
            return false;
        }else if((getHeSoLuong() + a)*LUONG_CO_BAN > LUONG_MAX){
            System.out.println("Error: Exceed LUONG_MAX");
            return false;
        }else{
            this.heSoLuong += a;
            return true;
        }
    }
    public void inTTin(){
        System.out.println("Ten nhan vien: " + getTenNhanVien() + " \tLuong co ban: " + LUONG_CO_BAN + " \tHe so luong: " + getHeSoLuong() + " \tLuong: " + tinhLuong());
    }
    
}


class TruongPhong extends NhanVien{
    private double phuCap, soNamDuongChuc;

    public TruongPhong(String ten, double hsl, double pc, double sndc){
        super(ten, hsl);
        if(pc < 0) phuCap =0.0; else phuCap = pc;
        if(sndc < 0) soNamDuongChuc = 1; else soNamDuongChuc = sndc;
    }
    @Override
    public double tinhLuong(){
        double luong = LUONG_CO_BAN * getHeSoLuong() + phuCap;
        if(luong > LUONG_MAX) return LUONG_MAX;
            else return luong;
    }
    @Override
    public void inTTin(){
        System.out.println("Ten truong phong: " + getTenNhanVien() +"\tLuong co ban: " + LUONG_CO_BAN + "\t He so luong: "+ getHeSoLuong() + " \tLuong: " + tinhLuong() + " \tPhu cap: "+ phuCap +" \t So nam duong chuc: " +soNamDuongChuc);
    }
}

public class NhanVienChuong7b5 {
    public static void main(String args[]){
        NhanVien nv1 = new NhanVien("Nguyen Van A",5.5);
        nv1.inTTin();
        nv1.tangLuong(1.0);
        nv1.inTTin();
        TruongPhong tp1 = new TruongPhong("Tran Hoang B",7.0,1000000,2);
        tp1.inTTin();
    }
    
}
