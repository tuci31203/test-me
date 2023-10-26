import myClassPackage.NhanVien;
public class tryStuff {
    public static void main(String[] args){
        NhanVien a = new NhanVien();
        a.setTenNhanVien("Banh Thi Banh");
        a.setHeSoLuong(4.0);
        a.setLuongCoBan(30000000);
        a.setLUONG_MAX(1000000000);
        a.inTTin();
        a.tangLuong(1000);
    }
}