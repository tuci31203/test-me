class Vector3D {
    private float x,y,z;
    
    public float getX(){
        return x;
    }
    
    public void setX(float x){
        this.x = x;
    }
    
    public float getY(){
        return y;
    }
    
    public void setY(float y){
        this.y = y;
    }
    
    public float getZ(){
        return z;
    }
    
    public void setZ(float z){
        this.z = z;
    }
    
    public Vector3D cong(Vector3D v){
        Vector3D out = new Vector3D();
        out.setX(this.x + v.x);
        out.setY(this.y + v.y);
        out.setZ(this.z + v.z);
        return out;
    }
    
    public Vector3D tru(Vector3D v){
        Vector3D out = new Vector3D();
        out.setX(this.x - v.x);
        out.setY(this.y - v.y);
        out.setZ(this.z - v.z);
        return out;
    }
    
    public Vector3D nhan(int n){
        Vector3D out = new Vector3D();
        out.setX(this.x*n);
        out.setY(this.y*n);
        out.setZ(this.z*n);
        return out;
    }
    
    public float tichvohuong(Vector3D v){
        float out = this.x*v.x + this.y*v.y + this.z*v.z;
        
        return out;
    }
    
}

 

 

public class TestVector3D{
    public static void main(String[] args){
        Vector3D v1 = new Vector3D();//tao 1 doi tuong cua lop Vector3D
        v1.setX(1.0f);
        v1.setY(2.0f);
        v1.setZ(3.0f);
        System.out.println("Vector1:x=" + v1.getX()+" y=" + v1.getY() + " z=" + v1.getZ());
        
        Vector3D v2 = new Vector3D();//tao 1 doi tuong cua lop Vector3D
        
        v2.setX(4.0f);
        v2.setY(5.0f);
        v2.setZ(6.0f);
        System.out.println("Vector2:x=" + v2.getX()+" y=" + v2.getY() + " z=" + v2.getZ());
        
        Vector3D v3 = v1.cong(v2);
        System.out.println("Cong 2 vector:x=" + v3.getX()+" y=" + v3.getY() + " z=" + v3.getZ());
        
        System.out.println("Cach1 - Tich vo huong 2 vector=" + v1.tichvohuong(v2));
        System.out.println("Cach2 - Tich vo huong 2 vector=" + v2.tichvohuong(v1));
    }

 

}