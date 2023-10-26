class HinhTron {
    private float bk;
    
    public float getBk(){
        return bk;
    }
    
    public void setBk(float bk){
        this.bk = bk;
    }
}

 

class HinhVuong {
    private float c;
    
    public float getCanh(){
        return c;
    }
    
    public void setCanh(float c){
        this.c = c;
    }
}

 

public class TestHinhHoc{
    public static void main(String[] args){
        HinhVuong hv = new HinhVuong();//tao 1 doi tuong cua lop Hinh vuong
        hv.setCanh(10.0f);
        System.out.println("canh cua hv:"+hv.getCanh());
        
        HinhTron ht = new HinhTron();//tao 1 doi tuong cua lop Hinh tron
        ht.setBk(10.0f);
        System.out.println("bk cua ht:"+ht.getBk());
    }

 

}