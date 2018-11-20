import java.util.*;
import java.awt.*;

public class snake {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to (yet another game of) Snake! This was programmed by Tyler Nichols.");
        int dChoice = difficultyChoice();
        System.out.println(dChoice); //Debug
    }

    public static void game(){

    }

    public static int checkInput(){
        Scanner input = new Scanner(System.in);
        int inCheck;
        try{
            inCheck = input.nextInt();
        }
        catch(InputMismatchException e){
            return -1;
        }
        return inCheck;
     }
    public static int difficultyChoice(){
        Scanner dInput = new Scanner(System.in);
        int dChoice = -1;
        for(;;){
            System.out.print("Which difficulty do you want to play at? (1 - Easy / 2 - Normal / 3 - Hard / 4 - Mania) ");
            dChoice = checkInput();
            if(1 <= dChoice && 4 >= dChoice) break;
            System.out.println("Invalid Input - Please enter only a \"1,\" \"2,\" \"3,\" or a \"4.\"");
        }
        String[] diffList = {"Easy","Normal","Hard","Mania"};
        if(dChoice == 4){
            System.out.print("Wait, you actually chose Mania?! Are you sure that you want to play on this difficulty? It is not even remotely fair! (Enter a \"Y\" to continue, or any other key to choose a new difficulty.) ");
            String mConfirm = dInput.next().toLowerCase();
            if(mConfirm.equals("y")) return dChoice;
            else return -1;
        }
        System.out.println("You have chosen " + diffList[dChoice - 1] + " as your difficulty.");
        return dChoice;
    }
}
