class NhanVien{
    private String tenNhanVien;
    private static double luongCoBan;
    private double heSoLuong;
    public static final double LUONG_MAX = 20000000;

    public NhanVien(String ten, double lcb, double hsl){
        if(ten.trim().equals("")) tenNhanVien = "Nhan vien chua co ten";
        else tenNhanVien = ten;
        if(lcb <= 0 || hsl <= 0){
            if (lcb <= 0) luongCoBan = 1000000;
            else luongCoBan = lcb;
            if (hsl <=0) heSoLuong = 3.0;
            else heSoLuong = hsl;
        }else if(hsl*lcb <= LUONG_MAX){
            luongCoBan = lcb;
            heSoLuong = hsl;
        }else System.out.println("Vuot qua muc luong toi da");
    }

    public boolean setTenNhanVien(String ten){
        if(ten.trim().equals("")){
            System.out.println("Nhan vien chua co ten");
            return false;
        }else{
            tenNhanVien = ten;
            return true;
        }
    }
    public boolean setLuongCoBan(double lcb){
        if(lcb <= 0 || lcb*heSoLuong > LUONG_MAX){
            System.out.println("Khong the thiet lap luong co ban (<0 hoac vuot qua luong_max)");
            return false;
        }else{
            luongCoBan = lcb;
            return true;
        }
    }
    public boolean setHeSoLuong(double hsl){
        if(hsl <= 0 || hsl*luongCoBan > LUONG_MAX){
            System.out.println("Khong the thiet lap he so luong (<0 hoac vuot qua luong_max)");
            return false;
        }else{
            heSoLuong = hsl;
            return true;
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

    public double tinhLuong(){
        return luongCoBan*heSoLuong;
    }
    
    public boolean tangHeSoLuong(double a){
        if(a<=0){
            System.out.println("Khong the tang he so luong");
            return false;
        }else if ((heSoLuong + a)*luongCoBan > LUONG_MAX){
            System.out.println("Vuot qua muc luong toi da");
            return false;
        }else{
            heSoLuong += a;
            return true;
        }
    }

    public void inTTin(){
        System.out.println("Ho va ten: " + getTenNhanVien() + " \tLuong co ban: " + getLuongCoBan() + " \tHe so luong: " + getHeSoLuong() + " \tLuong: " + tinhLuong());
    }
}

interface IQuanLy{
    public double tinhHoaHong();
}

class GiamDoc extends NhanVien implements IQuanLy{
    private double phuCap;
    public static double loiNhuanCongTy;

    public GiamDoc(String ten, double lcb, double hsl, double pc, double lnct){
        super(ten,lcb,hsl);
        if(pc <= 0) phuCap = 0.0;
        else phuCap = pc;
        if(lnct <= 0) lnct = 0.0;
        else loiNhuanCongTy = lnct;
    }
    public void setPhuCap(double pc){
        if(pc<=0) phuCap = 0.0;
        else phuCap = pc;
    }
    public void setLoiNhuanCongty(double lnct){
        if(lnct<=0) loiNhuanCongTy = 0.0;
        else loiNhuanCongTy = lnct;
    }
    public double getPhuCap(){
        return phuCap;
    }
    public double getLoiNhuanCongTy(){
        return loiNhuanCongTy;
    }

    @Override
    public double tinhHoaHong(){
        return (double)5/(double)100*loiNhuanCongTy;
    }

    @Override
    public double tinhLuong(){
        double luong = super.tinhLuong() + phuCap + tinhHoaHong();
        if(luong > LUONG_MAX) return LUONG_MAX;
        else return luong;
    }

    @Override
    public void inTTin(){
        System.out.println("Ten giam doc: "+getTenNhanVien()+" \tLuong co ban: "+getLuongCoBan()+" \tHe so luong: "+getHeSoLuong()+" \tPhu cap: "+getPhuCap()+" \tHoa hong: "+tinhHoaHong()+" \tLuong: "+tinhLuong());
    }
}

class CanBoQuanLy extends NhanVien implements IQuanLy{
    public static double loiNhuanCongTy;

    public CanBoQuanLy(String ten, double lcb, double hsl, double lnct){
        super(ten,lcb,hsl);
        if(lnct <=0) loiNhuanCongTy = 0.0;
        else loiNhuanCongTy = lnct;
    }
    public void setLoiNhuanCongTy(double lnct){
        if(lnct <=0) loiNhuanCongTy = 0.0;
        else loiNhuanCongTy = lnct;
    }
    public double getLoiNhuanCongTy(){
        return loiNhuanCongTy;
    }

    @Override
    public double tinhHoaHong(){
        return (double)2/(double)1000*loiNhuanCongTy;
    }
    @Override
    public double tinhLuong(){
        double luong = super.tinhLuong() + tinhHoaHong();
        if(luong>LUONG_MAX) return LUONG_MAX;
        else return luong;
    }
    @Override
    public void inTTin(){
        System.out.println("Ten can bo: "+getTenNhanVien()+" \tLuong co ban: "+getLuongCoBan()+" \tHe so luong: "+getHeSoLuong()+" \tHoa hong: "+tinhHoaHong()+" \tLuong: "+tinhLuong());
    }
}

public class revision02 {
    public static void main(String args[]){
        NhanVien nv1 = new NhanVien("Đây Là Tên",1000000.0,5.0);
        nv1.inTTin();
        nv1.tangHeSoLuong(2.0);
        nv1.inTTin();
        CanBoQuanLy cb1 = new CanBoQuanLy("", -100.0, 6.0, 100000000);
        cb1.inTTin();
        GiamDoc gd1 = new GiamDoc("Tên Giám Đốc", 2000000.0, 7.0, 1000000,100000000);
        gd1.inTTin();
    }
}
