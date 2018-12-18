package christmasGift;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String beginChoice;
        int pChoice = 0;
        boolean valueFound = false;
        while(!valueFound){
            try{
                Scanner nameInput = new Scanner(System.in);
                System.out.println("This program is dedicated to the following people:");
                System.out.println();
                System.out.println("1 - Mom (Bergen Nichols)");
                System.out.println("2 - Dad (Joseph Nichols)");
                System.out.println("3 - Lil' Yum Yum (Lauren Nichols)");
                System.out.println();
                System.out.print("Enter the number corresponding to your identity, or enter \"exit\" to quit the program. ");
                beginChoice = nameInput.next().toLowerCase();
                if(beginChoice.equals("exit")) System.exit(0);
                else pChoice = Integer.parseInt(beginChoice);
                if(pChoice < 1 || pChoice > 3) throw new InputMismatchException();
                valueFound = true;
            }
            catch(InputMismatchException e){
                System.out.println();
                System.out.println("Invalid Input");
                System.out.println();
            }
        }
        String name = "[Error]";
        intros a = new intros();
        String intro = a.chooseIntro(pChoice);
        switch(pChoice){
            case 1:
                name = "Mom";
                break;
            case 2:
                name = "Dad";
                break;
            case 3:
                name = "Lauren";
                break;
            default:
                break;
        }
        System.out.println();
        System.out.println("Merry Christmas, " + name + "!");
        System.out.println();
        System.out.println(intro);
        System.out.println();
        System.out.println("I love you, and I hope that you have a wonderful holiday! I will never forget what you have done for me!");
        System.out.println();
        boolean gameChoice = false;
        int gChoiceInt = 0;
        while(!gameChoice){
            try{
                Scanner inputGame = new Scanner(System.in);
                System.out.println("Here is a list of games for you to enjoy: ");
                System.out.println();
                System.out.println("1 - Tic-Tac-Toe");
                System.out.println("2 - Hangman");
                System.out.println("3 - [This option will quit the program.]");
                System.out.println();
                System.out.print("Enter the number corresponding to your desired choice: ");
                gChoiceInt = inputGame.nextInt();
                if(gChoiceInt < 1 || gChoiceInt > 3) throw new InputMismatchException();
                if(gChoiceInt == 3) System.exit(0);
                gameChoice = true;
            }
            catch(InputMismatchException e){
                System.out.println();
                System.out.println("Invalid Input");
                System.out.println();
            }
        }
        TicTacToe t = new TicTacToe();
        hangman h = new hangman();
        if(gChoiceInt == 1) t.gameTicTacToe();
        else h.hangmanGame();
    }
}
