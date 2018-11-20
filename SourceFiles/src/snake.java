import java.util.*;
import java.awt.*;

public class snake {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to (yet another game of) Snake! This was programmed by Tyler Nichols.");
        //String difficulty;
        System.out.print("Which difficulty do you want to play at? (1 - Easy / 2 - Normal / 3 - Hard / 4 - Mania) ");
        int dChoice;
        try{
           dChoice = input.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Invalid Input - Please enter a numeric value between 1 and 4 corresponding to the desired difficulty.");
            System.out.print("Which difficulty do you want to play at? (1 - Easy / 2 - Normal / 3 - Hard / 4 - Mania) ");
            dChoice = input.nextInt();
        }
        System.out.println(dChoice); //Debug
    }

    public static void game(){

    }

    public static int difficulty(){
        Scanner input = new Scanner(System.in);
        for(;;){

        }
    }
}
