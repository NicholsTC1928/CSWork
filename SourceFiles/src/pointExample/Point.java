package pointExample;

//A Point object represents a pair (x, y) coordinates.
public class Point {
    int x;
    int y;

    public void translate(int dx,int dy){
        this.x += dx;
        this.y += dy;
    }

    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
