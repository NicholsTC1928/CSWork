package pointExample;

//A Point object represents a pair (x, y) coordinates.
public class Point {
    int x;
    int y;

    //The following method is called a constructor. It defines how an object of the same name as the class is created.
    public Point(int x,int y){
        //Since the parameter has the same name as the field, use the "this" keyword to refer to the field.
        this.x = x;
        this.y = y;
        //Personally, I think that it is best to always use the "this" keyword; it helps to keep things clear.
    }

    //There is no limit to the amount of constructors that one class can have, and constructors can refer to other
    //constructors by using "this([Parameters])."
    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public void translate(int dx,int dy){
        this.x += dx;
        this.y += dy;
    }

    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
