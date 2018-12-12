import java.awt.Point; //Point class
import java.util.Arrays;
import java.awt.geom.Point2D; //Points using doubles

public class arraysOfObjects {
    //Arrays of objects are created in the same way.
    public static void main(String[] args){
        //For this part, we will shift the values in an array one index to the left. The value in index 0 must then move
        //to the end of the array.
        int[] shiftArray = {1,2,3,4,5};
        System.out.println("Starting Array: " + Arrays.toString(shiftArray));
        shiftOne(shiftArray); //Remember that the array is changed for the entire program when it is changed in just one method.
        System.out.println("Shifted Array: " + Arrays.toString(shiftArray));

        Point[] points = new Point[2]; //This creates an object array with two objects. Since it is an object array, the
        //word new must be used when creating it.
        Point a = new Point(-5,4); //This creates a point at x = -5 and y = 4.
        //You must then add the values to the object array.
        points[0] = a;
        //Here is a more efficient method for doing this:
        points[1] = new Point(4,9);
        System.out.println("Points Array: " + Arrays.toString(points));
        //The important thing to remember is that when making an object, each instance of the object needs the "new"
        //keyword.

        double slope = 0.5;
        double yInt = 4;
        Point2D[] graphThis = grapher(slope,yInt); //Remember that Point2D is only used so that double values are supported.
        System.out.println(Arrays.toString(graphThis));
    }

    public static void shiftOne(int[] targetArray){
        int first = targetArray[0];
        //The important part of the following loop is the "a < targetArray.length - 1" condition. This is because we want
        //the loop to stop at the index one before the last. If we do not, then an IndexOutOfBoundsException error will
        //be thrown.
        for(int a = 0;a < (targetArray.length - 1);a++){
            targetArray[a] = targetArray[a + 1];
        }
        targetArray[(targetArray.length - 1)] = first;
    }

    public static Point2D[] grapher(double slope,double yInt){
        Point2D[] returnArray = new Point2D[100]; //A Point2D array stores points with x- and y-values, with each point
        //making up one element of the array.
        double x = 0.0;
        double y = 0.0;
        for(int i = -50;i < 50;i++){
            x = (double) i;
            y = (slope * x) + yInt; //This is the equivalent of y=mx+b from traditional algebra.
            returnArray[i + 50] = new Point2D.Double(x,y);
        }
        return returnArray;
    }
}
