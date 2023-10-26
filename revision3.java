abstract class Shape{
    protected String color;
    protected boolean filled;

    public Shape(){
        color = "no-color";
        filled = false;
    }
    public Shape(String color, boolean filled){
        if(color.trim().equals("")) this.color = "no-color";
        else this.color = color;
        this.filled = filled;
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
        return "This is a shape";
    }
}

class Circle extends Shape{
    protected double radius;

    public Circle(){}
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
        return 3.14159265359*radius*radius;
    }
    @Override
    public double getPerimeter(){
        return 3.14159265359*radius*2.0;
    }
    @Override
    public String toString(){
        String yn;
        if (isFilled()) yn = "filled"; else yn = "transparent";
        return "A "+getColor()+" "+yn+" circle has a radius of "+getRadius()+", covers an area of "+getArea()+" and has a perimeter of "+getPerimeter();
    }
}

class Rectangle extends Shape{
    protected double width, length;
    
    public Rectangle(){}
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
    public String toString(){
        String yn;
        if((isFilled())) yn = "colored"; else yn = "transparent";
        return "A "+getColor()+" "+yn+" rectangle is "+width+" x "+length+" sized, covers an area of "+getArea()+" and has a perimeter of "+getPerimeter();
    }
}

class Square extends Rectangle{
    public Square(){}
    public Square(double side){
        super(side,side);
    }
    public Square(double side, String color, boolean filled){
        super(side,side,color,filled);
    }
    public double getSide(){
        return super.width;
    }
    public void setSide(double side){
        super.width = side;
        super.length = side;
    }
    @Override
    public void setWidth(double side){
        super.width = side;
    }
    @Override
    public void setLength(double side){
        super.length = side;
    }
    @Override
    public String toString(){
        String yn;
        if(isFilled()) yn = "colored"; else yn = "transparent";
        return "A "+getColor()+" "+yn+" square has a side of "+getSide()+", covers an area of "+getArea()+" and has a perimeter of "+getPerimeter();
    }
}

public class revision3 {
    public static void main(String args[]){
        Circle ht1 = new Circle(10.0,"red",true);
        System.out.println(ht1.toString());
        Rectangle hcn1 = new Rectangle(3.0,4.0,"",false);
        System.out.println(hcn1.toString());
        Square hv1 = new Square(10.0,"blue",true);
        System.out.println(hv1.toString());
        Square hv2 = new Square();
        System.out.println(hv2.toString());
    }
}