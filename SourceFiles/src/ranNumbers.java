import java.util.*;
public class ranNumbers {
    public static void main(String[] args){
        Random r = new Random();
        /* This creates a pseudorandom number generator. It takes 0 parameters or a long parameter. The parameter is the
        seed, but if one is not provided, it uses the time for a seed.
         */
        int sixSidedRoll = r.nextInt(6);
        //This gives a random number between 0 and 5.
        sixSidedRoll = r.nextInt(6) + 1;
        //This increases the numbers in the range by 1, giving a random number between 1 and 6.
        System.out.println("The rolled number is " + sixSidedRoll + ".");

        //Here are some useful methods from the Random class:
        int rInt = r.nextInt(); //Between (-2)^31 and ((-2)31) - 1
        System.out.println("The value of rInt is " + rInt + ".");
        double rDouble = r.nextDouble();
        System.out.println("The value of rDouble is " + rDouble + ".");
        boolean rBoolean = r.nextBoolean();
        System.out.println("The value of rBoolean is " + rBoolean + ".");

    }
}
