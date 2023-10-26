abstract class Shape{
    protected String color;
    protected boolean filled;

    public Shape(){
        color = "transparent";
        filled = false;
    };
    public Shape(String c, boolean f){
        color = c;
        filled = f;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public boolean isFilled(){
        return filled;
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public String toString(){
        return "this is a shape";
    }
}

interface ICircle{
    public final double pi = 3.14159265359;
}

interface IBoundary{
    public static double max = 10.0;
    public void check();
}

class Circle extends Shape implements ICircle{
    protected double radius;
    public Circle(){};
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled){
        super(color,filled);
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }

    @Override
    public double getArea(){
        return pi * radius * radius;
    }
    @Override
    public double getPerimeter(){
        return pi * 2.0 * radius;
    }
    public String toString(){
        String hasColor;
        if (isFilled()) hasColor = "co"; else hasColor = "khong";
        return "Hinh tron "+hasColor+" mau "+ getColor() +" co ban kinh: "+ radius +" Dien tich: "+ getArea() +" Chu vi: "+ getPerimeter();
    }
}

class Rectangle extends Shape implements IBoundary{
    protected double width, length;
    public Rectangle(){};
    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }
    public Rectangle(double width, double length, String color, boolean filled){
        super(color,filled);
        this.width = width;
        this.length = length;
    }
    public double getWidth(){
        return width;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public double getLength(){
        return length;
    }
    public void setLength(double length){
        this.length = length;
    }
    @Override
    public double getArea(){
        return width*length;
    }
    @Override
    public double getPerimeter(){
        return 2.0*(width+length);
    }

    @Override
    public void check(){
        if(getArea() > max) System.out.println("Exceed max size");
        else System.out.println("Beautifully fit");
    }
    
    public String toString(){
        String hasColor;
        if (isFilled()) hasColor = "co"; else hasColor = "khong";
        return "Hinh chu nhat "+hasColor+" mau "+ getColor() +" co kich thuoc: "+ getWidth() +" x "+ getLength() +" Dien tich: "+ getArea() +" Chu vi: "+ getPerimeter();
    }
}

class Square extends Rectangle{
    public Square(){};
    public Square(double side){
        super(side,side);
    }
    public Square(double side, String color, boolean filled){
        super(side,side,color,filled);
    }
    public double getSide(){
        return getWidth();
    }
    public void setSide(double side){
        setWidth(side);
        setLength(side);
    }
    public void setWidth(double side){
        super.setWidth(side);
    }
    public void setLength(double side){
        super.setLength(side);
    }
    
    public String toString(){
        String hasColor;
        if (isFilled()) hasColor = "co"; else hasColor = "khong";
        return "Hinh vuong "+hasColor+" mau "+ getColor() +" co canh: "+ getSide() +" Dien tich: "+ getArea() +" Chu vi: "+ getPerimeter();
    }
}
 

public class revisionck {
    public static void main(String args[]){
        Circle ht1 = new Circle(2.0,"red",true);
        System.out.println(ht1.toString());
        Rectangle hcn1 = new Rectangle(10.0,12.0,"blue",false);
        System.out.println(hcn1.toString());
        hcn1.check();
        Square hv1 = new Square(10.0,"green",false);
        System.out.println(hv1.toString());
        hv1.check();
    }
}