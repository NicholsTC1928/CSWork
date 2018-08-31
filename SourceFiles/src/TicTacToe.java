import java.util.Scanner;
import java.util.Random;

public class TicTacToe
{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        boolean useAI = false;
        System.out.println("Welcome to Tic-Tac-Toe! This was programmed by Tyler Nichols.");
        System.out.print("How many players will be participating? (Enter either a \"1\" or a \"2.\") ");
        boolean numCheck = true;
        int pCount = reader.nextInt();
        while(numCheck){
            if(pCount != 1 && pCount != 2){
                System.out.println("Invalid Input");
                System.out.print("How many players will be participating? (Enter either a \"1\" or a \"2.\") ");
                int pCountEdit = reader.nextInt();
                pCount = pCountEdit;
            }
            else numCheck = false;
        }
        String winner;
        if(pCount == 1){
            useAI = true;
            System.out.print("Enter Your Name: ");
            String name = reader.next(); //Winner declared as "winSolo"
            String nameAI = "CPU"; //Winner declared as "winAI"
            winner = gameAI(name, nameAI);
        }
        else{
            System.out.print("Enter the Name of Player 1: ");
            String name1 = reader.next(); //Winner declared as "winP1"
            System.out.print("Enter the Name of Player 2: ");
            String name2 = reader.next(); //Winner declared as "winP2"
            winner = game(name1, name2);
        }


    }

    public static String gameAI(String x, String y){ //Make 2-Player Game First

    }

    public static String game(String x, String y){
        Random rand = new Random();
        int startP = rand.nextInt(2) + 1; //2 is the maximum random integer, and 1 is the minimum.

    }
}
