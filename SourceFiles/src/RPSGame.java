import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
public class RPSGame {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Rock Paper Scissors!");
        //The following lines of code combine Exercises 1 and 3 into one program.
        System.out.print("Would you like to play a game against the computer (1), or compare the stats of 2 players (2)? ");
        int choice = input.nextInt();
        while(choice != 1 && choice != 2){
            System.out.println("Invalid Input");
            System.out.print("Would you like to play a game against the computer (1), or compare the stats of 2 players (2)? ");
            choice = input.nextInt();
        }
        if(choice == 1){
            boolean go = true;
            while(go){
                go = game();
            }
        }
        else compare();
    }

    public static boolean game(){
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        String moveP = "null";
        while(!moveP.equals("rock") && !moveP.equals("paper") && !moveP.equals("scissors")){ //Making sure the input is valid
            System.out.print("Enter either \"rock,\" \"paper,\" or \"scissors\" to make your move. ");
            moveP = input.next().toLowerCase();
            if(!moveP.equals("rock") && !moveP.equals("paper") && !moveP.equals("scissors")) System.out.println("Invalid Input");
        }
        String[] cpuChoices = new String[]{"rock","paper","scissors"}; //Storing all possible CPU choices
        String moveCPU = cpuChoices[r.nextInt(3)]; //Choosing a random move for the CPU
        System.out.println("You chose " + moveP + ", while the CPU chose " + moveCPU + ".");
        //Checking for victories begins here
        String pWin = "You win this round.";
        String cpuWin = "The CPU wins this round.";
        if((moveP.equals("rock") && moveCPU.equals("paper")) ||(moveP.equals("paper") && moveCPU.equals("rock"))){ //Rock and Paper
            //Paper beats rock
            if(moveP.equals("paper")) System.out.println(pWin);
            else System.out.println(cpuWin);
        }
        if((moveP.equals("paper") && moveCPU.equals("scissors")) || (moveP.equals("scissors") && moveCPU.equals("paper"))){ //Paper and Scissors
            //Scissors beat paper
            if(moveP.equals("scissors")) System.out.println(pWin);
            else System.out.println(cpuWin);
        }
        if((moveP.equals("rock") && moveCPU.equals("scissors")) || (moveP.equals("scissors") && moveCPU.equals("rock"))){ //Rock and Scissors
            //Rock beats scissors
            if(moveP.equals("rock")) System.out.println(pWin);
            else System.out.println(cpuWin);
        }
        if(moveP.equals(moveCPU)) System.out.println("Since both are the same choice, this round is a draw."); //Both are the same
        System.out.print("Would you like to play again? (Enter \"y\" to start a new round, or any other key to quit.) ");
        String cont = input.next().toLowerCase();
        if(cont.equals("y")) return true; //Checks to see if the player wants to start a new round
        else return false;
    }

    public static void compare(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of the first person here. ");
        String name1 = input.next();
        System.out.print("Enter the name of the second person here. ");
        String name2 = input.next();
        int play1 = -1;
        int play2 = -1;
        int win1 = -1;
        int win2 = -1;
        int moves1 = -1;
        int moves2 = -1;
        while(play1 < 0){
            //The check for < 0 for two if-statements works, because it is impossible to play a negative number of
            //games or have a negative number of wins.
            System.out.print("How many times has " + name1 + " played Rock Paper Scissors? ");
            play1 = check();
        }
        while(play2 < 0){
            System.out.print("How many times has " + name2 + " played Rock Paper Scissors? ");
            play2 = check();
        }
        while(win1 < 0){
            System.out.print("How many times has " + name1 + " won? ");
            win1 = check();
        }
        while(win2 < 0){
            System.out.print("How many times has " + name2 + " won? ");
            win2 = check();
        }
        while(moves1 <= 0){
            //It is impossible to win a game with <= 0 turns.
            System.out.print("What was the lowest number of turns required for " + name1 + " to win a round? ");
            moves1 = check();
        }
        while(moves2 <= 0){
            System.out.print("What was the lowest number of turns required for " + name2 + " to win a round? ");
            moves2 = check();
        }
        if(play1 > play2) System.out.println(name1 + " has played the most rounds.");
        else if(play1 < play2) System.out.println(name2 + " has played the most rounds.");
        else System.out.println("Both players have an equal amount of total rounds played.");
        if(win1 > win2) System.out.println(name1 + " has won the most rounds.");
        else if(win1 < win2) System.out.println(name2 + " has won the most rounds.");
        else System.out.println("Both players have an equal amount of wins.");
        if(moves1 < moves2) System.out.println(name1 + " won a round with the lowest amount of turns.");
        else if(moves1 > moves2) System.out.println(name2 + " won a round with the lowest amount of turns.");
        else System.out.println("Both players won their quickest round in the same amount of turns.");
    }

    public static int check(){
        //This method is dedicated to making sure that the values entered for Exercise 3 are integers greater than 0.
        Scanner input = new Scanner(System.in);
        int a;
        try{
            a = input.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Invalid Input");
            a = -1;
        }
        if(a < 0) System.out.println("Invalid Input");
        return a;
    }
}
