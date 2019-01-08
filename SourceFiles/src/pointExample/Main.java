package pointExample;

public class Main {
    public static void main(String[] args){
        Point p1 = new Point(); //Notice that it is calling the Point class that is within this package.
        p1.x = 7;
        p1.y = 2;
        Point p2 = new Point();
        p2.x = 4;
        p2.y = 3;

        System.out.println("Point 1: (" + p1.x + ", " + p1.y + ")");
        System.out.println("Point 2: (" + p2.x + ", " + p2.y + ")");
    }
}
