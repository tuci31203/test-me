package myClassPackage;

public class vector {
    private double x, y, z;
    public void setVector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void getVector(){
        System.out.println(x+","+y+","+z);
    }
    public vector addVector(vector b){
        vector result = new vector();
        result.x = this.x + b.x;
        result.y = this.y + b.y;
        result.z = this.z + b.z;
        return result;
    }
    public vector minusVector(vector b){
        vector result = new vector();
        result.x = this.x - b.x;
        result.y = this.y - b.y;
        result.z = this.z - b.z;
        return result;
    }
    public vector mutiplyWith(double b){
        vector result = new vector();
        result.x = this.x*b;
        result.y = this.y*b;
        result.z = this.z*b;
        return result;
    }
    public double dotProductVectors(vector b){
        return this.x*b.x + this.y*b.y +this.z*b.z;
    }
}
