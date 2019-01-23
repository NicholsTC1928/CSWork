package GameObjectTutorial;

public class MovableObject extends GameObject {
    int speed;
    String direction;

    public MovableObject(){
        //The constructor from the base class must be used.
        super(); //This uses the constructor from the base class.
        this.speed = 0;
        this.direction = "North";
    }

    public void changeDirection(String dir){
        this.direction = dir;
    }

    public void changeSpeed(int speed){
        this.speed = speed;
    }
}
