package GameObjectTutorial;

public class GameObject {
    private int x; //X-Coordinate
    private int y; //Y-Coordinate

    public GameObject(){
        this.x = 0;
        this.y = 0;
    }

    public GameObject(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void setXY(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
