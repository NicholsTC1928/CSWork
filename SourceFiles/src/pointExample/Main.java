package pointExample;

public class Main {
    public static void main(String[] args){
        Point p1 = new Point(7,2); //Notice that it is calling the Point class that is within this package.
        Point p2 = new Point();

        System.out.println("Point 1: (" + p1.x + ", " + p1.y + ")");
        System.out.println("Point 2: (" + p2.x + ", " + p2.y + ")");
        //With the overridden toString() method found in the Point class, you may also print the points like this:
        System.out.println("Point 1: " + p1);
        System.out.println("Point 2: " + p2);

        p2.translate(-3,12);
        System.out.println("New Point 2: " + p2);
    }
}
