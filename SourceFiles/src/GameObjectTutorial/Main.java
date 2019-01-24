package GameObjectTutorial;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        MovableObject myObject = new MovableObject();
        System.out.println("Object X-Position: " + myObject.getX());
        whatAmI(myObject);

        String myString = "hello";
        whatAmI(myString);

        Integer myInt = new Integer(4); //This code is deprecated, and should not be used in an actual program.
        //It is only used here for demonstration purposes.
        whatAmI(myInt);

        Random r = new Random();
        whatAmI(r);
    }

    public static void whatAmI(Object obj){
        System.out.println("I am a " + obj.getClass().getName());
        if(obj.getClass().getName().equals("MovableObject")){
            System.out.println("This is my own class.");
            System.out.println();
        }
        else{
            System.out.println("This is not my own class.");
            System.out.println();
        }
    }
}
