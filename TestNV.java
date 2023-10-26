class NhanVien{

    private String tenNhanVien;
    private double luongCoBan;
    private double heSoLuong;
    private double Luong_Max;
    
    public NhanVien(String tenNhanVien, double luongCoBan, double heSoLuong, double Luong_Max){
    if(tenNhanVien.trim().equals(""))
    this.tenNhanVien="Nhan vien chua co ten";
    else
    this.tenNhanVien=tenNhanVien;
    
    if((luongCoBan<=0)||(heSoLuong<=0)){
    System.out.println("Cac thuoc tinh < 0, su dung thuoc tinh co ban");
    
     
    
    if(heSoLuong<=0)
    this.heSoLuong=1.2;
    else this.heSoLuong=heSoLuong;
    
    if(luongCoBan<=0)
    this.luongCoBan=1000000;
    else this.luongCoBan=luongCoBan;
    
    if(this.luongCoBan*this.heSoLuong <= Luong_Max){
    this.Luong_Max = Luong_Max;
    }
    else {
    this.Luong_Max = this.heSoLuong*this.luongCoBan;
    }
    }
    else if(luongCoBan*heSoLuong <= Luong_Max){
    this.heSoLuong=heSoLuong;
    this.luongCoBan=luongCoBan;
    this.Luong_Max = Luong_Max;
    }
    else {
    System.out.println("Thuoc tinh Luong_Max ko thoa man, su dung thuoc tinh Luong_Max mac dinh");
    this.heSoLuong=heSoLuong;
    this.luongCoBan=luongCoBan;
    this.Luong_Max = this.heSoLuong*this.luongCoBan;
    }
    }
    
    public double getHeSoLuong() {
    return heSoLuong;
    }
    
    public double getLuongCoBan() {
    return luongCoBan;
    }
    
    public String getTenNhanVien() {
    return tenNhanVien;
    }
    
    public boolean setHeSoLuong(double hsl) {
    if(hsl <= 0){
    System.out.println("Khong the thiet lap duoc he so luong < 0");
    return false;
    }
    
    if(luongCoBan*hsl <= Luong_Max){
    heSoLuong = hsl;
    return true;
    }
    else{
    System.out.println("Khong the thiet lap duoc he so luong");
    return false;
    }
    }
    
    public boolean setLuongCoBan(double lcb) {
    if(lcb <= 0){
    System.out.println("Khong the thiet lap duoc luong co ban < 0");
    return false;
    }
    
    if(lcb*heSoLuong <= Luong_Max){
    luongCoBan = lcb;
    return true;
    }
    else{
    System.out.println("Khong the thiet lap duoc luong co ban");
    return false;
    }
    }
    
    public boolean setTenNhanVien(String tnv) {
    if(tnv.trim().equals("")){
    System.out.println("Khong the thiet lap duoc ten nhan vien la rong");
    return false;
    }
    else{
    tenNhanVien = tnv;
    return true;
    }
    }
    
    public double tinhLuong(){
    return luongCoBan*heSoLuong;
    }
    
    public boolean tangLuong(double k){
    if(k<=0) {
    System.out.println("Khong the thiet lap duoc k < 0");
    return false;
    }
    
    if(k*luongCoBan > Luong_Max){
    System.out.println("Khong tang luong cho nhan vien "+tenNhanVien+" vi vuot qua gioi han luong");
    return false;
    }
    else{
    heSoLuong = k;
    return true;
    }
    }
    
    public void inInformation(){
    System.out.println("Nhan vien co ten:'"+this.tenNhanVien+"' co luong co ban "+this.luongCoBan+" co he so luong "+this.heSoLuong+" co luong la "+tinhLuong());
    }
    
     
    
    }
    
     
    
    public class TestNV {
    public static void main(String[] args){
    NhanVien T1 = new NhanVien("Quoc Tuan",1000000,6.5,15000000);
    NhanVien T2 = new NhanVien("Trong Tuan",2000000,5.1,15000000);
    NhanVien T3 = new NhanVien(" ",2000000,5.1,15000000);
    T1.tangLuong(16.5);
    T1.inInformation();
    T2.inInformation();
    T3.inInformation();
    }
    }