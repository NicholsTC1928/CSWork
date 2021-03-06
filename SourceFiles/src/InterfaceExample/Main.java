package InterfaceExample;

public class Main {
    public static void main(String[] args){
        //For this example, we will be creating and implementing an interface.
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle(18,18);
        shapes[1] = new Circle(12);
        shapes[2] = new Triangle(3,4,5);

        for(int i = 0;i < shapes.length;i++){
            System.out.println("Area = " + shapes[i].getArea() + " / Perimeter = " + shapes[i].getPerimeter());
        }
    }
}
