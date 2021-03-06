package InterfaceExample;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        return (this.width * this.height);
    }

    public double getPerimeter(){
        return (2.0 * (this.width + this.height));
    }
}
