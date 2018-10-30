import java.util.Scanner;
import java.util.Random;
public class RPSGame {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Rock Paper Scissors! You will be playing against the computer in this game.");
        boolean go = true;
        while(go){
            go = game();
        }
    }

    public static boolean game(){
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        String moveP = "null";
        while(!moveP.equals("rock") && !moveP.equals("paper") && !moveP.equals("scissors")){ //Making sure the input is valid
            System.out.print("Enter either \"rock,\" \"paper,\" or \"scissors\" to make your move.");
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
        System.out.print("Would you like to play again? (Enter a \"y\" to continue, or any other key to quit.)");
        String cont = input.next().toLowerCase();
        if(cont.equals("y")) return true;
        else return false;
    }
}
